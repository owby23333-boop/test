package com.xiaomi.httpdns.utils;

import com.xiaomi.ad.y;
import com.yuewen.gm;

/* JADX INFO: loaded from: classes8.dex */
public class MD5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f7389a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", y.j, gm.a.f11596b, "d", "e", gm.a.f11595a};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f7389a;
            sb.append(strArr[i / 16]);
            sb.append(strArr[i % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }
}
