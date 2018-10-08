package site.sixteen.sell.exception;

import site.sixteen.sell.enums.ResultMsgEnum;

/**
 * SellException
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 异常处理类
 * @date 2018/10/8
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultMsgEnum resultMsgEnum) {
        super(resultMsgEnum.getMessage());
        this.code = resultMsgEnum.getCode();
    }
}
