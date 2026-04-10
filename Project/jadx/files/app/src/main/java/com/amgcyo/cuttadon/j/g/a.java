package com.amgcyo.cuttadon.j.g;

import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/* JADX INFO: compiled from: ArtAnimationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Animation a(int i2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i2));
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    public static Animation b(int i2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i2));
        translateAnimation.setDuration(1000L);
        translateAnimation.setRepeatMode(1);
        translateAnimation.setRepeatCount(2);
        translateAnimation.startNow();
        return translateAnimation;
    }

    public static Animation a(int i2, long j2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i2));
        translateAnimation.setDuration(j2);
        return translateAnimation;
    }
}
