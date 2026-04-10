package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: loaded from: classes2.dex */
public class ax {
    private static DisplayMetrics a;
    private static float b;

    public static Rect a(Context context) {
        DisplayMetrics displayMetricsF = f(context);
        try {
            return displayMetricsF.widthPixels > displayMetricsF.heightPixels ? new Rect(0, 0, displayMetricsF.heightPixels, displayMetricsF.widthPixels) : new Rect(0, 0, displayMetricsF.widthPixels, displayMetricsF.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics displayMetricsF = f(context);
        return new Rect(0, 0, displayMetricsF.widthPixels, displayMetricsF.heightPixels);
    }

    public static float e(Context context) {
        if (b < 0.01d) {
            b = f(context).density;
        }
        return b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            if (a != null && a.widthPixels > 0) {
                return a;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (bj.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            }
            a = displayMetrics;
        } catch (Throwable th) {
            a = new DisplayMetrics();
            bq.a().a(th);
        }
        return a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static int b(Context context, int i2) {
        try {
            return (int) (i2 * e(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i2) {
        try {
            return (int) (i2 / e(context));
        } catch (Exception unused) {
            return i2;
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
