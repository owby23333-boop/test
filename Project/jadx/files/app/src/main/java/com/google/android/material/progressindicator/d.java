package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends h<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f15640l = {0, 1350, 2700, 4050};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f15641m = {667, 2017, 3367, 4717};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f15642n = {1000, 2350, 3700, 5050};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Property<d, Float> f15643o = new c(Float.class, "animationFraction");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Property<d, Float> f15644p = new C0330d(Float.class, "completeEndFraction");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f15645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ObjectAnimator f15646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FastOutSlowInInterpolator f15647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f15648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f15650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f15651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f15652k;

    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f15649h = (dVar.f15649h + 4) % d.this.f15648g.f15632c.length;
        }
    }

    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            dVar.f15652k.onAnimationEnd(dVar.a);
        }
    }

    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    static class c extends Property<d, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.g());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f2) {
            dVar.a(f2.floatValue());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
    static class C0330d extends Property<d, Float> {
        C0330d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.h());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f2) {
            dVar.b(f2.floatValue());
        }
    }

    public d(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f15649h = 0;
        this.f15652k = null;
        this.f15648g = circularProgressIndicatorSpec;
        this.f15647f = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float g() {
        return this.f15650i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h() {
        return this.f15651j;
    }

    private void i() {
        if (this.f15645d == null) {
            this.f15645d = ObjectAnimator.ofFloat(this, f15643o, 0.0f, 1.0f);
            this.f15645d.setDuration(5400L);
            this.f15645d.setInterpolator(null);
            this.f15645d.setRepeatCount(-1);
            this.f15645d.addListener(new a());
        }
        if (this.f15646e == null) {
            this.f15646e = ObjectAnimator.ofFloat(this, f15644p, 0.0f, 1.0f);
            this.f15646e.setDuration(333L);
            this.f15646e.setInterpolator(this.f15647f);
            this.f15646e.addListener(new b());
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void e() {
        this.f15652k = null;
    }

    @VisibleForTesting
    void f() {
        this.f15649h = 0;
        this.f15665c[0] = com.google.android.material.c.a.a(this.f15648g.f15632c[0], this.a.getAlpha());
        this.f15651j = 0.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    public void b() {
        f();
    }

    @Override // com.google.android.material.progressindicator.h
    void c() {
        if (this.f15646e.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.f15646e.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    void d() {
        i();
        f();
        this.f15645d.start();
    }

    private void b(int i2) {
        float[] fArr = this.b;
        float f2 = this.f15650i;
        fArr[0] = (f2 * 1520.0f) - 20.0f;
        fArr[1] = f2 * 1520.0f;
        for (int i3 = 0; i3 < 4; i3++) {
            float fA = a(i2, f15640l[i3], 667);
            float[] fArr2 = this.b;
            fArr2[1] = fArr2[1] + (this.f15647f.getInterpolation(fA) * 250.0f);
            float fA2 = a(i2, f15641m[i3], 667);
            float[] fArr3 = this.b;
            fArr3[0] = fArr3[0] + (this.f15647f.getInterpolation(fA2) * 250.0f);
        }
        float[] fArr4 = this.b;
        fArr4[0] = fArr4[0] + ((fArr4[1] - fArr4[0]) * this.f15651j);
        fArr4[0] = fArr4[0] / 360.0f;
        fArr4[1] = fArr4[1] / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    void a() {
        ObjectAnimator objectAnimator = this.f15645d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void a(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f15652k = animationCallback;
    }

    private void a(int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            float fA = a(i2, f15642n[i3], 333);
            if (fA >= 0.0f && fA <= 1.0f) {
                int i4 = i3 + this.f15649h;
                int[] iArr = this.f15648g.f15632c;
                int length = i4 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int iA = com.google.android.material.c.a.a(iArr[length], this.a.getAlpha());
                int iA2 = com.google.android.material.c.a.a(this.f15648g.f15632c[length2], this.a.getAlpha());
                this.f15665c[0] = com.google.android.material.a.c.a().evaluate(this.f15647f.getInterpolation(fA), Integer.valueOf(iA), Integer.valueOf(iA2)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2) {
        this.f15651j = f2;
    }

    @VisibleForTesting
    void a(float f2) {
        this.f15650i = f2;
        int i2 = (int) (this.f15650i * 5400.0f);
        b(i2);
        a(i2);
        this.a.invalidateSelf();
    }
}
