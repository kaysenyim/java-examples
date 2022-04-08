package org.example.hutool.core;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;

/**
 * @Author ys
 * @Date 2022/3/31 09:57
 */
public class ChineseDateExample {
    public static void main(String[] args) {
        //通过公历构建
        ChineseDate date = new ChineseDate(DateUtil.parseDate("2022-03-31"));
        System.out.println(date.getChineseMonth());
        System.out.println(date.getChineseMonthName());
        System.out.println(date.getChineseDay());
        System.out.println(date.getCyclical());
        System.out.println(date.getChineseZodiac());
        System.out.println(date.getFestivals());// 传统节日（部分支持，逗号分隔）：春节
        System.out.println(date.toString());
        System.out.println(date.getCyclicalYMD());
    }
}
