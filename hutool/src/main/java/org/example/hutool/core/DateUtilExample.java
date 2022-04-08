package org.example.hutool.core;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author ys
 * @Date 2022/3/31 09:49
 */
public class DateUtilExample {
    public static void main(String[] args) {
        //当前时间
        Date date = DateUtil.date();
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();

        String zodiac = DateUtil.getZodiac(Month.SEPTEMBER.getValue(), 23);
        System.out.println(zodiac);

    }
}
