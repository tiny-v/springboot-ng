package com.my.sb.core.data.id;

/**
 * ID生成器工具类
 *
 * @author chewenjie
 *         2014-04-03
 */
public class IdUtil {

    private static IdGenerator idGenerator = new SnowflakeIdGenerator(1);

    public static synchronized String getId() {
        return Long.toString(idGenerator.nextId());
    }

}
