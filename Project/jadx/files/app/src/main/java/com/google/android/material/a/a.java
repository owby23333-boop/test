package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f14914c = new FastOutLinearInInterpolator();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f14915d = new LinearOutSlowInInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f14916e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * (i3 - i2));
    }

    public static float a(float f2, float f3, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f4, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f5, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f6) {
        return f6 < f4 ? f2 : f6 > f5 ? f3 : a(f2, f3, (f6 - f4) / (f5 - f4));
    }
}
