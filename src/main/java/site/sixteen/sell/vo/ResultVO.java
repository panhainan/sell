package site.sixteen.sell.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.sixteen.sell.enums.ResultCodeEnum;

/**
 * ResultVO
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use HTTP返回对象
 * @date 2018/9/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public ResultVO(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
        this.data = data;
    }
}
