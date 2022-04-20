package com.kaysenyim.example.ga;

import cn.hutool.core.codec.Base32;
import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

class GoogleAuthenticatorTest {

    @Test
    public void genSecretKey() {
        try {
            String secretKey = GoogleAuthenticator.genSecretKey();
            System.out.println(secretKey);
            // 5RSUTLFWVBED5FPP
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getQRBarCode() {
        String qrBarCode = GoogleAuthenticator.getQRBarCode("kaysenyim", "5RSUTLFWVBED5FPP", "CSDN");
        System.out.println(qrBarCode);
        // otpauth://totp/keysenyim?secret=5RSUTLFWVBED5FPP&issuer=CSDN
    }

    @Test
    void genCode() {
        byte[] key = Base32.decode("5RSUTLFWVBED5FPP");
        try {
            int code = GoogleAuthenticator.genCode(key);
            System.out.println(code);
            // 704531
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void checkCode() {
        try {
            boolean ok = GoogleAuthenticator.checkCode("5RSUTLFWVBED5FPP", 357509, System.currentTimeMillis());
            System.out.println(ok);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}