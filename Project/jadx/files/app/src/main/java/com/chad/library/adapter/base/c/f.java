package com.chad.library.adapter.base.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: compiled from: SlideInRightAnimation.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements b {
    @Override // com.chad.library.adapter.base.c.b
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationX", view.getRootView().getWidth(), 0.0f)};
    }
}
