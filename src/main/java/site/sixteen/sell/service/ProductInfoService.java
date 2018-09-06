package site.sixteen.sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import site.sixteen.sell.entity.ProductInfo;

import java.util.List;

/**
 * ProductInfoService
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品业务逻辑层接口
 * @date 2018/9/6
 */
public interface ProductInfoService {

    /**
     * 保存或者更新商品信息
     *
     * @param productInfo 商品信息
     * @return 商品信息
     */
    ProductInfo saveOrUpdate(ProductInfo productInfo);

    /**
     * 通过商品ID获取商品信息
     *
     * @param productId 商品ID
     * @return 符合要求的商品信息
     */
    ProductInfo getBy(String productId);

    /**
     * 通过商品状态productStatus获取商品信息
     *
     * @param productStatus 商品状态
     * @return 符合要求的商品信息
     */
    List<ProductInfo> listBy(Integer productStatus);

    /**
     * 分页获取所有商品信息
     *
     * @param pageable 分页信息
     * @return 符合分页要求的商品信息
     */
    Page<ProductInfo> listAllBy(Pageable pageable);

    //TODO 加减库存

}
