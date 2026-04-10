package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.amgcyo.cuttadon.app.MkApplication;
import java.io.IOException;

/* JADX INFO: compiled from: ConvertUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static int a(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(Context context) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = context.getResources().getDisplayMetrics().heightPixels;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (f3 / f2) + 0.5f;
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float d(Context context) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = context.getResources().getDisplayMetrics().widthPixels;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (f3 / f2) + 0.5f;
    }

    public static int a(int i2) {
        return (int) TypedValue.applyDimension(1, i2, a());
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics a() {
        return MkApplication.getAppContext().getResources().getDisplayMetrics();
    }

    public static int b(float f2) {
        return (int) ((f2 / MkApplication.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(String str) {
        try {
            return u0.a.a.a.a().a(str);
        } catch (IOException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
