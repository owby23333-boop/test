package com.lxj.xpopup.b;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: ShadowBgAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArgbEvaluator f17341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17344h;

    /* JADX INFO: compiled from: ShadowBgAnimator.java */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.b.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: compiled from: ShadowBgAnimator.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.b.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public f(View view, int i2, int i3) {
        super(view, i2);
        this.f17341e = new ArgbEvaluator();
        this.f17342f = 0;
        this.f17343g = false;
        this.f17344h = i3;
    }

    @Override // com.lxj.xpopup.b.c
    public void a() {
        if (this.a) {
            return;
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f17341e, Integer.valueOf(this.f17344h), Integer.valueOf(this.f17342f));
        valueAnimatorOfObject.addUpdateListener(new b());
        a(valueAnimatorOfObject);
        valueAnimatorOfObject.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfObject.setDuration(this.f17343g ? 0L : this.f17324c).start();
    }

    @Override // com.lxj.xpopup.b.c
    public void b() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f17341e, Integer.valueOf(this.f17342f), Integer.valueOf(this.f17344h));
        valueAnimatorOfObject.addUpdateListener(new a());
        valueAnimatorOfObject.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfObject.setDuration(this.f17343g ? 0L : this.f17324c).start();
    }

    @Override // com.lxj.xpopup.b.c
    public void c() {
        this.b.setBackgroundColor(this.f17342f);
    }

    public int b(float f2) {
        return ((Integer) this.f17341e.evaluate(f2, Integer.valueOf(this.f17342f), Integer.valueOf(this.f17344h))).intValue();
    }

    public void a(float f2) {
        this.b.setBackgroundColor(Integer.valueOf(b(f2)).intValue());
    }
}
