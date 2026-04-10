package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int G = R$style.Widget_MaterialComponents_LinearProgressIndicator;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndeterminateAnimationType {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.linearProgressIndicatorStyle);
    }

    private void c() {
        setIndeterminateDrawable(i.a(getContext(), (LinearProgressIndicatorSpec) this.f15616s));
        setProgressDrawable(e.a(getContext(), (LinearProgressIndicatorSpec) this.f15616s));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f15616s).f15629g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f15616s).f15630h;
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        S s2 = this.f15616s;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s2;
        boolean z3 = true;
        if (((LinearProgressIndicatorSpec) s2).f15630h != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.f15616s).f15630h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || ((LinearProgressIndicatorSpec) this.f15616s).f15630h != 3))) {
            z3 = false;
        }
        linearProgressIndicatorSpec.f15631i = z3;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingLeft = i2 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i3 - (getPaddingTop() + getPaddingBottom());
        i<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i2) {
        if (((LinearProgressIndicatorSpec) this.f15616s).f15629g == i2) {
            return;
        }
        if (b() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s2 = this.f15616s;
        ((LinearProgressIndicatorSpec) s2).f15629g = i2;
        ((LinearProgressIndicatorSpec) s2).c();
        if (i2 == 0) {
            getIndeterminateDrawable().a(new k((LinearProgressIndicatorSpec) this.f15616s));
        } else {
            getIndeterminateDrawable().a(new l(getContext(), (LinearProgressIndicatorSpec) this.f15616s));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f15616s).c();
    }

    public void setIndicatorDirection(int i2) {
        S s2 = this.f15616s;
        ((LinearProgressIndicatorSpec) s2).f15630h = i2;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s2;
        boolean z2 = true;
        if (i2 != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.f15616s).f15630h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || i2 != 3))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.f15631i = z2;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i2) {
        super.setTrackCornerRadius(i2);
        ((LinearProgressIndicatorSpec) this.f15616s).c();
        invalidate();
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, G);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public LinearProgressIndicatorSpec a(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void a(int i2, boolean z2) {
        S s2 = this.f15616s;
        if (s2 != 0 && ((LinearProgressIndicatorSpec) s2).f15629g == 0 && isIndeterminate()) {
            return;
        }
        super.a(i2, z2);
    }
}
