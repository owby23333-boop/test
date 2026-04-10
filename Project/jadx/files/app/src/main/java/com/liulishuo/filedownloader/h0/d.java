package com.liulishuo.filedownloader.h0;

import android.util.Log;

/* JADX INFO: compiled from: FileDownloadLog.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static boolean a = false;

    public static void a(Object obj, Throwable th, String str, Object... objArr) {
        a(6, obj, th, str, objArr);
    }

    public static void b(Object obj, String str, Object... objArr) {
        a(6, obj, str, objArr);
    }

    public static void c(Object obj, String str, Object... objArr) {
        a(4, obj, str, objArr);
    }

    public static void d(Object obj, String str, Object... objArr) {
        a(2, obj, str, objArr);
    }

    public static void e(Object obj, String str, Object... objArr) {
        a(5, obj, str, objArr);
    }

    public static void a(Object obj, String str, Object... objArr) {
        a(3, obj, str, objArr);
    }

    private static void a(int i2, Object obj, String str, Object... objArr) {
        a(i2, obj, null, str, objArr);
    }

    private static void a(int i2, Object obj, Throwable th, String str, Object... objArr) {
        if ((i2 >= 5) || a) {
            Log.println(i2, a(obj), f.a(str, objArr));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    private static String a(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDownloader.");
        sb.append((obj instanceof Class ? (Class) obj : obj.getClass()).getSimpleName());
        return sb.toString();
    }
}
