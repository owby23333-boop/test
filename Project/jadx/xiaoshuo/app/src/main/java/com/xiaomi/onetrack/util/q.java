package com.xiaomi.onetrack.util;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.OneTrack;
import com.yuewen.i60;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
import miuix.provider.ExtraSettings;

/* JADX INFO: loaded from: classes8.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7766a = 33;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7767b = 29;
    public static final int c = 25;
    public static final int d = 24;
    public static final int e = 23;
    public static final int f = 22;
    public static final int g = 21;
    public static final int h = 19;
    public static final int i = 17;
    public static final int j = 28;
    public static final int k = 2;
    public static final int l = 4;
    private static final String m = "OsUtil";
    private static Class n = null;
    private static Method o = null;
    private static Boolean p = null;
    private static final String q = "";
    private static Method r = null;
    private static boolean s = false;
    private static String t = null;
    private static boolean u = false;
    private static int v;

    static {
        try {
            r = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
        } catch (Throwable th) {
            p.b(m, "sGetProp init failed ex: " + th.getMessage());
        }
        try {
            n = Class.forName("miui.os.Build");
        } catch (Throwable th2) {
            p.b(m, "sMiuiBuild init failed ex: " + th2.getMessage());
        }
        try {
            Method declaredMethod = Class.forName("android.provider.MiuiSettings$Secure").getDeclaredMethod("isUserExperienceProgramEnable", ContentResolver.class);
            o = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Throwable th3) {
            p.b(m, "sMiuiUEPMethod init failed ex: " + th3.getMessage());
        }
    }

    public static boolean a() {
        Boolean bool = p;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (TextUtils.isEmpty(b(com.xiaomi.ad.c.f7255a))) {
            p = Boolean.FALSE;
        } else {
            p = Boolean.TRUE;
        }
        return p.booleanValue();
    }

    private static String b(String str) {
        try {
            Method method = r;
            if (method != null) {
                return String.valueOf(method.invoke(null, str));
            }
        } catch (Exception e2) {
            p.b(m, "getProp failed ex: " + e2.getMessage());
        }
        return null;
    }

    public static String c() {
        Class cls = n;
        if (cls == null) {
            return "";
        }
        try {
            if (((Boolean) cls.getField("IS_ALPHA_BUILD").get(null)).booleanValue()) {
                return "A";
            }
            if (((Boolean) n.getField("IS_STABLE_VERSION").get(null)).booleanValue()) {
                return "S";
            }
            boolean zContains = Build.VERSION.INCREMENTAL.contains(".DEV");
            boolean zBooleanValue = ((Boolean) n.getField("IS_DEVELOPMENT_VERSION").get(null)).booleanValue();
            return (!zBooleanValue || zContains) ? (zBooleanValue && zContains) ? "X" : "" : "D";
        } catch (Exception e2) {
            Log.e(m, "getRomBuildCode failed: " + e2.toString());
            return "";
        }
    }

    public static String d() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String e() {
        return ab.a(i60.v, "");
    }

    public static String f() {
        return Build.VERSION.RELEASE;
    }

    public static int g() {
        Integer num;
        Throwable th;
        int iMyUid;
        try {
            Method declaredMethod = Class.forName("android.os.UserHandle").getDeclaredMethod("getUserId", Integer.TYPE);
            declaredMethod.setAccessible(true);
            iMyUid = Process.myUid();
            num = (Integer) declaredMethod.invoke(null, Integer.valueOf(iMyUid));
        } catch (Throwable th2) {
            num = null;
            th = th2;
        }
        try {
            p.a(m, String.format("getUserId, uid:%d, userId:%d", Integer.valueOf(iMyUid), num));
        } catch (Throwable th3) {
            th = th3;
            Log.e(p.a(m), "getUserId exception: " + th.getMessage());
        }
        if (num == null) {
            num = 0;
        }
        return num.intValue();
    }

    @TargetApi(17)
    public static boolean h() {
        try {
            boolean z = Settings.Global.getInt(com.xiaomi.onetrack.f.a.b().getContentResolver(), "device_provisioned", 0) != 0;
            if (!z) {
                p.c(m, "Provisioned: " + z);
            }
            return z;
        } catch (Exception e2) {
            p.b(m, "isDeviceProvisioned exception", e2);
            return true;
        }
    }

    public static boolean i() {
        return (!a() || u) ? s : m();
    }

    public static String j() {
        if ((!a() || u) && !TextUtils.isEmpty(t)) {
            return t;
        }
        return l();
    }

    public static String k() {
        return l();
    }

    private static String l() {
        try {
            String strA = ab.a("ro.miui.region", "");
            if (TextUtils.isEmpty(strA)) {
                strA = ab.a("ro.product.locale.region", "");
            }
            if (TextUtils.isEmpty(strA)) {
                Object objInvoke = Class.forName("android.os.LocaleList").getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
                Object objInvoke2 = objInvoke.getClass().getMethod("size", new Class[0]).invoke(objInvoke, new Object[0]);
                if ((objInvoke2 instanceof Integer) && ((Integer) objInvoke2).intValue() > 0) {
                    Object objInvoke3 = objInvoke.getClass().getMethod("get", Integer.TYPE).invoke(objInvoke, 0);
                    Object objInvoke4 = objInvoke3.getClass().getMethod("getCountry", new Class[0]).invoke(objInvoke3, new Object[0]);
                    if (objInvoke4 instanceof String) {
                        strA = (String) objInvoke4;
                    }
                }
            }
            if (TextUtils.isEmpty(strA)) {
                strA = Locale.getDefault().getCountry();
            }
            if (!TextUtils.isEmpty(strA)) {
                return strA.trim();
            }
        } catch (Throwable th) {
            p.b(m, "getRegion Exception: " + th.getMessage());
        }
        return "";
    }

    private static boolean m() {
        Class cls = n;
        if (cls != null) {
            try {
                return ((Boolean) cls.getField("IS_INTERNATIONAL_BUILD").get(null)).booleanValue();
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(l())) {
            return false;
        }
        return !TextUtils.equals("CN", r0.toUpperCase());
    }

    public static String b() {
        return a(TimeZone.getDefault().getRawOffset());
    }

    public static String a(int i2) {
        char c2;
        try {
            int i3 = i2 / 60000;
            if (i3 < 0) {
                i3 = -i3;
                c2 = '-';
            } else {
                c2 = '+';
            }
            StringBuilder sb = new StringBuilder(9);
            sb.append("GMT");
            sb.append(c2);
            a(sb, i3 / 60);
            sb.append(':');
            a(sb, i3 % 60);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static void a(StringBuilder sb, int i2) {
        String string = Integer.toString(i2);
        for (int i3 = 0; i3 < 2 - string.length(); i3++) {
            sb.append('0');
        }
        sb.append(string);
    }

    public static boolean a(Context context) {
        if (o == null) {
            try {
                if (a()) {
                    int i2 = Settings.Secure.getInt(context.getContentResolver(), ExtraSettings.Secure.UPLOAD_LOG, -1);
                    p.a(m, "isUserExperiencePlanEnabled upload_log_value: " + i2);
                    if (i2 != 1 && i2 == 0) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                p.a(m, "Settings failed: " + th.toString());
            }
        }
        try {
            return ((Boolean) o.invoke(null, context.getContentResolver())).booleanValue();
        } catch (Throwable th2) {
            Log.d(m, "isUserExperiencePlanEnabled failed: " + th2.getMessage());
            return true;
        }
    }

    public static boolean a(String str) {
        if (!OneTrack.isDisable() && !OneTrack.isUseSystemNetTrafficOnly()) {
            if (!h()) {
                p.c(str, "should not access network or location, not provisioned");
                return true;
            }
            if (com.xiaomi.onetrack.c.i.b()) {
                return false;
            }
            p.c(str, "should not access network or location, cta");
            return true;
        }
        p.c(str, "should not access network or location, cta");
        return true;
    }

    public static void a(boolean z, String str, OneTrack.Mode mode) {
        int i2;
        if (mode == OneTrack.Mode.APP) {
            i2 = 3;
        } else if (mode == OneTrack.Mode.PLUGIN) {
            i2 = 2;
        } else {
            i2 = mode == OneTrack.Mode.SDK ? 1 : 0;
        }
        if (v <= i2) {
            s = z;
            t = str;
            v = i2;
        }
    }

    public static void a(boolean z) {
        u = z;
    }
}
