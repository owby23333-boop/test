package com.google.android.material.progressindicator;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: BaseProgressIndicatorSpec.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    @Px
    public int a;

    @Px
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public int[] f15632c = new int[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorInt
    public int f15633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f15635f;

    protected b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context, attributeSet, R$styleable.BaseProgressIndicator, i2, i3, new int[0]);
        this.a = com.google.android.material.i.c.a(context, typedArrayC, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.b = Math.min(com.google.android.material.i.c.a(context, typedArrayC, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.f15634e = typedArrayC.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f15635f = typedArrayC.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        a(context, typedArrayC);
        b(context, typedArrayC);
        typedArrayC.recycle();
    }

    private void a(@NonNull Context context, @NonNull TypedArray typedArray) {
        if (!typedArray.hasValue(R$styleable.BaseProgressIndicator_indicatorColor)) {
            this.f15632c = new int[]{com.google.android.material.c.a.a(context, R$attr.colorPrimary, -1)};
        } else {
            if (typedArray.peekValue(R$styleable.BaseProgressIndicator_indicatorColor).type != 1) {
                this.f15632c = new int[]{typedArray.getColor(R$styleable.BaseProgressIndicator_indicatorColor, -1)};
                return;
            }
            this.f15632c = context.getResources().getIntArray(typedArray.getResourceId(R$styleable.BaseProgressIndicator_indicatorColor, -1));
            if (this.f15632c.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void b(@NonNull Context context, @NonNull TypedArray typedArray) {
        if (typedArray.hasValue(R$styleable.BaseProgressIndicator_trackColor)) {
            this.f15633d = typedArray.getColor(R$styleable.BaseProgressIndicator_trackColor, -1);
            return;
        }
        this.f15633d = this.f15632c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f2 = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f15633d = com.google.android.material.c.a.a(this.f15633d, (int) (f2 * 255.0f));
    }

    abstract void c();

    public boolean b() {
        return this.f15634e != 0;
    }

    public boolean a() {
        return this.f15635f != 0;
    }
}
