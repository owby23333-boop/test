package com.dangdang.zframework.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes10.dex */
public class MD5Util {
    public static String getMD5Str(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (messageDigest == null) {
            return "";
        }
        byte[] bArrDigest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArrDigest.length; i++) {
            if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
            }
        }
        return stringBuffer.substring(0, stringBuffer.length()).toString();
    }
}
