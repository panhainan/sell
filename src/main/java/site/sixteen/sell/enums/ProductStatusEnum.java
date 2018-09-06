package site.sixteen.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ProductStatusEnum
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 商品状态枚举
 * @date 2018/9/7
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum {

    /**
     * 在架
     */
    UP(0, "在架"),
    /**
     * 下架
     */
    DOWN(1, "下架");
    private Integer code;
    private String message;

}
