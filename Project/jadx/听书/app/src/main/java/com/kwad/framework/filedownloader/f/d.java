package com.kwad.framework.filedownloader.f;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static boolean apD;

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        a(6, obj, th, str, objArr);
    }

    public static void a(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(4, obj, str, objArr);
    }

    public static void c(Object obj, String str, Object... objArr) {
        a(3, obj, str, objArr);
    }

    public static void d(Object obj, String str, Object... objArr) {
        a(5, obj, str, objArr);
    }

    public static void e(Object obj, String str, Object... objArr) {
        a(2, obj, str, objArr);
    }

    private static void a(int i, Object obj, String str, Object... objArr) {
        a(i, obj, null, str, objArr);
    }

    private static void a(int i, Object obj, Throwable th, String str, Object... objArr) {
        if ((i >= 5) || apD) {
            Log.println(i, g(obj), f.c(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    private static String g(Object obj) {
        return "FileDownloader." + (obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName();
    }
}
