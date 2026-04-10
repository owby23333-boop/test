package com.qmuiteam.qmui.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDisplayHelper {
    private static final String HUAWAI_DISPLAY_NOTCH_STATUS = "display_notch_status";
    private static final String TAG = "QMUIDisplayHelper";
    private static final String VIVO_NAVIGATION_GESTURE = "navigation_gesture_on";
    private static final String XIAOMI_DISPLAY_NOTCH_STATUS = "force_black";
    private static final String XIAOMI_FULLSCREEN_GESTURE = "force_fsg_nav_bar";
    public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
    private static Boolean sHasCamera = null;

    public static boolean isElevationSupported() {
        return true;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int dpToPx(int i) {
        return (int) ((i * DENSITY) + 0.5f);
    }

    public static int pxToDp(float f) {
        return (int) ((f / DENSITY) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float getFontDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeight(Context context) {
        int i = getDisplayMetrics(context).heightPixels;
        return (QMUIDeviceHelper.isXiaomi() && xiaomiNavigationGestureEnabled(context)) ? i + getResourceNavHeight(context) : i;
    }

    public static int[] getRealScreenSize(Context context) {
        return doGetRealScreenSize(context);
    }

    private static int[] doGetRealScreenSize(Context context) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int iIntValue = displayMetrics.widthPixels;
        int iIntValue2 = displayMetrics.heightPixels;
        try {
            iIntValue = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            iIntValue2 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
        } catch (Exception unused) {
        }
        try {
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            iIntValue = point.x;
            iIntValue2 = point.y;
        } catch (Exception unused2) {
        }
        iArr[0] = iIntValue;
        iArr[1] = iIntValue2;
        return iArr;
    }

    public static int getUsefulScreenWidth(Activity activity) {
        return getUsefulScreenWidth(activity, QMUINotchHelper.hasNotch(activity));
    }

    public static int getUsefulScreenWidth(View view) {
        return getUsefulScreenWidth(view.getContext(), QMUINotchHelper.hasNotch(view));
    }

    public static int getUsefulScreenWidth(Context context, boolean z) {
        int i = getRealScreenSize(context)[0];
        boolean z2 = context.getResources().getConfiguration().orientation == 2;
        if (z) {
            return (z2 && QMUIDeviceHelper.isHuawei() && !huaweiIsNotchSetToShowInSetting(context)) ? i - QMUINotchHelper.getNotchSizeInHuawei(context)[1] : i;
        }
        if (z2) {
            QMUIDeviceHelper.isEssentialPhone();
        }
        return i;
    }

    public static int getUsefulScreenHeight(Activity activity) {
        return getUsefulScreenHeight(activity, QMUINotchHelper.hasNotch(activity));
    }

    public static int getUsefulScreenHeight(View view) {
        return getUsefulScreenHeight(view.getContext(), QMUINotchHelper.hasNotch(view));
    }

    private static int getUsefulScreenHeight(Context context, boolean z) {
        int i = getRealScreenSize(context)[1];
        boolean z2 = context.getResources().getConfiguration().orientation == 1;
        if (!z && z2) {
            QMUIDeviceHelper.isEssentialPhone();
        }
        return i;
    }

    public static boolean isNavMenuExist(Context context) {
        return (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
    }

    public static int dp2px(Context context, int i) {
        return (int) (((double) (getDensity(context) * i)) + 0.5d);
    }

    public static int sp2px(Context context, int i) {
        return (int) (((double) (getFontDensity(context) * i)) + 0.5d);
    }

    public static int px2dp(Context context, int i) {
        return (int) (((double) (i / getDensity(context))) + 0.5d);
    }

    public static int px2sp(Context context, int i) {
        return (int) (((double) (i / getFontDensity(context))) + 0.5d);
    }

    public static boolean hasStatusBar(Context context) {
        return ((context instanceof Activity) && (((Activity) context).getWindow().getAttributes().flags & 1024) == 1024) ? false : true;
    }

    public static int getActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static int getStatusBarHeight(Context context) {
        if (QMUIDeviceHelper.isXiaomi()) {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            int i = Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString());
            if (i > 0) {
                return context.getResources().getDimensionPixelSize(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getNavMenuHeight(Context context) {
        if (!isNavMenuExist(context)) {
            return 0;
        }
        int resourceNavHeight = getResourceNavHeight(context);
        return resourceNavHeight >= 0 ? resourceNavHeight : getRealScreenSize(context)[1] - getScreenHeight(context);
    }

    private static int getResourceNavHeight(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static final boolean hasCamera(Context context) {
        if (sHasCamera == null) {
            PackageManager packageManager = context.getPackageManager();
            sHasCamera = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.camera.front") || packageManager.hasSystemFeature("android.hardware.camera"));
        }
        return sHasCamera.booleanValue();
    }

    public static boolean hasHardwareMenuKey(Context context) {
        return ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    public static boolean hasInternet(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static boolean isPackageExist(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static boolean isSdcardReady() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String getCurCountryLan(Context context) {
        Locale locale = context.getResources().getConfiguration().getLocales().get(0);
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static boolean isZhCN(Context context) {
        return context.getResources().getConfiguration().getLocales().get(0).getCountry().equalsIgnoreCase("CN");
    }

    public static void setFullScreen(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(512);
        window.addFlags(1024);
    }

    public static void cancelFullScreen(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(1024);
        window.clearFlags(512);
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean hasNavigationBar(Context context) {
        if (!deviceHasNavigationBar()) {
            return false;
        }
        if (QMUIDeviceHelper.isVivo()) {
            return vivoNavigationGestureEnabled(context);
        }
        return true;
    }

    private static boolean deviceHasNavigationBar() {
        try {
            Method declaredMethod = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("hasNavigationBar", new Class[0]);
            declaredMethod2.setAccessible(true);
            return ((Boolean) declaredMethod2.invoke(objInvoke, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean vivoNavigationGestureEnabled(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), VIVO_NAVIGATION_GESTURE, 0) != 0;
    }

    public static boolean xiaomiNavigationGestureEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), XIAOMI_FULLSCREEN_GESTURE, 0) != 0;
    }

    public static boolean huaweiIsNotchSetToShowInSetting(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), HUAWAI_DISPLAY_NOTCH_STATUS, 0) == 0;
    }

    public static boolean xiaomiIsNotchSetToShowInSetting(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), XIAOMI_DISPLAY_NOTCH_STATUS, 0) == 0;
    }
}
