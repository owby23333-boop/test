package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static boolean a = true;
    public static boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10686c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f10687d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f10688e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f10689f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f10690g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f10691h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10692i = "anythink_";

    static {
        if (com.anythink.expressad.a.a) {
            return;
        }
        a = false;
        b = false;
        f10686c = false;
        f10687d = false;
        f10688e = false;
        f10689f = false;
        f10690g = false;
        f10691h = false;
    }

    private o() {
    }

    public static void a(String str, String str2) {
        if (!b || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void b(String str, String str2) {
        if (!f10686c || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void c(String str, String str2, Throwable th) {
        if (!a || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void d(String str, String str2, Throwable th) {
        if (!f10686c || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void e(String str, String str2) {
        if (!a || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!b || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!f10688e || str2 == null) {
            return;
        }
        a(str);
    }

    public static void c(String str, String str2) {
        if (!f10687d || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    public static void d(String str, String str2) {
        if (!f10688e || str2 == null) {
            return;
        }
        a(str);
    }

    private static void e(String str, String str2, Throwable th) {
        if (!f10687d || TextUtils.isEmpty(str2)) {
            return;
        }
        a(str);
    }

    private static void a(String str, Throwable th) {
        if (!f10687d || th == null) {
            return;
        }
        a(str);
    }

    private static void a(Context context, String str) {
        if (f10689f) {
            Toast.makeText(context, str, 1).show();
        }
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? f10692i.concat(String.valueOf(str)) : str;
    }
}
