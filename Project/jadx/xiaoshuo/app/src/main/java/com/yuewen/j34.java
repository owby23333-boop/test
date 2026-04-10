package com.yuewen;

import android.text.TextUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class j34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12820a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f12821b = {0.5f, 0.75f, 1.0f, 1.5f, 2.0f};
    public static final int c;
    public static final String d = "597a9476";

    static {
        c = (r0.length - 1) * 100;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            for (byte b2 : str.getBytes("utf-8")) {
                sb.append(Integer.toHexString(b2));
            }
            return new BigInteger(sb.toString(), 16).toString(32);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        return d;
    }
}
