package com.xiaomi.onetrack.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.xiaomi.onetrack.util.j;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f7667a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f7668b = null;
    private static int c = 0;
    private static String d = null;
    private static String e = null;
    private static long f = 0;
    private static volatile boolean g = false;

    public static void a(Context context) {
        if (g) {
            return;
        }
        synchronized (a.class) {
            if (g) {
                return;
            }
            f7667a = context;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f7667a.getPackageName(), 0);
                c = packageInfo.versionCode;
                d = packageInfo.versionName;
                f = packageInfo.lastUpdateTime;
                e = f7667a.getPackageName();
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            g = true;
        }
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfoA = a(context, str, 0);
        return (packageInfoA == null || packageInfoA.applicationInfo == null) ? false : true;
    }

    public static String c(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int d() {
        return c;
    }

    public static String e() {
        return e;
    }

    public static long f() {
        return f;
    }

    public static Context b() {
        return f7667a;
    }

    public static String c() {
        return d;
    }

    public static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    public static boolean a(Context context, String str) {
        try {
            return a(a(context, str, 0).applicationInfo);
        } catch (Exception unused) {
            return false;
        }
    }

    public static PackageInfo a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Context a() {
        if (j.d(f7667a)) {
            Context context = f7668b;
            if (context != null) {
                return context;
            }
            synchronized (a.class) {
                if (f7668b == null) {
                    f7668b = j.a(f7667a);
                }
            }
            return f7668b;
        }
        return f7667a;
    }
}
