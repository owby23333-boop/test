package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.b;

/* JADX INFO: compiled from: CircularRevealCompat.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularRevealCompat.java */
    static class C0321a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ b f15222s;

        C0321a(b bVar) {
            this.f15222s = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f15222s.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f15222s.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator a(@NonNull b bVar, float f2, float f3, float f4) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(bVar, (Property<b, V>) b.c.a, (TypeEvaluator) b.C0322b.b, (Object[]) new b.e[]{new b.e(f2, f3, f4)});
        if (Build.VERSION.SDK_INT < 21) {
            return objectAnimatorOfObject;
        }
        b.e revealInfo = bVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) bVar, (int) f2, (int) f3, revealInfo.f15223c, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    @NonNull
    public static Animator.AnimatorListener a(@NonNull b bVar) {
        return new C0321a(bVar);
    }
}
