package site.sixteen.sell.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sixteen.sell.entity.ProductCategory;
import site.sixteen.sell.entity.ProductInfo;
import site.sixteen.sell.enums.ProductStatusEnum;
import site.sixteen.sell.service.CategoryService;
import site.sixteen.sell.service.ProductService;
import site.sixteen.sell.utils.ResultVOUtil;
import site.sixteen.sell.vo.ProductInfoVO;
import site.sixteen.sell.vo.ProductListVO;
import site.sixteen.sell.vo.ResultVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BuyerProductController
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 买家商品信息控制器
 * @date 2018/9/7
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.listBy(ProductStatusEnum.UP.getCode());

        //2.查询所有类目
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.listBy(categoryTypeList);

        //3.数据拼装
        List<ProductListVO> productListVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductListVO productListVO = new ProductListVO();
            productListVO.setCategoryName(productCategory.getCategoryName());
            productListVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productListVO.setProductInfoVOList(productInfoVOList);
            productListVOList.add(productListVO);
        }
        return ResultVOUtil.success(productListVOList);
    }
}
