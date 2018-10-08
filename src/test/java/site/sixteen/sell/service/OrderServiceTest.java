package site.sixteen.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import site.sixteen.sell.SellApplicationTests;
import site.sixteen.sell.dto.OrderDTO;
import site.sixteen.sell.entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderServiceTest extends SellApplicationTests {

    @Autowired
    private OrderService orderService;

    private final String OPENID = "1016593477";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("没文化的十六先生");
        orderDTO.setBuyerAddress("网上书城");
        orderDTO.setBuyerPhone("12345678901");
        orderDTO.setBuyerOpenid(OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("100001");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result {}", result);
    }

    @Test
    public void getOne() {
    }

    @Test
    public void listBy() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}