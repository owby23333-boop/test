package com.bytedance.pangle.util;

import com.umeng.analytics.pro.cb;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static String a = "DES/ECB/NoPadding";
    public static String b = "DESede/ECB/NoPadding";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f14669c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        return b(a(str.getBytes(), "MD5"));
    }

    private static String b(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = f14669c;
            cArr[i2] = cArr2[(bArr[i3] >>> 4) & 15];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & cb.f19604m];
        }
        return new String(cArr);
    }

    private static byte[] a(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String a(byte[] bArr) {
        return b(a(bArr, "MD5"));
    }
}
