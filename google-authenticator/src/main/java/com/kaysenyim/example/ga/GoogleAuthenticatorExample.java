package com.kaysenyim.example.ga;

import cn.hutool.core.codec.Base32;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author kaysen
 */
public class GoogleAuthenticatorExample {
    public static void main(String[] args) {
        try {
            String secretKey = GoogleAuthenticator.genSecretKey();
            System.out.println(secretKey);
            String qrBarCode = GoogleAuthenticator.getQRBarCode("kaysenyim", secretKey, "CSDN");
            System.out.println(qrBarCode);
            byte[] key = Base32.decode(secretKey);
            int code = GoogleAuthenticator.genCode(key);
            System.out.println(code);
            String codeStr = String.format("%06d", code);
            System.out.println(codeStr);
            boolean ok = GoogleAuthenticator.checkCode(secretKey, code, System.currentTimeMillis());
            System.out.println(ok);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
