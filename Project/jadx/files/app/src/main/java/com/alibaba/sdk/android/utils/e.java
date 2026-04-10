package com.alibaba.sdk.android.utils;

import com.umeng.analytics.pro.cb;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: Toolkit.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m39a(String str) {
        return str == null || str.length() == 0;
    }

    public static String b(String str) throws NoSuchAlgorithmException {
        return a(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
    }

    public static void a(double d2) {
        try {
            Thread.sleep((long) (d2 * 1000.0d));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public static String a(String str) throws NoSuchAlgorithmException {
        return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(hexChar[(bArr[i2] & 240) >>> 4]);
            sb.append(hexChar[bArr[i2] & cb.f19604m]);
        }
        return sb.toString();
    }
}
