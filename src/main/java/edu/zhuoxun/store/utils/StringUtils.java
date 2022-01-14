package edu.zhuoxun.store.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Jash
 */
public class StringUtils {
    public static String toMD5(String src) {
        String result = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(src.getBytes(StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            for (byte b : digest) {
                builder.append(String.format("%02x", b & 0xff));
            }
            result = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
