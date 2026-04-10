package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: MkAnimationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class u {
    public static Animation a(int i2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i2));
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    public static Animation a(Context context) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R.anim.change);
        animationLoadAnimation.setInterpolator(new LinearInterpolator());
        return animationLoadAnimation;
    }
}
