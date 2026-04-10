package com.google.android.material.c;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.i.b;

/* JADX INFO: compiled from: MaterialColors.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    @ColorInt
    public static int a(@NonNull View view, @AttrRes int i2) {
        return b.a(view, i2);
    }

    @ColorInt
    public static int b(@ColorInt int i2, @ColorInt int i3) {
        return ColorUtils.compositeColors(i3, i2);
    }

    @ColorInt
    public static int a(Context context, @AttrRes int i2, String str) {
        return b.a(context, i2, str);
    }

    @ColorInt
    public static int a(@NonNull View view, @AttrRes int i2, @ColorInt int i3) {
        return a(view.getContext(), i2, i3);
    }

    @ColorInt
    public static int a(@NonNull Context context, @AttrRes int i2, @ColorInt int i3) {
        TypedValue typedValueA = b.a(context, i2);
        return typedValueA != null ? typedValueA.data : i3;
    }

    @ColorInt
    public static int a(@NonNull View view, @AttrRes int i2, @AttrRes int i3, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        return a(a(view, i2), a(view, i3), f2);
    }

    @ColorInt
    public static int a(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        return b(i2, ColorUtils.setAlphaComponent(i3, Math.round(Color.alpha(i3) * f2)));
    }

    @ColorInt
    public static int a(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        return ColorUtils.setAlphaComponent(i2, (Color.alpha(i2) * i3) / 255);
    }

    public static boolean a(@ColorInt int i2) {
        return i2 != 0 && ColorUtils.calculateLuminance(i2) > 0.5d;
    }
}
