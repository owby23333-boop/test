package com.gyf.immersionbar;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.gyf.immersionbar.e;

/* JADX INFO: compiled from: BarConfig.java */
/* JADX INFO: loaded from: classes2.dex */
class a {
    private final int a;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f16381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f16382f;

    a(Activity activity) {
        this.f16381e = activity.getResources().getConfiguration().orientation == 1;
        this.f16382f = b(activity);
        this.a = a(activity, "status_bar_height");
        a(activity);
        this.f16379c = a((Context) activity);
        this.f16380d = c((Context) activity);
        this.b = this.f16379c > 0;
    }

    @TargetApi(14)
    private int a(Activity activity) {
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        View viewFindViewById = activity.getWindow().findViewById(R$id.action_bar_container);
        int measuredHeight = viewFindViewById != null ? viewFindViewById.getMeasuredHeight() : 0;
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    @SuppressLint({"NewApi"})
    private float b(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        float f2 = displayMetrics.widthPixels;
        float f3 = displayMetrics.density;
        return Math.min(f2 / f3, displayMetrics.heightPixels / f3);
    }

    @TargetApi(14)
    private int c(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !c((Activity) context)) {
            return 0;
        }
        return a(context, "navigation_bar_width");
    }

    boolean d() {
        return this.b;
    }

    boolean e() {
        return this.f16382f >= 600.0f || this.f16381e;
    }

    @TargetApi(14)
    private boolean c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            e.a aVarA = e.a(activity);
            if (!aVarA.b && aVarA.a) {
                return false;
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i3 - displayMetrics2.widthPixels > 0 || i2 - displayMetrics2.heightPixels > 0;
    }

    @TargetApi(14)
    private int a(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !c((Activity) context)) {
            return 0;
        }
        return b(context);
    }

    int b() {
        return this.f16380d;
    }

    static int b(@NonNull Context context) {
        return a(context, context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    static int a(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", DispatchConstants.ANDROID);
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize && (Build.VERSION.SDK_INT < 29 || str.equals("status_bar_height"))) {
                    return dimensionPixelSize2;
                }
                float f2 = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f2 >= 0.0f ? f2 + 0.5f : f2 - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    int a() {
        return this.f16379c;
    }

    int c() {
        return this.a;
    }
}
