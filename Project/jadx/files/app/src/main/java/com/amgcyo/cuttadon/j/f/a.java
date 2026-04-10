package com.amgcyo.cuttadon.j.f;

import android.content.Context;

/* JADX INFO: compiled from: HwNotchUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int[] a(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
        } catch (Throwable unused) {
            return iArr;
        }
    }

    public static boolean b(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}
