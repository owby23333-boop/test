package com.yuewen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes12.dex */
public class fo3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11177a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f11178b = null;
    public static final int c = 32;
    public static final int d = 8;

    public static int a(String str, Context context) {
        if (!"Xiaomi".equals(Build.MANUFACTURER)) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), 0)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b() {
        try {
            f11177a = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception e) {
            e.printStackTrace();
            f11177a = 0;
        }
        return f11177a;
    }

    public static int c() {
        if (-1 == f11177a) {
            synchronized (fo3.class) {
                if (-1 == f11177a) {
                    f11177a = b();
                }
            }
        }
        return f11177a;
    }

    public static boolean d(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean e(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean f(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean g(Context context) {
        return a("ro.miui.notch", context) == 1 || d(context) || e(context) || f(context) || h(context) != null;
    }

    public static DisplayCutout h(Context context) {
        WindowInsets rootWindowInsets;
        try {
            View decorView = ((Activity) context).getWindow().getDecorView();
            if (decorView == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) {
                return null;
            }
            return rootWindowInsets.getDisplayCutout();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean i(Context context) {
        if (f11178b == null) {
            synchronized (fo3.class) {
                if (f11178b == null) {
                    f11178b = Boolean.valueOf(g(context));
                }
            }
        }
        return f11178b.booleanValue();
    }

    @TargetApi(23)
    public static void j(Activity activity) {
        l(activity, true);
        m(activity, true);
        activity.getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    @TargetApi(23)
    public static void k(Activity activity) {
        l(activity, false);
        m(activity, false);
    }

    public static void l(@NonNull Activity activity, boolean z) {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Exception unused) {
        }
    }

    public static void m(@NonNull Activity activity, boolean z) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
        } catch (Exception unused) {
        }
    }
}
