package com.chad.library.adapter.base.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: compiled from: AlphaInAnimation.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    private final float a;

    public a() {
        this(0.0f);
    }

    @Override // com.chad.library.adapter.base.c.b
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", this.a, 1.0f)};
    }

    public a(float f2) {
        this.a = f2;
    }
}
