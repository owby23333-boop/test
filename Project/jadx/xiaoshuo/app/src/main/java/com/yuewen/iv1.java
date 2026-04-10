package com.yuewen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated
public class iv1 {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b2 : messageDigest.digest()) {
                stringBuffer.append(b(b2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String b(byte b2) {
        int i = (b2 & 127) + (b2 < 0 ? 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i < 16 ? "0" : "");
        sb.append(Integer.toHexString(i).toLowerCase());
        return sb.toString();
    }
}
