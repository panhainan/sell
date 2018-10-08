package site.sixteen.sell.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.sixteen.sell.entity.OrderMaster;

/**
 * OrderMasterRepository
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 订单数据访问层接口
 * @date 2018/9/8
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 通过买家openid分页获取订单信息
     *
     * @param buyerOpenId 买家openid
     * @param pageable    分页要求
     * @return 符合要求的订单信息
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);

}
