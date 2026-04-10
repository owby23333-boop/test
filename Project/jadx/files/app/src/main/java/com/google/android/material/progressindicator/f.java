package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class f extends Drawable implements Animatable2Compat {
    private static final Property<f, Float> G = new c(Float.class, "growFraction");
    private List<Animatable2Compat.AnimationCallback> A;
    private Animatable2Compat.AnimationCallback B;
    private boolean C;
    private float D;
    private int F;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final Context f15655s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final com.google.android.material.progressindicator.b f15656t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ValueAnimator f15658v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ValueAnimator f15659w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f15660x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f15661y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f15662z;
    final Paint E = new Paint();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    com.google.android.material.progressindicator.a f15657u = new com.google.android.material.progressindicator.a();

    /* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.f();
        }
    }

    /* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.super.setVisible(false, false);
            f.this.e();
        }
    }

    /* JADX INFO: compiled from: DrawableWithAnimatedVisibilityChange.java */
    static class c extends Property<f, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.a());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(f fVar, Float f2) {
            fVar.a(f2.floatValue());
        }
    }

    f(@NonNull Context context, @NonNull com.google.android.material.progressindicator.b bVar) {
        this.f15655s = context;
        this.f15656t = bVar;
        setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Animatable2Compat.AnimationCallback animationCallback = this.B;
        if (animationCallback != null) {
            animationCallback.onAnimationEnd(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.A;
        if (list == null || this.C) {
            return;
        }
        Iterator<Animatable2Compat.AnimationCallback> it = list.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Animatable2Compat.AnimationCallback animationCallback = this.B;
        if (animationCallback != null) {
            animationCallback.onAnimationStart(this);
        }
        List<Animatable2Compat.AnimationCallback> list = this.A;
        if (list == null || this.C) {
            return;
        }
        Iterator<Animatable2Compat.AnimationCallback> it = list.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this);
        }
    }

    private void g() {
        if (this.f15658v == null) {
            this.f15658v = ObjectAnimator.ofFloat(this, G, 0.0f, 1.0f);
            this.f15658v.setDuration(500L);
            this.f15658v.setInterpolator(com.google.android.material.a.a.b);
            b(this.f15658v);
        }
        if (this.f15659w == null) {
            this.f15659w = ObjectAnimator.ofFloat(this, G, 1.0f, 0.0f);
            this.f15659w.setDuration(500L);
            this.f15659w.setInterpolator(com.google.android.material.a.a.b);
            a(this.f15659w);
        }
    }

    public boolean c() {
        ValueAnimator valueAnimator = this.f15659w;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f15661y;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.A.clear();
        this.A = null;
    }

    public boolean d() {
        ValueAnimator valueAnimator = this.f15658v;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f15660x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return d() || c();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (this.A == null) {
            this.A = new ArrayList();
        }
        if (this.A.contains(animationCallback)) {
            return;
        }
        this.A.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.F = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.E.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return a(z2, z3, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        b(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        b(false, true, false);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.A;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.A.remove(animationCallback);
        if (!this.A.isEmpty()) {
            return true;
        }
        this.A = null;
        return true;
    }

    public boolean b() {
        return a(false, false, false);
    }

    public boolean a(boolean z2, boolean z3, boolean z4) {
        return b(z2, z3, z4 && this.f15657u.a(this.f15655s.getContentResolver()) > 0.0f);
    }

    boolean b(boolean z2, boolean z3, boolean z4) {
        g();
        if (!isVisible() && !z2) {
            return false;
        }
        ValueAnimator valueAnimator = z2 ? this.f15658v : this.f15659w;
        if (!z4) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                a(valueAnimator);
            }
            return super.setVisible(z2, false);
        }
        if (z4 && valueAnimator.isRunning()) {
            return false;
        }
        boolean z5 = !z2 || super.setVisible(z2, false);
        if (!(z2 ? this.f15656t.b() : this.f15656t.a())) {
            a(valueAnimator);
            return z5;
        }
        if (!z3 && Build.VERSION.SDK_INT >= 19 && valueAnimator.isPaused()) {
            valueAnimator.resume();
        } else {
            valueAnimator.start();
        }
        return z5;
    }

    private void a(@NonNull ValueAnimator... valueAnimatorArr) {
        boolean z2 = this.C;
        this.C = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.C = z2;
    }

    private void a(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f15659w;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f15659w = valueAnimator;
        valueAnimator.addListener(new b());
    }

    float a() {
        if (!this.f15656t.b() && !this.f15656t.a()) {
            return 1.0f;
        }
        if (!this.f15661y && !this.f15660x) {
            return this.D;
        }
        return this.f15662z;
    }

    private void b(@NonNull ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f15658v;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f15658v = valueAnimator;
        valueAnimator.addListener(new a());
    }

    void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        if (this.D != f2) {
            this.D = f2;
            invalidateSelf();
        }
    }
}
