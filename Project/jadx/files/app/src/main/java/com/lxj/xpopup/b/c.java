package com.lxj.xpopup.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.lxj.xpopup.enums.PopupAnimation;

/* JADX INFO: compiled from: PopupAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    protected boolean a;
    public View b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PopupAnimation f17325d;

    /* JADX INFO: compiled from: PopupAnimator.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            c.this.a = true;
        }
    }

    /* JADX INFO: compiled from: PopupAnimator.java */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            c.this.a = true;
        }
    }

    public c(View view, int i2) {
        this(view, i2, null);
    }

    protected ValueAnimator a(ValueAnimator valueAnimator) {
        valueAnimator.addListener(new a());
        return valueAnimator;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public c(View view, int i2, PopupAnimation popupAnimation) {
        this.a = false;
        this.f17324c = 0;
        this.b = view;
        this.f17324c = i2;
        this.f17325d = popupAnimation;
    }

    protected ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator) {
        viewPropertyAnimator.setListener(new b());
        return viewPropertyAnimator;
    }
}
