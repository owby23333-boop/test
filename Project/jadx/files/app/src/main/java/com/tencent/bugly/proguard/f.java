package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.cb;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] a = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = b;
            cArr[i3 + 1] = cArr2[b2 & cb.f19604m];
            cArr[i3 + 0] = cArr2[((byte) (b2 >>> 4)) & cb.f19604m];
        }
        return new String(cArr);
    }
}
