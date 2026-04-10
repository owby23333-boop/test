package com.amgcyo.cuttadon.view.xtablayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import com.amgcyo.cuttadon.view.xtablayout.d;

/* JADX INFO: compiled from: ValueAnimatorCompatImplHoneycombMr1.java */
/* JADX INFO: loaded from: classes.dex */
class f extends d.g {
    final ValueAnimator a = new ValueAnimator();

    /* JADX INFO: compiled from: ValueAnimatorCompatImplHoneycombMr1.java */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ d.g.b f5644s;

        a(f fVar, d.g.b bVar) {
            this.f5644s = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f5644s.a();
        }
    }

    /* JADX INFO: compiled from: ValueAnimatorCompatImplHoneycombMr1.java */
    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ d.g.a f5645s;

        b(f fVar, d.g.a aVar) {
            this.f5645s = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5645s.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5645s.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f5645s.c();
        }
    }

    f() {
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(Interpolator interpolator) {
        this.a.setInterpolator(interpolator);
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public float b() {
        return this.a.getAnimatedFraction();
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public int c() {
        return ((Integer) this.a.getAnimatedValue()).intValue();
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public long d() {
        return this.a.getDuration();
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public boolean e() {
        return this.a.isRunning();
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void f() {
        this.a.start();
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(d.g.b bVar) {
        this.a.addUpdateListener(new a(this, bVar));
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(d.g.a aVar) {
        this.a.addListener(new b(this, aVar));
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(int i2, int i3) {
        this.a.setIntValues(i2, i3);
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(float f2, float f3) {
        this.a.setFloatValues(f2, f3);
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(int i2) {
        this.a.setDuration(i2);
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a() {
        this.a.cancel();
    }
}
