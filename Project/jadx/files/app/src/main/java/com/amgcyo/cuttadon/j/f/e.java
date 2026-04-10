package com.amgcyo.cuttadon.j.f;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: compiled from: XiaomiNotchUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int b(Context context) {
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean c(Context context) {
        try {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
