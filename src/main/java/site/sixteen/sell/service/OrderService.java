package site.sixteen.sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.sixteen.sell.dto.OrderDTO;
import site.sixteen.sell.entity.OrderMaster;

/**
 * OrderService
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 订单业务逻辑层接口
 * @date 2018/9/8
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO 订单DTO对象
     * @return OrderDTO
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查找单个订单
     *
     * @param orderId 订单ID
     * @return OrderDTO
     */
    OrderDTO getOne(String orderId);

    /**
     * 通过买家openid分页获取订单信息
     *
     * @param buyerOpenId 买家openid
     * @param pageable    分页要求
     * @return 符合要求的订单信息
     */
    Page<OrderMaster> listBy(String buyerOpenId, Pageable pageable);

    /**
     * 取消订单
     *
     * @param orderDTO 订单DTO对象
     * @return OrderDTO
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完成订单
     *
     * @param orderDTO 订单DTO对象
     * @return OrderDTO
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     *
     * @param orderDTO 订单DTO对象
     * @return OrderDTO
     */
    OrderDTO paid(OrderDTO orderDTO);
}
