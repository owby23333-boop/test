package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: IndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class h<T extends Animator> {
    protected i a;
    protected final float[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int[] f15665c;

    protected h(int i2) {
        this.b = new float[i2 * 2];
        this.f15665c = new int[i2];
    }

    protected float a(int i2, int i3, int i4) {
        return (i2 - i3) / i4;
    }

    abstract void a();

    public abstract void a(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    protected void a(@NonNull i iVar) {
        this.a = iVar;
    }

    public abstract void b();

    abstract void c();

    abstract void d();

    public abstract void e();
}
