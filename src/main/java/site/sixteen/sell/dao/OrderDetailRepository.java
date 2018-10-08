package site.sixteen.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.sixteen.sell.entity.OrderDetail;

import java.util.List;

/**
 * OrderDetailRepository
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 订单详细数据访问层接口
 * @date 2018/9/8
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
