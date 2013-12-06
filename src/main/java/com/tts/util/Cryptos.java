package com.tts.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 13-12-3
 * Time: 下午4:10
 * To change this template use File | Settings | File Templates.
 */
public class Cryptos {
    public static String SHA1(String inStr) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");     //选择SHA-1，也可以选择MD5
            byte[] digest = md.digest(inStr.getBytes());       //返回的是byet[]，要转化为String存储比较方便
            outStr = bytetoString(digest);
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return outStr;
    }

    public static String bytetoString(byte[] digest) {
        String str = "",tempStr = "";

        for (int i = 0; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xFF));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            } else {
                str = str + tempStr;
            }
        }

        return str.toLowerCase();
    }
}
