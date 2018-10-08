package site.sixteen.sell.service;

import site.sixteen.sell.entity.ProductCategory;

import java.util.List;

/**
 * CategoryService
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品类目表业务逻辑接口
 * @date 2018/9/6
 */
public interface CategoryService {

    /**
     * 保存或者更新商品类目信息
     *
     * @param productCategory
     * @return 商品类目信息
     */
    ProductCategory saveOrUpdate(ProductCategory productCategory);

    /**
     * 通过商品ID获取商品类目信息
     *
     * @param categoryId 商品ID
     * @return 符合要求的商品类目
     */
    ProductCategory getBy(Integer categoryId);

    /**
     * 获取所有商品类目信息
     *
     * @return 所有商品类目信息
     */
    List<ProductCategory> listAll();

    /**
     * 获取所有商品编号在categoryTypeList中的商品类目信息
     *
     * @param categoryTypeList 商品编号list
     * @return 符合要求的商品类目信息
     */
    List<ProductCategory> listBy(List<Integer> categoryTypeList);


}
