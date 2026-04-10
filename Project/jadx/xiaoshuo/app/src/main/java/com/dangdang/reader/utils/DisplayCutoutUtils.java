package com.dangdang.reader.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes10.dex */
public class DisplayCutoutUtils {
    public static boolean checkDisplayCutout(Context context) {
        if (context != null && (context instanceof Activity)) {
            return isAndroidPCutout((Activity) context);
        }
        return false;
    }

    public static boolean checkHuaweiDevice() {
        return "Huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static boolean checkHuaweiHasNotchInScreen(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.d("liupan", "hasNotchInScreen ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.d("liupan", "hasNotchInScreen NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            Log.d("liupan", "hasNotchInScreen Exception");
            return false;
        }
    }

    public static boolean checkOppoDevice() {
        return "oppo".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static boolean checkOppoHasNotchInScreen(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Throwable unused) {
            Log.d("liupan", "hasNotchInScreen Exception");
            return false;
        }
    }

    private static boolean checkVivoDevice() {
        return "vivo".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static boolean checkVivoHasNotchInScreen(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.d("liupan", "hasNotchInScreen ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.d("liupan", "hasNotchInScreen NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            Log.d("liupan", "hasNotchInScreen Exception");
            return false;
        }
    }

    private static int[] getHuaweiNotchSize(Context context) {
        int[] iArr = {0, 0};
        try {
            try {
                try {
                    Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
                } catch (ClassNotFoundException unused) {
                    Log.e("liupan", "getNotchSize ClassNotFoundException");
                    return iArr;
                } catch (NoSuchMethodException unused2) {
                    Log.e("liupan", "getNotchSize NoSuchMethodException");
                    return iArr;
                }
            } catch (Exception unused3) {
                Log.e("liupan", "getNotchSize Exception");
                return iArr;
            }
        } catch (Throwable unused4) {
            return iArr;
        }
    }

    public static int getInt(String str, Activity activity) {
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), new Integer(0))).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return 0;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static boolean isAndroidPCutout(Activity activity) {
        View decorView;
        WindowInsets rootWindowInsets;
        return (activity == null || (decorView = activity.getWindow().getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null || rootWindowInsets.getDisplayCutout() == null) ? false : true;
    }

    public static boolean isXiaomi() {
        return "Xiaomi".equals(Build.MANUFACTURER);
    }
}
