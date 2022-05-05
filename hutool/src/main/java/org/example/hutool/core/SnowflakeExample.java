package org.example.hutool.core;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author kaysen
 */
public class SnowflakeExample {
    public static void main(String[] args) {
        Snowflake snowflake = IdUtil.getSnowflake(1);
        for (int i = 0; i < 100; i++) {
            System.out.println(snowflake.nextId());
        }
    }
}
