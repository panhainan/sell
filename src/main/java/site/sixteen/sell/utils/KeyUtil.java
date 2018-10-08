package site.sixteen.sell.utils;

import java.util.Random;

/**
 * KeyUtil
 *
 * @author panhainan@yeah.net(@link https://sixteen.site)
 * @version 1.0
 * @use key生成工具类
 * @date 2018/10/8
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式:时间毫秒数+随机数
     *
     * @return String
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
