package org.example.hutool.core;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.symmetric.PBKDF2;

/**
 * @Author ys
 * @Date 2022/3/31 11:34
 */
public class Base64Example {
    public static void main(String[] args) {
        String decode = Base64.decodeStr("MTIzNDU=");
        System.out.println(decode);

    }
}
