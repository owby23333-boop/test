package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Px
    public int f15626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Px
    public int f15627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15628i;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.b
    void c() {
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, CircularProgressIndicator.G);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context, attributeSet, R$styleable.CircularProgressIndicator, i2, i3, new int[0]);
        this.f15626g = Math.max(com.google.android.material.i.c.a(context, typedArrayC, R$styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.a * 2);
        this.f15627h = com.google.android.material.i.c.a(context, typedArrayC, R$styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f15628i = typedArrayC.getInt(R$styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayC.recycle();
        c();
    }
}
