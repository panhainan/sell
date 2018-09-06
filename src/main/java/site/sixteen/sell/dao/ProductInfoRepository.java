package site.sixteen.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.sixteen.sell.entity.ProductInfo;

import java.util.List;

/**
 * ProductInfoRepository
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品数据访问层接口
 * @date 2018/9/6
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查询商品状态为productStatus的商品
     *
     * @param productStatus 商品状态
     * @return 符合要求的商品
     */
    List<ProductInfo> findAllByProductStatus(Integer productStatus);

}
