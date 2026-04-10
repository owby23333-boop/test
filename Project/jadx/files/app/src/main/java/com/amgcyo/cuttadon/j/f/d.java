package com.amgcyo.cuttadon.j.f;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: compiled from: VivoNotchUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int a(Context context) {
        return a(context, 32);
    }

    public static int b(Context context) {
        return a(context, 100);
    }

    public static boolean c(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int a(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }
}
