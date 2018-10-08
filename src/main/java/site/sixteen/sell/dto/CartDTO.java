package site.sixteen.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CartDTO
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 购物车数据传输对象，用于各层之间数据传输
 * @date 2018/10/8
 */
@Data
@AllArgsConstructor
public class CartDTO {

    private String productId;
    /**
     * 商品库存.
     */
    private Integer productStock;
}
