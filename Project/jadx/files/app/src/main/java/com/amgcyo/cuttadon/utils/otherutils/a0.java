package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.TypedValue;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: MkHwSysUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a0 {
    private static Class<?> a;
    static final Set<String> b = new HashSet();

    static {
        b.add("Nexus 4");
        b.add("H60-L01");
        b.add("P7-L07");
        b.add("MT7-UL00");
        try {
            a = Class.forName("com.huawei.android.util.HwNotchSizeUtil");
        } catch (ClassNotFoundException unused) {
        }
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : (int) TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics());
    }

    public static int[] b() {
        Class<?> cls = a;
        if (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("getNotchSize", null);
                declaredMethod.setAccessible(true);
                return (int[]) declaredMethod.invoke(a, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static Uri a() {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return Settings.Global.getUriFor("navigationbar_is_min");
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
