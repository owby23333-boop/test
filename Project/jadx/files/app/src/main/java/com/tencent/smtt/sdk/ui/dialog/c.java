package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static float a = -1.0f;
    private static int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f19115c = -1;

    public static int a(Context context) {
        if (b == -1) {
            b(context);
        }
        return b;
    }

    public static int a(Context context, float f2) {
        return b(context, (f2 * 160.0f) / 320.0f);
    }

    private static int b(Context context, float f2) {
        if (a == -1.0f) {
            b(context);
        }
        return (int) ((f2 * a) + 0.5f);
    }

    private static void b(Context context) {
        if (a < 0.0f) {
            try {
                Field declaredField = Class.forName("com.tencent.mobileqq.app.FontSettingManager").getDeclaredField("customMetrics");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                if (obj instanceof DisplayMetrics) {
                    DisplayMetrics displayMetrics = (DisplayMetrics) obj;
                    a = displayMetrics.density;
                    b = displayMetrics.heightPixels;
                }
            } catch (Exception unused) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                a = displayMetrics2.density;
                b = displayMetrics2.heightPixels;
            }
        }
    }
}
