package site.sixteen.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sixteen.sell.dao.ProductCategoryRepository;
import site.sixteen.sell.entity.ProductCategory;
import site.sixteen.sell.service.CategoryService;

import java.util.List;

/**
 * CategoryServiceImpl
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品类目表业务逻辑接口实现类
 * @date 2018/9/6
 */
@Service("productCategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory saveOrUpdate(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory getBy(Integer categoryId) {
        return productCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> listAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> listBy(List<Integer> categoryTypeList) {
        return productCategoryRepository.findAllByCategoryTypeIn(categoryTypeList);
    }
}
