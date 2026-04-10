package com.ss.android.socialbase.appdownloader.vn;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.duokan.reader.domain.payment.a;
import com.iflytek.aikit.media.param.MscKeys;

/* JADX INFO: loaded from: classes4.dex */
public class tg {
    private static String bf;
    private static String d;
    private static String e;
    private static Boolean ga;
    private static String tg;

    public static boolean bf(Context context) {
        return context != null && tg(context) == 0 && vn();
    }

    public static String d() {
        if (d == null) {
            d = e("getReleaseType");
        }
        return d;
    }

    public static boolean e(Context context) {
        return context != null && d(context) == 0 && ga();
    }

    public static boolean ga() {
        if (ga == null) {
            ga = Boolean.FALSE;
            try {
                ga = Boolean.valueOf("156".equals(e("ro.config.hw_optb", "0")) && a.c.equals(e("hw_mc.pure_mode.enable", MscKeys.VAL_FALSE)));
            } catch (Exception unused) {
            }
        }
        return ga.booleanValue();
    }

    public static String p() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String tg() {
        if (tg == null) {
            tg = e("getBuildVersion");
        }
        return tg;
    }

    public static boolean vn() {
        return ga() && bf(bf(), e()) && e(Process.myUid()) == 0;
    }

    public static String bf() {
        if (bf == null) {
            bf = e("getVersion");
        }
        return bf;
    }

    public static String e() {
        if (e == null) {
            e = e("getApiVersion");
        }
        return e;
    }

    public static int d(Context context) {
        if (context == null) {
            return 1;
        }
        if (bf(bf(), e())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int tg(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    private static boolean bf(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static String e(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int e(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String e(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
