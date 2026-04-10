package com.bytedance.sdk.openadsdk.core.un;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class sy {
    private static String e = null;
    private static String fo = null;
    public static int g = 0;
    private static int gz = Integer.MAX_VALUE;
    public static int z;
    private static final CharSequence dl = "sony";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f1383a = "amigo";
    private static final CharSequence gc = "funtouch";
    private static final CharSequence m = "origin";

    public static String z() {
        if (TextUtils.isEmpty(e)) {
            e = sy();
        }
        return e;
    }

    public static String g() {
        return g("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String dl() {
        return ls() ? "miui_" + g("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String a() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String gc() {
        return iq() ? "coloros_" + g("ro.build.version.kllkrom") + "_" + Build.DISPLAY : "";
    }

    public static String m() {
        String strQ = q();
        return strQ != null ? (strQ.toLowerCase().contains("emotionui") || strQ.toLowerCase().contains("magicui")) ? strQ + "_" + Build.DISPLAY : "" : "";
    }

    public static boolean e() {
        String strG = g("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(strG)) {
            return false;
        }
        return strG.toLowerCase().contains(gc) || strG.toLowerCase().contains("origin");
    }

    public static String gz() {
        return "vivo_" + g("ro.vivo.os.build.display.id") + "_" + g("ro.vivo.product.version");
    }

    public static boolean fo() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(f1383a);
    }

    public static boolean uy() {
        try {
            return "FreemeOS".equalsIgnoreCase(g("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String kb() {
        return Build.DISPLAY + "_" + g("ro.gn.sv.version");
    }

    public static boolean wp() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String i() {
        return v() ? "eui_" + g("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean v() {
        return !TextUtils.isEmpty(g("ro.letv.release.version"));
    }

    public static String pf() {
        if (TextUtils.isEmpty(fo)) {
            fo = uf();
        }
        return fo;
    }

    private static String uf() {
        if (ls()) {
            return dl();
        }
        if (tb()) {
            return a();
        }
        if (iq()) {
            return gc();
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            return strM;
        }
        if (e()) {
            return gz();
        }
        if (fo()) {
            return kb();
        }
        if (wp()) {
            return g();
        }
        String strI = i();
        if (!TextUtils.isEmpty(strI)) {
            return strI;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (io()) {
            return "honor_" + q();
        }
        if (uy()) {
            return "freeme_" + q();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean ls() {
        if (z == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    z = 1;
                } else {
                    z = 2;
                }
            } catch (Exception unused) {
            }
        }
        return z == 1;
    }

    public static boolean p() {
        if (g == 0) {
            try {
                if (Class.forName("com.huawei.system.BuildEx") != null) {
                    g = 1;
                } else {
                    g = 2;
                }
            } catch (Exception unused) {
            }
        }
        return g == 1;
    }

    private static String sy() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (ls()) {
            return "miui_".concat(String.valueOf(str));
        }
        if (p()) {
            return "huawei_".concat(String.valueOf(str));
        }
        if (str2.toLowerCase(Locale.ROOT).contains("oppo")) {
            return "oppo_".concat(String.valueOf(str));
        }
        if (str2.toLowerCase(Locale.ROOT).contains("vivo")) {
            return "vivo_".concat(String.valueOf(str));
        }
        return str2.toLowerCase(Locale.ROOT).contains("oneplus") ? "oneplus_".concat(String.valueOf(str)) : str;
    }

    public static boolean fv() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                if (str.toLowerCase().contains("oppo")) {
                    return true;
                }
                return str.toLowerCase().contains("realme");
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.a("romUtil", e2.getMessage());
        }
        return false;
    }

    public static boolean js() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.a("romUtils", e2.getMessage());
            return false;
        }
    }

    public static boolean tb() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String q() {
        return dl("ro.build.version.emui");
    }

    public static boolean iq() {
        if (gz == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strUy = eo.uy("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.ROOT).contains(strUy)) {
                gz = 1;
            } else {
                gz = 0;
            }
        }
        return gz == 1;
    }

    public static boolean zw() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean io() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            str = q();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || zw();
    }

    public static String g(String str) {
        com.bytedance.sdk.component.a.kb kbVar = (com.bytedance.sdk.component.a.kb) com.bytedance.sdk.openadsdk.ats.dl.z("system_info");
        return kbVar != null ? kbVar.get(str) : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String dl(String str) {
        String strHh;
        try {
            strHh = hh();
            try {
                if (TextUtils.isEmpty(strHh)) {
                    final com.bytedance.sdk.component.uy.gz gzVar = new com.bytedance.sdk.component.uy.gz(new z(str), 5, 2);
                    com.bytedance.sdk.component.uy.e.dl(new com.bytedance.sdk.component.uy.fo("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.core.un.sy.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gzVar.run();
                        }
                    });
                    strHh = (String) gzVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strHh = "";
        }
        return strHh == null ? "" : strHh;
    }

    private static String hh() {
        try {
            return x.z("rom_info").get("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static class z implements Callable<String> {
        private String z;

        public z(String str) {
            this.z = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String strG = sy.g(this.z);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(strG)) {
                try {
                    x.z("rom_info").put("rom_property_info", strG);
                } catch (Throwable unused) {
                }
            }
            return strG;
        }
    }
}
