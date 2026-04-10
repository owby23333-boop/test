package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class SpecialBarFontUtils {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    static {
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    SpecialBarFontUtils() {
    }

    private static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z2) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(layoutParams);
            int i4 = z2 ? i2 | i3 : (i2 ^ (-1)) & i3;
            if (i3 == i4) {
                return false;
            }
            declaredField2.setInt(layoutParams, i4);
            return true;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    static boolean isBlackColor(int i2, int i3) {
        return toGrey(i2) < i3;
    }

    @SuppressLint({"PrivateApi"})
    static void setMIUIBarDark(Window window, String str, boolean z2) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z2) {
                    method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i2));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void setStatusBarColor(Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i2) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i2));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i2) {
        Method method = mSetStatusBarColorIcon;
        if (method == null) {
            boolean zIsBlackColor = isBlackColor(i2, 50);
            if (mStatusBarColorFiled == null) {
                setStatusBarDarkIcon(activity, zIsBlackColor);
                return;
            } else {
                setStatusBarDarkIcon(activity, zIsBlackColor, zIsBlackColor);
                setStatusBarDarkIcon(activity.getWindow(), i2);
                return;
            }
        }
        try {
            method.invoke(activity, Integer.valueOf(i2));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    static int toGrey(int i2) {
        return (((((i2 & 16711680) >> 16) * 38) + (((65280 & i2) >> 8) * 75)) + ((i2 & 255) * 15)) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i2) {
        try {
            setStatusBarColor(window, i2);
            if (Build.VERSION.SDK_INT > 22) {
                setStatusBarDarkIcon(window.getDecorView(), true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z2) {
        setStatusBarDarkIcon(activity, z2, true);
    }

    private static void setStatusBarDarkIcon(View view, boolean z2) {
        int i2;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z2) {
            i2 = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i2 = (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR ^ (-1)) & systemUiVisibility;
        }
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z2) {
        if (Build.VERSION.SDK_INT < 23) {
            changeMeizuFlag(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z2);
        } else {
            setStatusBarDarkIcon(window.getDecorView(), z2);
            setStatusBarColor(window, 0);
        }
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z2, boolean z3) {
        Method method = mSetStatusBarDarkIcon;
        if (method == null) {
            if (z3) {
                setStatusBarDarkIcon(activity.getWindow(), z2);
                return;
            }
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z2));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }
}
