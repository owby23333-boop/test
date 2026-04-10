package com.amgcyo.cuttadon.utils.otherutils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/* JADX INFO: compiled from: MkAnimAll.java */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: compiled from: MkAnimAll.java */
    class a implements Animation.AnimationListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.a.setVisibility(0);
        }
    }

    public static void a(View view, int i2, int i3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(400L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setAnimationListener(new a(view));
        TranslateAnimation translateAnimation = i2 != 1 ? i2 != 2 ? i2 != 3 ? new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f) : new TranslateAnimation(0.0f, 0.0f, i3, 0.0f) : new TranslateAnimation(0.0f, 0.0f, -i3, 0.0f) : new TranslateAnimation(i3, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.5f));
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        view.startAnimation(animationSet);
    }
}
