package xyz.doikki.videoplayer.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class CutoutUtil {
    private CutoutUtil() {
    }

    public static void adaptCutoutAboveAndroidP(Context context, boolean z2) {
        Activity activityScanForActivity = PlayerUtils.scanForActivity(context);
        if (activityScanForActivity != null && Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activityScanForActivity.getWindow().getAttributes();
            if (z2) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            activityScanForActivity.getWindow().setAttributes(attributes);
        }
    }

    public static boolean allowDisplayToCutout(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28) {
            return hasCutoutHuawei(activity) || hasCutoutOPPO(activity) || hasCutoutVIVO(activity) || hasCutoutXIAOMI(activity);
        }
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        return (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects().size() <= 0) ? false : true;
    }

    private static boolean hasCutoutHuawei(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            if (clsLoadClass != null) {
                return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean hasCutoutOPPO(Activity activity) {
        if (Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO)) {
            return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasCutoutVIVO(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO)) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.util.FtFeature");
            if (clsLoadClass != null) {
                return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean hasCutoutXIAOMI(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI)) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }
}
