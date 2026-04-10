package com.bytedance.msdk.z.gc;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f501a = -1;
    private static float dl = -1.0f;
    private static int g = -1;
    private static int gc = -1;
    private static float z = -1.0f;

    static {
        z(com.bytedance.msdk.core.g.getContext());
    }

    public static void z(Context context) {
        Context context2 = context == null ? com.bytedance.msdk.core.g.getContext() : context;
        if (context2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        z = displayMetrics.density;
        g = displayMetrics.densityDpi;
        dl = displayMetrics.scaledDensity;
        f501a = displayMetrics.widthPixels;
        gc = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i = f501a;
            int i2 = gc;
            if (i > i2) {
                f501a = i2;
                gc = i;
                return;
            }
            return;
        }
        int i3 = f501a;
        int i4 = gc;
        if (i3 < i4) {
            f501a = i4;
            gc = i3;
        }
    }

    public static int z(Context context, float f) {
        z(context);
        float fA = a(context);
        if (fA <= 0.0f) {
            fA = 1.0f;
        }
        return (int) ((f / fA) + 0.5f);
    }

    public static int g(Context context) {
        z(context);
        return f501a;
    }

    public static int dl(Context context) {
        z(context);
        return gc;
    }

    public static float a(Context context) {
        z(context);
        return z;
    }

    public static int gc(Context context) {
        z(context);
        return g;
    }

    public static int g(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
