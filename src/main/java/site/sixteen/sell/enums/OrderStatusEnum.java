package site.sixteen.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * OrderStatusEnum
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 订单状态枚举
 * @date 2018/9/7
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

}
