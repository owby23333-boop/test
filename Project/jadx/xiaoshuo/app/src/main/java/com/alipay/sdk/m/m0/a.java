package com.alipay.sdk.m.m0;

import android.content.Context;
import com.alipay.sdk.m.b.b;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        if (com.alipay.sdk.m.b.a.f1738a) {
            return b.C0020b.f1743a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (com.alipay.sdk.m.b.a.f1738a) {
            return b.C0020b.f1743a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (com.alipay.sdk.m.b.a.f1738a) {
            return b.C0020b.f1743a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (com.alipay.sdk.m.b.a.f1738a) {
            return b.C0020b.f1743a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void e(Context context) {
        com.alipay.sdk.m.b.a.f1739b = b.C0020b.f1743a.a(context.getApplicationContext());
        com.alipay.sdk.m.b.a.f1738a = true;
    }

    public static boolean a() {
        if (com.alipay.sdk.m.b.a.f1738a) {
            return com.alipay.sdk.m.b.a.f1739b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
