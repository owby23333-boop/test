package com.github.gzuliyujiang.oaid;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.d.a;
import com.xiaomi.passport.ui.utils.OsHelper;

/* JADX INFO: loaded from: classes7.dex */
public final class OAIDRom {
    private OAIDRom() {
    }

    public static boolean is360() {
        return Build.MANUFACTURER.equalsIgnoreCase("360") || Build.BRAND.equalsIgnoreCase("360");
    }

    public static boolean isASUS() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean isAmigo() {
        return Build.MANUFACTURER.equalsIgnoreCase("AMIGO") || Build.BRAND.equalsIgnoreCase("AMIGO") || Build.DISPLAY.toUpperCase().contains("AMIGO") || !TextUtils.isEmpty(sysProperty("ro.gn.gnromvernumber", ""));
    }

    public static boolean isBlackShark() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean isCoolpad() {
        String str = Build.MANUFACTURER;
        if (!str.equalsIgnoreCase("YULONG") && !str.equalsIgnoreCase("COOLPAD")) {
            String str2 = Build.BRAND;
            if (!str2.equalsIgnoreCase("COOLPAD") && !str.equalsIgnoreCase(OsHelper.ROM_QIKU) && !str2.equalsIgnoreCase(OsHelper.ROM_QIKU)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFreeme() {
        if (Build.MANUFACTURER.equalsIgnoreCase("FREEMEOS")) {
            return true;
        }
        return !TextUtils.isEmpty(sysProperty("ro.build.freeme.label", ""));
    }

    public static boolean isHuawei() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR") && TextUtils.isEmpty(sysProperty(a.f1791a, ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLG() {
        return Build.MANUFACTURER.equalsIgnoreCase("LG") || Build.BRAND.equalsIgnoreCase("LG");
    }

    public static boolean isLenovo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLetv() {
        return Build.MANUFACTURER.equalsIgnoreCase("LETV") || Build.BRAND.equalsIgnoreCase("LETV") || !TextUtils.isEmpty(sysProperty("ro.letv.release.version", ""));
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains(OsHelper.ROM_FLYME);
    }

    public static boolean isMotolora() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean isNubia() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean isOnePlus() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean isOppo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(OsHelper.ROM_OPPO)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(OsHelper.ROM_OPPO) && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSSUI() {
        if (Build.MANUFACTURER.equalsIgnoreCase("SSUI")) {
            return true;
        }
        return !TextUtils.isEmpty(sysProperty("ro.ssui.product", ""));
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean isSmartisan() {
        return Build.MANUFACTURER.equalsIgnoreCase(OsHelper.ROM_SMARTISAN) || Build.BRAND.equalsIgnoreCase(OsHelper.ROM_SMARTISAN) || !TextUtils.isEmpty(sysProperty("ro.smartisan.version", ""));
    }

    public static boolean isSony() {
        return Build.MANUFACTURER.equalsIgnoreCase("SONY") || Build.BRAND.equalsIgnoreCase("SONY");
    }

    public static boolean isVivo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(OsHelper.ROM_VIVO)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(OsHelper.ROM_VIVO) && !str.equalsIgnoreCase("IQOO") && TextUtils.isEmpty(sysProperty("ro.vivo.os.version", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isXiaomi() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI") && !str.equalsIgnoreCase("MEITU") && TextUtils.isEmpty(sysProperty("ro.miui.ui.version.name", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZTE() {
        return Build.MANUFACTURER.equalsIgnoreCase("ZTE") || Build.BRAND.equalsIgnoreCase("ZTE");
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
