package com.github.gzuliyujiang.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class OAIDRom {
    private OAIDRom() {
    }

    public static String sysProperty(String key, String defValue) {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, key, defValue);
        } catch (Exception e) {
            OAIDLog.print("System property invoke error: " + e);
            str = null;
        }
        return str == null ? "" : str;
    }

    public static boolean isHuawei() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public static boolean isEmui() {
        return !TextUtils.isEmpty(sysProperty("ro.build.version.emui", ""));
    }

    public static boolean isOppo() {
        return Build.MANUFACTURER.equalsIgnoreCase("OPPO") || Build.BRAND.equalsIgnoreCase("OPPO") || Build.BRAND.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""));
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(sysProperty("ro.vivo.os.version", ""));
    }

    public static boolean isXiaomi() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(sysProperty("ro.miui.ui.version.name", ""));
    }

    public static boolean isBlackShark() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean isOnePlus() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean isLenovo() {
        return Build.MANUFACTURER.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("LENOVO") || Build.BRAND.equalsIgnoreCase("ZUK");
    }

    public static boolean isNubia() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean isASUS() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean isZTE() {
        return Build.MANUFACTURER.equalsIgnoreCase("ZTE") || Build.BRAND.equalsIgnoreCase("ZTE");
    }

    public static boolean isMotolora() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean isFreeme() {
        return !TextUtils.isEmpty(sysProperty("ro.build.freeme.label", ""));
    }

    public static boolean isCoolpad(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isCoosea() {
        return sysProperty("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean isSSUI() {
        return !TextUtils.isEmpty(sysProperty("ro.ssui.product", ""));
    }
}
