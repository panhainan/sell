package site.sixteen.sell.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * ProductCategory
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品类目
 * @date 2018/9/5
 */
@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {

    /**
     * 类目ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    /**
     * 类目名称.
     */
    private String categoryName;
    /**
     * 类目编号.
     */
    private Integer categoryType;
    /**
     * 创建时间.
     */
    private Date createTime;
    /**
     * 更新时间.
     */
    private Date updateTime;


    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
