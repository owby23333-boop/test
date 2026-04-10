package com.ss.android.socialbase.appdownloader.m;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.appdownloader.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes4.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2041a = "";
    public static String dl = null;
    private static String e = null;
    public static String g = "";
    private static String gc;
    private static Boolean gz;
    private static String m;
    public static String z;

    public static boolean z() {
        return z("EMUI") || z("MAGICUI");
    }

    public static boolean g() {
        return z("MAGICUI");
    }

    public static boolean dl() {
        return z("MIUI");
    }

    public static boolean a() {
        return z("VIVO");
    }

    public static boolean gc() {
        fv();
        return z(z);
    }

    public static boolean m() {
        return z("FLYME");
    }

    public static boolean e() {
        return z("SAMSUNG");
    }

    public static String gz() {
        if (gc == null) {
            z("");
        }
        return gc;
    }

    public static String fo() {
        if (m == null) {
            z("");
        }
        return m;
    }

    public static String uy() {
        if (dl == null) {
            z("");
        }
        return dl;
    }

    private static void fv() {
        if (TextUtils.isEmpty(z)) {
            com.ss.android.socialbase.downloader.downloader.dl.lq();
            z = com.ss.android.socialbase.downloader.g.gc.g;
            f2041a = "ro.build.version." + com.ss.android.socialbase.downloader.g.gc.dl + "rom";
            g = "com." + com.ss.android.socialbase.downloader.g.gc.dl + ".market";
        }
    }

    public static boolean z(String str) {
        fv();
        String str2 = gc;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strA = a("ro.miui.ui.version.name");
        m = strA;
        if (!TextUtils.isEmpty(strA)) {
            gc = "MIUI";
            dl = "com.xiaomi.market";
            e = m;
        } else {
            String strA2 = a("ro.build.version.emui");
            m = strA2;
            if (!TextUtils.isEmpty(strA2)) {
                String str3 = p() ? "MAGICUI" : "EMUI";
                gc = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    dl = "com.hihonor.appmarket";
                } else {
                    dl = "com.huawei.appmarket";
                }
            } else {
                String strA3 = a("ro.build.version.magic");
                m = strA3;
                if (!TextUtils.isEmpty(strA3)) {
                    gc = "MAGICUI";
                    dl = "com.hihonor.appmarket";
                } else {
                    String strA4 = a(f2041a);
                    m = strA4;
                    if (!TextUtils.isEmpty(strA4)) {
                        gc = z;
                        if (e.z(g) >= 0) {
                            dl = g;
                        } else {
                            dl = "com.heytap.market";
                        }
                    } else {
                        String strA5 = a("ro.vivo.os.version");
                        m = strA5;
                        if (!TextUtils.isEmpty(strA5)) {
                            gc = "VIVO";
                            dl = "com.bbk.appstore";
                        } else {
                            String strA6 = a("ro.smartisan.version");
                            m = strA6;
                            if (!TextUtils.isEmpty(strA6)) {
                                gc = "SMARTISAN";
                                dl = "com.smartisanos.appstore";
                            } else {
                                String strA7 = a("ro.gn.sv.version");
                                m = strA7;
                                if (!TextUtils.isEmpty(strA7)) {
                                    gc = "QIONEE";
                                    dl = "com.gionee.aora.market";
                                } else {
                                    String strA8 = a("ro.lenovo.lvp.version");
                                    m = strA8;
                                    if (!TextUtils.isEmpty(strA8)) {
                                        gc = "LENOVO";
                                        dl = "com.lenovo.leos.appstore";
                                    } else if (kb().toUpperCase().contains("SAMSUNG")) {
                                        gc = "SAMSUNG";
                                        dl = "com.sec.android.app.samsungapps";
                                    } else if (kb().toUpperCase().contains("ZTE")) {
                                        gc = "ZTE";
                                        dl = "zte.com.market";
                                    } else if (kb().toUpperCase().contains("NUBIA")) {
                                        gc = "NUBIA";
                                        dl = "cn.nubia.neostore";
                                    } else if (wp().toUpperCase().contains("FLYME")) {
                                        gc = "FLYME";
                                        dl = "com.meizu.mstore";
                                        m = wp();
                                    } else if (kb().toUpperCase().contains("ONEPLUS")) {
                                        gc = "ONEPLUS";
                                        m = a("ro.rom.version");
                                        if (e.z(g) >= 0) {
                                            dl = g;
                                        } else {
                                            dl = "com.heytap.market";
                                        }
                                    } else {
                                        gc = kb().toUpperCase();
                                        dl = "";
                                        m = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return gc.equals(str);
    }

    public static String g(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.ss.android.socialbase.downloader.pf.m.z(bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.pf.m.z(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String dl(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String a(String str) {
        if (com.ss.android.socialbase.downloader.i.z.g().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return dl(str);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return g(str);
    }

    public static String kb() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static String wp() {
        return Build.DISPLAY == null ? "" : Build.DISPLAY.trim();
    }

    public static boolean i() {
        js();
        return "V10".equals(e);
    }

    public static boolean v() {
        js();
        return "V11".equals(e);
    }

    public static boolean pf() {
        js();
        return "V12".equals(e);
    }

    private static void js() {
        if (e == null) {
            try {
                e = a("ro.miui.ui.version.name");
            } catch (Exception e2) {
                wp.z(e2);
            }
            String str = e;
            if (str == null) {
                str = "";
            }
            e = str;
        }
    }

    public static boolean ls() {
        if (gz == null) {
            gz = Boolean.valueOf(a.e().equals("harmony"));
        }
        return gz.booleanValue();
    }

    public static boolean p() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor");
        }
        return true;
    }
}
