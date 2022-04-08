package org.example.hutool.core;

import cn.hutool.core.convert.Convert;

import java.util.Date;

/**
 * @Author ys
 * @Date 2022/3/31 09:03
 */
public class ConvertExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println(Convert.toStr(intArray));
        String[] strArray = Convert.toStrArray(intArray);
        System.out.println(Convert.toStr(strArray));

        System.out.println(Convert.toDate("2020-01-01 01:12:23"));
        System.out.println(Convert.toDate("2019-02-06T23:21:56.437+0800"));// yyyy-MM-dd'T'HH:mm:ss.SSSXXX
        System.out.println(Convert.toDate("2019-02-06T23:21:56.436+08:00"));// yyyy-MM-dd'T'HH:mm:ss.SSSZ

        byte[] byteArray = Convert.hexToBytes("01e02c56248359183Ce361C4BceD3F939183F42D");
        System.out.println(Convert.toStr(byteArray));
        System.out.println(Convert.toHex(byteArray));




    }
}
