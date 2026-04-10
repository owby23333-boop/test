package com.chad.library.adapter.base.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: compiled from: SlideInBottomAnimation.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements b {
    @Override // com.chad.library.adapter.base.c.b
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0.0f)};
    }
}
