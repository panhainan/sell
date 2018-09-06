package site.sixteen.sell.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.sixteen.sell.entity.ProductCategory;

import java.util.List;

/**
 * ProductCategoryRepository
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品类目数据访问层接口
 * @date 2018/9/5
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 查询所有商品编号在categoryTypeList中的商品类目信息
     *
     * @param categoryTypeList 商品编号list
     * @return 符合要求的商品类目信息
     */
    List<ProductCategory> findAllByCategoryTypeIn(List<Integer> categoryTypeList);
}
