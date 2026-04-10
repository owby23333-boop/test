package com.xiaomi.ad.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public final class HashUtils {
    public static String getMd5(String str) {
        if (str == null) {
            str = "";
        }
        return getMd5(str.getBytes());
    }

    public static String getMd5(byte[] bArr) {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }
}
