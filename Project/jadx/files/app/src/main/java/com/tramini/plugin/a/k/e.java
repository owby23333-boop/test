package com.tramini.plugin.a.k;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static String a = "";
    private static String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f19384c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f19385d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f19386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f19387f;

    public static String a(Context context) {
        if (com.tramini.plugin.a.a.c.c().a("app_vc")) {
            return "";
        }
        if (f19386e != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(f19386e);
            return sb.toString();
        }
        try {
            f19386e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f19386e);
            return sb2.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b(Context context) {
        if (com.tramini.plugin.a.a.c.c().a("app_vn")) {
            return "";
        }
        try {
            if (!TextUtils.isEmpty(f19385d)) {
                return f19385d;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f19385d = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        if (com.tramini.plugin.a.a.c.c().a("package_name")) {
            return "";
        }
        try {
            if (!TextUtils.isEmpty(f19384c)) {
                return f19384c;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            f19384c = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (com.tramini.plugin.a.a.c.c().a("android_id")) {
            return "";
        }
        try {
            if (f19387f == null) {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                f19387f = string;
                if (string == null) {
                    f19387f = "";
                }
            }
        } catch (Exception unused) {
            f19387f = "";
        }
        return f19387f;
    }

    public static String a() {
        if (com.tramini.plugin.a.a.c.c().a("os_vc")) {
            return "";
        }
        if (TextUtils.isEmpty(b)) {
            b = String.valueOf(Build.VERSION.SDK_INT);
        }
        return b;
    }

    public static String b() {
        if (com.tramini.plugin.a.a.c.c().a("os_vn")) {
            return "";
        }
        if (TextUtils.isEmpty(a)) {
            a = Build.VERSION.RELEASE;
        }
        return a;
    }
}
