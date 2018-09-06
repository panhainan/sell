package site.sixteen.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import site.sixteen.sell.SellApplicationTests;
import site.sixteen.sell.entity.ProductInfo;
import site.sixteen.sell.enums.ProductStatusEnum;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class ProductInfoServiceTest extends SellApplicationTests {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void saveOrUpdate() {
        ProductInfo productInfo = null;
//        productInfo = new ProductInfo("100001","七界异神", BigDecimal.valueOf(29.99), 100, "讲述一个幼年父母被同门陷害致死的男孩，被收养后一步一步从小角色复仇到走向仙界的故事。", "https://sixteen.site/qijieyishen.jpg", ProductStatusEnum.UP.getCode(), 2);
//        productInfo = new ProductInfo("100002","斗破苍穹", BigDecimal.valueOf(39.99), 600, "萧炎的故事", "https://sixteen.site/doupochangqiong.jpg", ProductStatusEnum.UP.getCode(), 2);
        productInfo = new ProductInfo("100003", "武动乾坤", BigDecimal.valueOf(34.99), 300, "林动的故事", "https://sixteen.site/wudongqiankun.jpg", ProductStatusEnum.UP.getCode(), 2);
        ProductInfo result = productInfoService.saveOrUpdate(productInfo);
        log.debug("result is : {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void getBy() {
        ProductInfo result = productInfoService.getBy("100001");
        log.debug("result is : {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void listBy() {
        List<ProductInfo> result = productInfoService.listBy(ProductStatusEnum.UP.getCode());
        log.debug("result is : {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void listAllBy() {
        PageRequest pageRequest = new PageRequest(0, 2, null);
        Page<ProductInfo> result = productInfoService.listAllBy(pageRequest);
        log.debug("result is : {}", result.toString());
        log.debug("result.getContent() is : {}", result.getContent());
        Assert.assertNotNull(result);
    }
}