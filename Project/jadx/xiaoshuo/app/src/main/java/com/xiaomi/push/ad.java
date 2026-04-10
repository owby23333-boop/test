package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f7784a = com.duokan.account.a.e.toCharArray();

    public static boolean a(Context context) {
        return ac.f7783a;
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & 255;
            char[] cArr = f7784a;
            sb.append(cArr[i4 >> 4]);
            sb.append(cArr[i4 & 15]);
        }
        return sb.toString();
    }
}
