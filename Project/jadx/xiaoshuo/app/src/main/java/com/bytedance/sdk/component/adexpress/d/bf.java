package com.bytedance.sdk.component.adexpress.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.yuewen.kl2;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static boolean e;

    public static int bf(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext();
        }
        float fGa = ga(context);
        if (fGa <= 0.0f) {
            fGa = 1.0f;
        }
        return (int) ((f / fGa) + 0.5f);
    }

    public static float d(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext();
        }
        return f * ga(context);
    }

    public static int e(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    private static float ga(Context context) {
        try {
            if (e) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", new Class[0]).setAccessible(true);
                return ((Integer) r1.invoke(r0, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static String tg(Context context) {
        try {
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static float e(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext();
        }
        return (f * ga(context)) + 0.5f;
    }

    public static int bf(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int d(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService(kl2.t9)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int e(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
