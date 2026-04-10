package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.iflytek.aikit.media.param.MscKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class m {
    private static String bf = null;
    private static Boolean d = null;
    private static String e = null;
    private static String ga = null;
    private static int p = 1;
    private static String tg = null;
    private static int v = 1;
    private static Boolean vn;

    public static boolean bf() {
        Boolean bool = d;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static int bh() {
        return v;
    }

    public static boolean d() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toUpperCase().startsWith("HUAWEI")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toUpperCase().startsWith("HUAWEI")) {
                return false;
            }
        }
        return true;
    }

    public static void e() {
        if (d == null) {
            if (!tg() && !d()) {
                d = Boolean.FALSE;
                return;
            }
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                d = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                d = Boolean.FALSE;
            }
            if (e == null) {
                e = e("getApiVersion");
            }
            if (bf == null) {
                bf = e("getVersion");
            }
            if (ga == null) {
                ga = e("getReleaseType");
            }
            if (tg == null) {
                tg = e("getBuildVersion");
            }
            if (vn == null) {
                vn = Boolean.FALSE;
                try {
                    vn = Boolean.valueOf("156".equals(bf("ro.config.hw_optb", "0")) && com.duokan.reader.domain.payment.a.c.equals(bf("hw_mc.pure_mode.enable", MscKeys.VAL_FALSE)));
                } catch (Exception unused2) {
                }
            }
            try {
                p = Settings.Secure.getInt(com.bytedance.sdk.openadsdk.core.lc.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
            } catch (Throwable unused3) {
            }
            try {
                Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                v = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
            } catch (Throwable unused4) {
            }
        }
    }

    public static String ga() {
        return e;
    }

    public static boolean m() {
        return xu() && e(vn(), ga()) && bh() == 0;
    }

    public static String p() {
        return ga;
    }

    public static boolean tg() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toUpperCase().startsWith("HONOR")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toUpperCase().startsWith("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static String v() {
        return tg;
    }

    public static String vn() {
        return bf;
    }

    public static int wu() {
        return p;
    }

    public static boolean xu() {
        Boolean bool = vn;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean zk() {
        return wu() == 0 && m();
    }

    private static int bf(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    private static String bf(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        } catch (Throwable unused) {
            return str2;
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

    public static boolean e(Context context) {
        return context != null && bf(context) == 0 && xu();
    }

    public static void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i = 1;
            jSONObject.put("pure_enhanced_mode", zk() ? 1 : 2);
            if (!m()) {
                i = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i);
        } catch (Throwable unused) {
        }
    }

    private static boolean e(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }
}
