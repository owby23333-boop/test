package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1384a = null;
    private static Boolean dl = null;
    private static int e = 1;
    private static String g = null;
    private static String gc = null;
    private static int gz = 1;
    private static Boolean m;
    private static String z;

    public static void z() {
        if (dl == null) {
            if (a() || dl()) {
                try {
                    Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                    dl = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
                } catch (Throwable unused) {
                    dl = Boolean.FALSE;
                }
                if (z == null) {
                    z = z("getApiVersion");
                }
                if (g == null) {
                    g = z("getVersion");
                }
                if (gc == null) {
                    gc = z("getReleaseType");
                }
                if (f1384a == null) {
                    f1384a = z("getBuildVersion");
                }
                if (m == null) {
                    m = Boolean.FALSE;
                    try {
                        m = Boolean.valueOf("156".equals(g("ro.config.hw_optb", "0")) && "true".equals(g("hw_mc.pure_mode.enable", "false")));
                    } catch (Exception unused2) {
                    }
                }
                try {
                    e = Settings.Secure.getInt(com.bytedance.sdk.openadsdk.core.zw.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
                } catch (Throwable unused3) {
                }
                try {
                    Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                    gz = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
                    return;
                } catch (Throwable unused4) {
                    return;
                }
            }
            dl = Boolean.FALSE;
        }
    }

    public static boolean g() {
        Boolean bool = dl;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean dl() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HUAWEI")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HUAWEI");
        }
        return true;
    }

    public static boolean a() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HONOR")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HONOR");
        }
        return true;
    }

    public static String gc() {
        return z;
    }

    public static String m() {
        return g;
    }

    public static String e() {
        return gc;
    }

    public static String gz() {
        return f1384a;
    }

    private static String z(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean z(Context context) {
        return context != null && g(context) == 0 && wp();
    }

    public static void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i = 1;
            jSONObject.put("pure_enhanced_mode", fo() ? 1 : 2);
            if (!uy()) {
                i = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i);
        } catch (Throwable unused) {
        }
    }

    public static boolean fo() {
        return kb() == 0 && uy();
    }

    public static boolean uy() {
        return wp() && z(m(), gc()) && i() == 0;
    }

    public static int kb() {
        return e;
    }

    private static boolean z(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }

    private static int i() {
        return gz;
    }

    private static int g(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    public static boolean wp() {
        Boolean bool = m;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static String g(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }
}
