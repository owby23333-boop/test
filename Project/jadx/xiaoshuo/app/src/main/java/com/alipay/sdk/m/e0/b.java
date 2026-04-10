package com.alipay.sdk.m.e0;

import java.security.MessageDigest;
import miuix.security.DigestUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(String str) {
        try {
            if (com.alipay.sdk.m.d0.a.a(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(DigestUtils.ALGORITHM_SHA_1);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
