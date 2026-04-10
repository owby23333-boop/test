package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.b> extends ProgressBar {
    static final int F = R$style.Widget_MaterialComponents_ProgressIndicator;
    private int A;
    private final Runnable B;
    private final Runnable C;
    private final Animatable2Compat.AnimationCallback D;
    private final Animatable2Compat.AnimationCallback E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    S f15616s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f15617t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15618u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f15619v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final int f15620w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f15621x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    com.google.android.material.progressindicator.a f15622y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f15623z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface HideAnimationBehavior {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShowAnimationBehavior {
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.d();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.c();
            BaseProgressIndicator.this.f15621x = -1L;
        }
    }

    class c extends Animatable2Compat.AnimationCallback {
        c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.a(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.a(baseProgressIndicator.f15617t, BaseProgressIndicator.this.f15618u);
        }
    }

    class d extends Animatable2Compat.AnimationCallback {
        d() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (BaseProgressIndicator.this.f15623z) {
                return;
            }
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setVisibility(baseProgressIndicator.A);
        }
    }

    protected BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, F), attributeSet, i2);
        this.f15623z = false;
        this.A = 4;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        this.E = new d();
        Context context2 = getContext();
        this.f15616s = (S) a(context2, attributeSet);
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context2, attributeSet, R$styleable.BaseProgressIndicator, i2, i3, new int[0]);
        typedArrayC.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f15620w = Math.min(typedArrayC.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        typedArrayC.recycle();
        this.f15622y = new com.google.android.material.progressindicator.a();
        this.f15619v = true;
    }

    private void g() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.E);
            getIndeterminateDrawable().e().e();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.E);
        }
    }

    @Nullable
    private g<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().e();
    }

    abstract S a(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f15616s.f15635f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f15616s.f15632c;
    }

    public int getShowAnimationBehavior() {
        return this.f15616s.f15634e;
    }

    @ColorInt
    public int getTrackColor() {
        return this.f15616s.f15633d;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.f15616s.b;
    }

    @Px
    public int getTrackThickness() {
        return this.f15616s.a;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
        if (b()) {
            d();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.C);
        removeCallbacks(this.B);
        ((f) getCurrentDrawable()).b();
        g();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@NonNull Canvas canvas) {
        int iSave = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        g<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate == null) {
            return;
        }
        int iB = currentDrawingDelegate.b();
        int iA = currentDrawingDelegate.a();
        setMeasuredDimension(iB < 0 ? getMeasuredWidth() : iB + getPaddingLeft() + getPaddingRight(), iA < 0 ? getMeasuredHeight() : iA + getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a(i2 == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull com.google.android.material.progressindicator.a aVar) {
        this.f15622y = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f15657u = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f15657u = aVar;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.f15616s.f15635f = i2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z2) {
        if (z2 == isIndeterminate()) {
            return;
        }
        if (b() && z2) {
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
        f fVar = (f) getCurrentDrawable();
        if (fVar != null) {
            fVar.b();
        }
        super.setIndeterminate(z2);
        f fVar2 = (f) getCurrentDrawable();
        if (fVar2 != null) {
            fVar2.a(b(), false, false);
        }
        this.f15623z = false;
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else {
            if (!(drawable instanceof i)) {
                throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
            }
            ((f) drawable).b();
            super.setIndeterminateDrawable(drawable);
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{com.google.android.material.c.a.a(getContext(), R$attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f15616s.f15632c = iArr;
        getIndeterminateDrawable().e().b();
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        if (isIndeterminate()) {
            return;
        }
        a(i2, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else {
            if (!(drawable instanceof e)) {
                throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
            }
            e eVar = (e) drawable;
            eVar.b();
            super.setProgressDrawable(eVar);
            eVar.b(getProgress() / getMax());
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.f15616s.f15634e = i2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i2) {
        S s2 = this.f15616s;
        if (s2.f15633d != i2) {
            s2.f15633d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i2) {
        S s2 = this.f15616s;
        if (s2.b != i2) {
            s2.b = Math.min(i2, s2.a / 2);
        }
    }

    public void setTrackThickness(@Px int i2) {
        S s2 = this.f15616s;
        if (s2.a != i2) {
            s2.a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 != 0 && i2 != 4 && i2 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.A = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ((f) getCurrentDrawable()).a(false, false, true);
        if (e()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f15620w > 0) {
            SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean e() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void f() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().e().a(this.D);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.E);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.E);
        }
    }

    boolean b() {
        return ViewCompat.isAttachedToWindow(this) && getWindowVisibility() == 0 && a();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public i<S> getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public e<S> getProgressDrawable() {
        return (e) super.getProgressDrawable();
    }

    protected void a(boolean z2) {
        if (this.f15619v) {
            ((f) getCurrentDrawable()).a(b(), false, z2);
        }
    }

    boolean a() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public void a(int i2, boolean z2) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f15617t = i2;
                this.f15618u = z2;
                this.f15623z = true;
                if (getIndeterminateDrawable().isVisible() && this.f15622y.a(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().e().c();
                    return;
                } else {
                    this.D.onAnimationEnd(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i2);
        if (getProgressDrawable() == null || z2) {
            return;
        }
        getProgressDrawable().jumpToCurrentState();
    }
}
