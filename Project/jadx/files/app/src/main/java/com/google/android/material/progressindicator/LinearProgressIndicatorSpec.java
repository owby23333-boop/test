package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
public final class LinearProgressIndicatorSpec extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15630h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f15631i;

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.b
    void c() {
        if (this.f15629g == 0) {
            if (this.b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f15632c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, LinearProgressIndicator.G);
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context, attributeSet, R$styleable.LinearProgressIndicator, R$attr.linearProgressIndicatorStyle, LinearProgressIndicator.G, new int[0]);
        this.f15629g = typedArrayC.getInt(R$styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f15630h = typedArrayC.getInt(R$styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        typedArrayC.recycle();
        c();
        this.f15631i = this.f15630h == 1;
    }
}
