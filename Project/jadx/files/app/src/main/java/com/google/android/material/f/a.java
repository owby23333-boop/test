package com.google.android.material.f;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R$attr;
import com.google.android.material.i.b;

/* JADX INFO: compiled from: ElevationOverlayProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final boolean a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f15339d;

    public a(@NonNull Context context) {
        this.a = b.a(context, R$attr.elevationOverlayEnabled, false);
        this.b = com.google.android.material.c.a.a(context, R$attr.elevationOverlayColor, 0);
        this.f15338c = com.google.android.material.c.a.a(context, R$attr.colorSurface, 0);
        this.f15339d = context.getResources().getDisplayMetrics().density;
    }

    @ColorInt
    public int a(@ColorInt int i2, float f2) {
        float fA = a(f2);
        return ColorUtils.setAlphaComponent(com.google.android.material.c.a.a(ColorUtils.setAlphaComponent(i2, 255), this.b, fA), Color.alpha(i2));
    }

    @ColorInt
    public int b(float f2) {
        return b(this.f15338c, f2);
    }

    @ColorInt
    public int b(@ColorInt int i2, float f2) {
        return (this.a && a(i2)) ? a(i2, f2) : i2;
    }

    public float a(float f2) {
        if (this.f15339d <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public boolean a() {
        return this.a;
    }

    private boolean a(@ColorInt int i2) {
        return ColorUtils.setAlphaComponent(i2, 255) == this.f15338c;
    }
}
