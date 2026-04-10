package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AnimatorTracker.java */
/* JADX INFO: loaded from: classes2.dex */
class a {

    @Nullable
    private Animator a;

    a() {
    }

    public void a(Animator animator) {
        a();
        this.a = animator;
    }

    public void b() {
        this.a = null;
    }

    public void a() {
        Animator animator = this.a;
        if (animator != null) {
            animator.cancel();
        }
    }
}
