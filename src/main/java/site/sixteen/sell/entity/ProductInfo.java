package site.sixteen.sell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ProductInfo
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品信息
 * @date 2018/9/6
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class ProductInfo {

    @Id
    /** 商品ID. */
    private String productId;
    /**
     * 商品名称.
     */
    private String productName;
    /**
     * 商品价格.
     */
    private BigDecimal productPrice;
    /**
     * 商品库存.
     */
    private Integer productStock;
    /**
     * 商品描述.
     */
    private String productDescription;
    /**
     * 商品小图.
     */
    private String productIcon;
    /**
     * 商品状态 0正常，1下架.
     */
    private Integer productStatus;
    /**
     * 商品类目编号.
     */
    private Integer categoryType;
    /**
     * 商品创建时间.
     */
    private Date createTime;
    /**
     * 商品修改时间.
     */
    private Date updateTime;

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
