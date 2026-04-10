package com.chad.library.adapter.base.c;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: compiled from: ScaleInAnimation.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements b {
    private final float a;

    public c() {
        this(0.5f);
    }

    @Override // com.chad.library.adapter.base.c.b
    public Animator[] a(View view) {
        return new ObjectAnimator[]{ObjectAnimator.ofFloat(view, "scaleX", this.a, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", this.a, 1.0f)};
    }

    public c(float f2) {
        this.a = f2;
    }
}
