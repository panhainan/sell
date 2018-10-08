package site.sixteen.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResultMsgEnum
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 提示消息枚举类
 * @date 2018/10/8
 */
@Getter
@AllArgsConstructor
public enum ResultMsgEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_NOT_ENOUGH(11, "商品库存不足"),
    ;

    private Integer code;

    private String message;
}
