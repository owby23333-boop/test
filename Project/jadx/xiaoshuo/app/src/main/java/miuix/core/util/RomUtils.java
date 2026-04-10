package miuix.core.util;

import android.text.TextUtils;
import miuix.os.Build;

/* JADX INFO: loaded from: classes7.dex */
public class RomUtils {
    private static int HYPER_OS_VERSION_CODE = -1;
    private static int MIUI_VERSION_CODE = -1;
    private static final String PROP_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String PROP_OS_VERSION_CODE = "ro.mi.os.version.code";

    private RomUtils() {
    }

    public static int getHyperOsVersion() {
        if (HYPER_OS_VERSION_CODE == -1) {
            HYPER_OS_VERSION_CODE = getHyperOsVersionNoCache();
        }
        return HYPER_OS_VERSION_CODE;
    }

    public static int getHyperOsVersionNoCache() {
        return SystemProperties.getInt("ro.mi.os.version.code", 0);
    }

    public static int getMiuiVersion() {
        if (MIUI_VERSION_CODE == -1) {
            MIUI_VERSION_CODE = getMiuiVersionNoCache();
        }
        return MIUI_VERSION_CODE;
    }

    public static int getMiuiVersionNoCache() {
        return SystemProperties.getInt("ro.miui.ui.version.code", 0);
    }

    public static boolean isHyperOsRom() {
        return getHyperOsVersion() > 0;
    }

    public static boolean isInternationalBuild() {
        return Build.IS_INTERNATIONAL_BUILD;
    }

    public static boolean isMiproFontSupported() {
        if (!isInternationalBuild() || getMiuiVersion() >= 14) {
            return isMiuiXISdkSupported();
        }
        return false;
    }

    public static boolean isMiuiRom() {
        return getMiuiVersion() > 0;
    }

    public static boolean isMiuiXIIISdkSupported() {
        return getMiuiVersion() >= 13;
    }

    public static boolean isMiuiXIISdkSupported() {
        return getMiuiVersion() >= 10;
    }

    public static boolean isMiuiXIIV2SdkSupported() {
        return getMiuiVersion() >= 11;
    }

    public static boolean isMiuiXISdkSupported() {
        return getMiuiVersion() >= 9;
    }

    public static boolean isMiuiXIVSdkSupported() {
        return getMiuiVersion() >= 14;
    }

    public static boolean isMiuiXSdkSupported() {
        return getMiuiVersion() >= 8;
    }

    public static boolean isMiuiXVSdkSupported() {
        return getMiuiVersion() >= 15;
    }

    public static boolean isXiaomiSystem() {
        return (TextUtils.isEmpty(SystemProperties.get("ro.mi.os.version.code", "")) && TextUtils.isEmpty(SystemProperties.get("ro.miui.ui.version.code", ""))) ? false : true;
    }
}
