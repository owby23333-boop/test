package com.github.gzuliyujiang.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: compiled from: OAIDRom.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            e.a("System property invoke error: " + e2);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static boolean b() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean c() {
        return a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static boolean e() {
        return !TextUtils.isEmpty(a("ro.build.freeme.label", ""));
    }

    public static boolean f() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public static boolean g() {
        return Build.MANUFACTURER.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("ZUK");
    }

    public static boolean h() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean i() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean j() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean k() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean l() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean m() {
        return Build.MANUFACTURER.equalsIgnoreCase("OPPO") || Build.BRAND.equalsIgnoreCase("OPPO") || Build.BRAND.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(a("ro.build.version.opporom", ""));
    }

    public static boolean n() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean o() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(a("ro.vivo.os.version", ""));
    }

    public static boolean p() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    public static boolean a() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
