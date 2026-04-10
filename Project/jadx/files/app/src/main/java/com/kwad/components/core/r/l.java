package com.kwad.components.core.r;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.sdk.utils.r;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    private static Method PZ;
    private static Method Qa;
    private static Field Qb;
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

    static {
        try {
            PZ = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            Qa = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        }
        try {
            Qb = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) r.c((Class<?>) View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private static void a(Activity activity, boolean z2, boolean z3) {
        Method method = Qa;
        if (method == null) {
            a(activity.getWindow(), z2);
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

    private static void a(Window window, boolean z2) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z2);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            g(decorView, z2);
            setStatusBarColor(window, 0);
        }
    }

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z2) {
        try {
            int iIntValue = ((Integer) r.d(layoutParams, str)).intValue();
            int iIntValue2 = ((Integer) r.d(layoutParams, "meizuFlags")).intValue();
            int i2 = z2 ? iIntValue | iIntValue2 : (iIntValue ^ (-1)) & iIntValue2;
            if (iIntValue2 == i2) {
                return false;
            }
            r.a(layoutParams, "meizuFlags", Integer.valueOf(i2));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Activity activity, boolean z2) {
        a(activity, true, true);
    }

    private static void g(View view, boolean z2) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i2 = z2 ? SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility : (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR ^ (-1)) & systemUiVisibility;
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    private static void setStatusBarColor(Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = Qb;
        if (field != null) {
            try {
                if (field.getInt(attributes) != 0) {
                    Qb.set(attributes, 0);
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}
