package site.sixteen.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResultCodeEnum
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 返回状态码枚举类
 * @date 2018/9/7
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS(000, "操作成功"),
    FAILURE(001, "操作失败"),
    ERROR(010, "操作出错");
    private Integer code;
    private String message;


}
