package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class k extends h<ObjectAnimator> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Property<k, Float> f15669j = new b(Float.class, "animationFraction");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f15670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FastOutSlowInInterpolator f15671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f15672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15674h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f15675i;

    /* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.f15673g = (kVar.f15673g + 1) % k.this.f15672f.f15632c.length;
            k.this.f15674h = true;
        }
    }

    /* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    static class b extends Property<k, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(k kVar) {
            return Float.valueOf(kVar.g());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, Float f2) {
            kVar.a(f2.floatValue());
        }
    }

    public k(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f15673g = 1;
        this.f15672f = linearProgressIndicatorSpec;
        this.f15671e = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float g() {
        return this.f15675i;
    }

    private void h() {
        if (this.f15670d == null) {
            this.f15670d = ObjectAnimator.ofFloat(this, f15669j, 0.0f, 1.0f);
            this.f15670d.setDuration(333L);
            this.f15670d.setInterpolator(null);
            this.f15670d.setRepeatCount(-1);
            this.f15670d.addListener(new a());
        }
    }

    private void i() {
        if (!this.f15674h || this.b[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.f15665c;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = com.google.android.material.c.a.a(this.f15672f.f15632c[this.f15673g], this.a.getAlpha());
        this.f15674h = false;
    }

    @Override // com.google.android.material.progressindicator.h
    public void a(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
    }

    @Override // com.google.android.material.progressindicator.h
    public void d() {
        h();
        f();
        this.f15670d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void e() {
    }

    @VisibleForTesting
    void f() {
        this.f15674h = true;
        this.f15673g = 1;
        Arrays.fill(this.f15665c, com.google.android.material.c.a.a(this.f15672f.f15632c[0], this.a.getAlpha()));
    }

    @Override // com.google.android.material.progressindicator.h
    public void b() {
        f();
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f15670d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void a(int i2) {
        this.b[0] = 0.0f;
        float fA = a(i2, 0, 667);
        float[] fArr = this.b;
        float interpolation = this.f15671e.getInterpolation(fA);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.b;
        float interpolation2 = this.f15671e.getInterpolation(fA + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.b[5] = 1.0f;
    }

    @VisibleForTesting
    void a(float f2) {
        this.f15675i = f2;
        a((int) (this.f15675i * 333.0f));
        i();
        this.a.invalidateSelf();
    }
}
