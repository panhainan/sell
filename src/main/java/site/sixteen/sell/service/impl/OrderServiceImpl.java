package site.sixteen.sell.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sixteen.sell.dao.OrderDetailRepository;
import site.sixteen.sell.dao.OrderMasterRepository;
import site.sixteen.sell.dto.CartDTO;
import site.sixteen.sell.dto.OrderDTO;
import site.sixteen.sell.entity.OrderDetail;
import site.sixteen.sell.entity.OrderMaster;
import site.sixteen.sell.entity.ProductInfo;
import site.sixteen.sell.enums.ResultMsgEnum;
import site.sixteen.sell.exception.SellException;
import site.sixteen.sell.service.OrderService;
import site.sixteen.sell.service.ProductService;
import site.sixteen.sell.utils.KeyUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderServiceImpl
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 订单业务逻辑层接口实现
 * @date 2018/9/8
 */
@Service("orderMasterService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductService productService;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        // 1.查询商品（数量、价格）
        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productService.getBy(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultMsgEnum.PRODUCT_NOT_EXIST);
            }
            // 2.计算总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
            // 3.写入订单数据库 OrderMaster OrderDetail
            // 3.1 OrderDetail 入库
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetailList);
        }
        //3.2 OrderMaster 入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster, "orderStatus", "payStatus");
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        // 4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO getOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderMaster> listBy(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
