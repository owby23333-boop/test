package com.amgcyo.cuttadon.view.showcaseview;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.amgcyo.cuttadon.view.showcaseview.c;

/* JADX INFO: compiled from: CircularRevealAnimationFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.view.showcaseview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularRevealAnimationFactory.java */
    class C0118a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ c.b f5480s;

        C0118a(a aVar, c.b bVar) {
            this.f5480s = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f5480s.c();
        }
    }

    /* JADX INFO: compiled from: CircularRevealAnimationFactory.java */
    class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ c.a f5481s;

        b(a aVar, c.a aVar2) {
            this.f5481s = aVar2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5481s.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public a() {
        new AccelerateDecelerateInterpolator();
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.c
    @TargetApi(21)
    public void a(View view, Point point, long j2, c.b bVar) {
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, point.x, point.y, 0.0f, view.getWidth() > view.getHeight() ? view.getWidth() : view.getHeight());
        animatorCreateCircularReveal.setDuration(j2).addListener(new C0118a(this, bVar));
        animatorCreateCircularReveal.start();
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.c
    @TargetApi(21)
    public void a(View view, Point point, long j2, c.a aVar) {
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, point.x, point.y, view.getWidth() > view.getHeight() ? view.getWidth() : view.getHeight(), 0.0f);
        animatorCreateCircularReveal.setDuration(j2).addListener(new b(this, aVar));
        animatorCreateCircularReveal.start();
    }
}
