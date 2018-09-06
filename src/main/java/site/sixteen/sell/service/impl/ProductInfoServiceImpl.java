package site.sixteen.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.sixteen.sell.dao.ProductInfoRepository;
import site.sixteen.sell.entity.ProductInfo;
import site.sixteen.sell.service.ProductInfoService;

import java.util.List;

/**
 * ProductInfoServiceImpl
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品业务逻辑层接口实现类
 * @date 2018/9/7
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo saveOrUpdate(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public ProductInfo getBy(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> listBy(Integer productStatus) {
        return productInfoRepository.findAllByProductStatus(productStatus);
    }

    @Override
    public Page<ProductInfo> listAllBy(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }
}
