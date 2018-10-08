package site.sixteen.sell.utils;

import site.sixteen.sell.enums.ResultCodeEnum;
import site.sixteen.sell.vo.ResultVO;

/**
 * ResultVOUtil
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use 返回实体工具类
 * @date 2018/9/7
 */
public class ResultVOUtil {

    public static ResultVO success() {
        return new ResultVO(ResultCodeEnum.SUCCESS, null);
    }

    public static ResultVO success(Object data) {
        return new ResultVO(ResultCodeEnum.SUCCESS, data);
    }

    public static ResultVO failure() {
        return new ResultVO(ResultCodeEnum.FAILURE, null);
    }

    public static ResultVO error() {
        return new ResultVO(ResultCodeEnum.ERROR, null);
    }


}
