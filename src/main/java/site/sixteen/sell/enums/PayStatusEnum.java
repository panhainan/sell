package site.sixteen.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PayStatusEnum
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 支付状态枚举
 * @date 2018/9/7
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),

    ;

    private Integer code;

    private String message;

}
