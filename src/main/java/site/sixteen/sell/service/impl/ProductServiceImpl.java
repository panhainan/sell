package site.sixteen.sell.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sixteen.sell.dao.ProductInfoRepository;
import site.sixteen.sell.dto.CartDTO;
import site.sixteen.sell.entity.ProductInfo;
import site.sixteen.sell.enums.ResultMsgEnum;
import site.sixteen.sell.exception.SellException;
import site.sixteen.sell.service.ProductService;

import java.util.List;

/**
 * ProductServiceImpl
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品业务逻辑层接口实现类
 * @date 2018/9/7
 */
@Service
public class ProductServiceImpl implements ProductService {

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

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultMsgEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductStock();
            if (result < 0) {
                throw new SellException(ResultMsgEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
