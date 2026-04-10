package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int G = R$style.Widget_MaterialComponents_CircularProgressIndicator;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.circularProgressIndicatorStyle);
    }

    private void c() {
        setIndeterminateDrawable(i.a(getContext(), (CircularProgressIndicatorSpec) this.f15616s));
        setProgressDrawable(e.a(getContext(), (CircularProgressIndicatorSpec) this.f15616s));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f15616s).f15628i;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f15616s).f15627h;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f15616s).f15626g;
    }

    public void setIndicatorDirection(int i2) {
        ((CircularProgressIndicatorSpec) this.f15616s).f15628i = i2;
        invalidate();
    }

    public void setIndicatorInset(@Px int i2) {
        S s2 = this.f15616s;
        if (((CircularProgressIndicatorSpec) s2).f15627h != i2) {
            ((CircularProgressIndicatorSpec) s2).f15627h = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i2) {
        int iMax = Math.max(i2, getTrackThickness() * 2);
        S s2 = this.f15616s;
        if (((CircularProgressIndicatorSpec) s2).f15626g != iMax) {
            ((CircularProgressIndicatorSpec) s2).f15626g = iMax;
            ((CircularProgressIndicatorSpec) s2).c();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((CircularProgressIndicatorSpec) this.f15616s).c();
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, G);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public CircularProgressIndicatorSpec a(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }
}
