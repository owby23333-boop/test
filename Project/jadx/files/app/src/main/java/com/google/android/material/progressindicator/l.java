package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R$animator;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class l extends h<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f15677l = {533, 567, 850, 750};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f15678m = {1267, 1000, 333, 0};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Property<l, Float> f15679n = new b(Float.class, "animationFraction");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f15680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Interpolator[] f15681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.b f15682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f15685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f15686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f15687k;

    /* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (l.this.f15686j) {
                l.this.f15680d.setRepeatCount(-1);
                l lVar = l.this;
                lVar.f15687k.onAnimationEnd(lVar.a);
                l.this.f15686j = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f15683g = (lVar.f15683g + 1) % l.this.f15682f.f15632c.length;
            l.this.f15684h = true;
        }
    }

    /* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
    static class b extends Property<l, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.g());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f2) {
            lVar.a(f2.floatValue());
        }
    }

    public l(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f15683g = 0;
        this.f15687k = null;
        this.f15682f = linearProgressIndicatorSpec;
        this.f15681e = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R$animator.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float g() {
        return this.f15685i;
    }

    private void h() {
        if (this.f15680d == null) {
            this.f15680d = ObjectAnimator.ofFloat(this, f15679n, 0.0f, 1.0f);
            this.f15680d.setDuration(com.anythink.expressad.d.a.b.aC);
            this.f15680d.setInterpolator(null);
            this.f15680d.setRepeatCount(-1);
            this.f15680d.addListener(new a());
        }
    }

    private void i() {
        if (this.f15684h) {
            Arrays.fill(this.f15665c, com.google.android.material.c.a.a(this.f15682f.f15632c[this.f15683g], this.a.getAlpha()));
            this.f15684h = false;
        }
    }

    @VisibleForTesting
    void f() {
        this.f15683g = 0;
        int iA = com.google.android.material.c.a.a(this.f15682f.f15632c[0], this.a.getAlpha());
        int[] iArr = this.f15665c;
        iArr[0] = iA;
        iArr[1] = iA;
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        if (!this.a.isVisible()) {
            a();
        } else {
            this.f15686j = true;
            this.f15680d.setRepeatCount(0);
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void d() {
        h();
        f();
        this.f15680d.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void e() {
        this.f15687k = null;
    }

    @Override // com.google.android.material.progressindicator.h
    public void b() {
        f();
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.f15680d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void a(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f15687k = animationCallback;
    }

    private void a(int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.b[i3] = Math.max(0.0f, Math.min(1.0f, this.f15681e[i3].getInterpolation(a(i2, f15678m[i3], f15677l[i3]))));
        }
    }

    @VisibleForTesting
    void a(float f2) {
        this.f15685i = f2;
        a((int) (this.f15685i * 1800.0f));
        i();
        this.a.invalidateSelf();
    }
}
