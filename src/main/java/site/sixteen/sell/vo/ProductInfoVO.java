package site.sixteen.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ProductInfoVO
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品详情
 * @date 2018/9/7
 */
@Data
public class ProductInfoVO {

    /**
     * 商品ID.
     */
    @JsonProperty("id")
    private String productId;
    /**
     * 商品名称.
     */
    @JsonProperty("name")
    private String productName;
    /**
     * 商品价格.
     */
    @JsonProperty("price")
    private BigDecimal productPrice;
    /**
     * 商品描述.
     */
    @JsonProperty("description")
    private String productDescription;
    /**
     * 商品小图.
     */
    @JsonProperty("icon")
    private String productIcon;
}
