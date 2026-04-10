package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2040a;
    private static String dl;
    private static String g;
    private static Boolean gc;
    private static String z;

    public static boolean z(Context context) {
        return context != null && dl(context) == 0 && gc();
    }

    public static boolean g(Context context) {
        return context != null && a(context) == 0 && m();
    }

    public static String z() {
        if (z == null) {
            z = z("getApiVersion");
        }
        return z;
    }

    public static String g() {
        if (g == null) {
            g = z("getVersion");
        }
        return g;
    }

    public static String dl() {
        if (dl == null) {
            dl = z("getReleaseType");
        }
        return dl;
    }

    public static String a() {
        if (f2040a == null) {
            f2040a = z("getBuildVersion");
        }
        return f2040a;
    }

    public static int dl(Context context) {
        if (context == null) {
            return 1;
        }
        if (g(g(), z())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int a(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static boolean gc() {
        if (gc == null) {
            gc = Boolean.FALSE;
            try {
                gc = Boolean.valueOf("156".equals(z("ro.config.hw_optb", "0")) && "true".equals(z("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return gc.booleanValue();
    }

    public static boolean m() {
        return gc() && g(g(), z()) && z(Process.myUid()) == 0;
    }

    public static String e() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String z(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int z(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            wp.z(th);
            return 1;
        }
    }

    private static String z(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }
}
