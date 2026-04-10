package com.king.zxing.r;

import android.util.Log;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static boolean a = true;
    private static int b = 1;

    private static String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        return "ZXingLite" + com.anythink.expressad.foundation.g.a.bQ + String.format("%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
    }

    public static boolean b() {
        return a;
    }

    public static void c(String str) {
        if (!a || b > 5) {
            return;
        }
        a();
        String.valueOf(str);
    }

    public static void b(String str) {
        if (!a || b > 4) {
            return;
        }
        a();
        String.valueOf(str);
    }

    public static void b(Throwable th) {
        if (!a || b > 5) {
            return;
        }
        a();
        a(th);
    }

    public static StackTraceElement a(int i2) {
        return Thread.currentThread().getStackTrace()[i2];
    }

    private static String a() {
        return a(a(5));
    }

    private static String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void a(String str) {
        if (!a || b > 3) {
            return;
        }
        a();
        String.valueOf(str);
    }

    public static void a(String str, Throwable th) {
        if (!a || b > 5) {
            return;
        }
        a();
        String.valueOf(str);
    }
}
