package com.amgcyo.cuttadon.view.showcaseview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.amgcyo.cuttadon.view.showcaseview.c;

/* JADX INFO: compiled from: FadeAnimationFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: compiled from: FadeAnimationFactory.java */
    class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ c.b f5482s;

        a(b bVar, c.b bVar2) {
            this.f5482s = bVar2;
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
            this.f5482s.c();
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.view.showcaseview.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FadeAnimationFactory.java */
    class C0119b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ c.a f5483s;

        C0119b(b bVar, c.a aVar) {
            this.f5483s = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5483s.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public b() {
        new AccelerateDecelerateInterpolator();
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.c
    public void a(View view, Point point, long j2, c.b bVar) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(j2).addListener(new a(this, bVar));
        objectAnimatorOfFloat.start();
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.c
    public void a(View view, Point point, long j2, c.a aVar) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        objectAnimatorOfFloat.setDuration(j2).addListener(new C0119b(this, aVar));
        objectAnimatorOfFloat.start();
    }
}
