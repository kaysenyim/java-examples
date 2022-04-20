package com.kaysenyim.example.ga;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author kaysenyim
 */
public class GoogleAuthenticator {
    private static final int SECRET_SIZE = 10;

    private static final String SEED = "g8GjEvTbW5oVSV7avL47357438reyhreyuryetredLDVKs2m0QN7vxRs2im5MDaNCWGmcD2rvcZx";

    private static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

    public static final int WINDOW_SIZE = 3;

    public static String genSecretKey() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance(RANDOM_NUMBER_ALGORITHM);
        byte[] seed = Base64.decode(SEED);
        sr.setSeed(seed);
        byte[] key = sr.generateSeed(SECRET_SIZE);
        return Base32.encode(key);
    }

    public static String getQRBarCode(String user, String secret, String issuer) {
        return String.format("otpauth://totp/%s?secret=%s&issuer=%s", user, secret, issuer);
    }

    public static int genCode(byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {
        long t = (System.currentTimeMillis() / 1000L) / 30L;
        return genCode(key, t);
    }

    public static int genCode(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] data = new byte[8];
        long value = t;
        for (int i = 8; i-- > 0; value >>>= 8) {
            data[i] = (byte) value;
        }
        SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signKey);
        byte[] hash = mac.doFinal(data);
        int offset = hash[20 - 1] & 0xF;
        // We're using a long because Java hasn't got unsigned int.
        long truncatedHash = 0;
        for (int i = 0; i < 4; ++i) {
            truncatedHash <<= 8;
            // We are dealing with signed bytes:
            // we just keep the first byte.
            truncatedHash |= (hash[offset + i] & 0xFF);
        }
        truncatedHash &= 0x7FFFFFFF;
        truncatedHash %= 1000000;
        return (int) truncatedHash;
    }

    public static boolean checkCode(String secret, long code, long timeMsec) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] decodedKey = Base32.decode(secret);
        long t = (timeMsec / 1000L) / 30L;
        for (int i = -WINDOW_SIZE; i <= WINDOW_SIZE; ++i) {
            long hash;
            hash = genCode(decodedKey, t + i);
            if (hash == code) {
                return true;
            }
        }
        return false;
    }
}
