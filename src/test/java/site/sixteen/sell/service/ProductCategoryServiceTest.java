package site.sixteen.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import site.sixteen.sell.SellApplicationTests;
import site.sixteen.sell.entity.ProductCategory;
import site.sixteen.sell.service.impl.ProductCategoryServiceImpl;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ProductCategoryServiceTest extends SellApplicationTests {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void saveOrUpdate() {
        ProductCategory productCategory = null;
        productCategory = new ProductCategory("热销榜", 1);
        productCategory = new ProductCategory("男生最爱", 2);
        productCategory = new ProductCategory("女生最爱", 3);
        productCategory = new ProductCategory("仙侠榜", 4);
        productCategory = new ProductCategory("言情榜", 5);
        productCategory = new ProductCategory("玄幻榜", 6);
        ProductCategory result = productCategoryService.saveOrUpdate(productCategory);
        log.debug("result is : {}", result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void getBy() {
        ProductCategory result = productCategoryService.getBy(1);
        log.debug("result is : {}", result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void listAll() {
        List<ProductCategory> result = productCategoryService.listAll();
        log.debug("result is : {}", result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void listBy() {
        List<ProductCategory> result = productCategoryService.listBy(Arrays.asList(1, 2));
        log.debug("result is : {}", result);
        Assert.assertNotEquals(null, result);
    }
}