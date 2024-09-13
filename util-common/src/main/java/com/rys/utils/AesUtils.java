package com.rys.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName AesUtils.java
 * @Description
 * @createTime 2024年09月11日 22:17:00
 */
public class AesUtils {


    public static final String KEY = "IOASYDHWIOEUSD567465146";

    public static String encrypt(String content) {

        try {
            byte[] raw = KEY.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encrypted = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));

            return new BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            return content;
        }
    }


    public static String decrypt(String cipherText) {
        try {
            byte[] raw = KEY.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] bytes = cipher.doFinal(new BASE64Decoder().decodeBuffer(cipherText));

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return cipherText;
        }
    }

}
