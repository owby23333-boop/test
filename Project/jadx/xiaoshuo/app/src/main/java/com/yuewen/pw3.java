package com.yuewen;

import android.util.Log;

/* JADX INFO: loaded from: classes15.dex */
public class pw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f16321a;

    public static void a(String str, String str2) {
        if (f16321a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        Log.e(str, str2);
    }

    public static void c(String str, Throwable th) {
        Log.e(str, Log.getStackTraceString(th));
    }

    public static void d(String str, String str2) {
        if (f16321a) {
            Log.i(str, str2);
        }
    }

    public static void e(boolean z) {
        f16321a = z;
    }

    public static void f(String str, String str2) {
        Log.w(str, str2);
    }
}
