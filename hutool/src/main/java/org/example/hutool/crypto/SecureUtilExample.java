package org.example.hutool.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.Convert;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import org.bouncycastle.crypto.generators.SCrypt;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @Author ys
 * @Date 2022/3/31 10:16
 */
public class SecureUtilExample {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] data = Convert.hexToBytes("c7d49a1e575589b14ed93e864b42ce94ea2fd528385789af79b9ad6135518959");
//        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
//        System.out.println(Convert.toHex(key));
//        byte[] key = Convert.hexToBytes("049a55b94a24ea5da1c99af86148c6d3");

        // KDF
        String password = "P@55w0rd";
        byte[] salt = Convert.hexToBytes("092b702d3abdb63657b0885abeaa03bbb106bb674bba31dc9f2112c091bddfbb");
        int n = 262144;
        int r = 8;
        int p = 1;
        int dkLen = 32;
        byte[] derivedKey = SCrypt.generate(password.getBytes(UTF_8), salt, n, r, p, dkLen);
        byte[] key = Arrays.copyOfRange(derivedKey, 0, 16);

        byte[] iv = Convert.hexToBytes("a5d8bbdc46a0e5cdfcb0f10ba3a6153a");

        // AES/CTR/PKCS5Padding
        // AES aes = new AES(Mode.CTR, Padding.PKCS5Padding, key, iv);

        // AES/CTR/PKCS7Padding
        AES aes = new AES("CTR", "PKCS7Padding", key, iv);
        byte[] encrypt = aes.encrypt(data);
        System.out.println(Convert.toHex(encrypt));
        byte[] decrypt = aes.decrypt(encrypt);
        System.out.println(Convert.toHex(decrypt));
    }
}
