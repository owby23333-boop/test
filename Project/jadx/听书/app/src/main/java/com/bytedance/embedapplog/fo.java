package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    private static final CharSequence z = "sony";
    private static final CharSequence g = "amigo";
    private static final CharSequence dl = "funtouch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final z<Boolean> f285a = new z<Boolean>() { // from class: com.bytedance.embedapplog.fo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.fo.z
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Boolean g(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
    };

    public static String z() {
        return g("ro.build.version.emui");
    }

    public static String g() {
        if (pf()) {
            return ls();
        }
        if (m()) {
            return fv();
        }
        if (js()) {
            return q();
        }
        String strP = p();
        if (!TextUtils.isEmpty(strP)) {
            return strP;
        }
        if (e()) {
            return gc();
        }
        if (gz()) {
            return fo();
        }
        if (a()) {
            return dl();
        }
        String strUy = uy();
        return !TextUtils.isEmpty(strUy) ? strUy : Build.DISPLAY;
    }

    public static String dl() {
        return g("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean a() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String gc() {
        return g("ro.vivo.os.build.display.id") + "_" + g("ro.vivo.product.version");
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            str = z();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || wp() || i();
    }

    public static boolean m() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean e() {
        String strG = g("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strG) && strG.toLowerCase().contains(dl);
    }

    public static boolean gz() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(g);
    }

    public static String fo() {
        return Build.DISPLAY + "_" + g("ro.gn.sv.version");
    }

    public static String uy() {
        return kb() ? "eui_" + g("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean kb() {
        return !TextUtils.isEmpty(g("ro.letv.release.version"));
    }

    public static boolean wp() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei");
        }
        return true;
    }

    public static boolean i() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean v() {
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.a("Honor", e.getMessage());
        }
        return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui"));
    }

    public static boolean pf() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String ls() {
        return pf() ? "miui_" + g("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String p() {
        String strZ = z();
        return strZ != null ? (strZ.toLowerCase().contains("emotionui") || strZ.toLowerCase().contains("magicui")) ? strZ + "_" + Build.DISPLAY : "" : "";
    }

    public static String fv() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean js() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean tb() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    public static String q() {
        return js() ? "coloros_" + g("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String g(String str) {
        String strZ = wx.z(str);
        return !TextUtils.isEmpty(strZ) ? strZ : o.z(str);
    }

    public static boolean iq() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean zw() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean io() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String l() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean uf() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strG = g("ro.build.version.incremental");
        return !TextUtils.isEmpty(strG) && strG.contains("VIBEUI_V2");
    }

    public static boolean sy() {
        return l().toUpperCase().contains("NUBIA");
    }

    public static boolean hh() {
        return l().toUpperCase().contains("ASUS");
    }

    public static boolean z(Context context) {
        return l().toUpperCase().contains("HUAWEI");
    }

    public static abstract class z<T> {
        private volatile T z;

        protected abstract T g(Object... objArr);

        public final T dl(Object... objArr) {
            if (this.z == null) {
                synchronized (this) {
                    if (this.z == null) {
                        this.z = g(objArr);
                    }
                }
            }
            return this.z;
        }
    }
}
