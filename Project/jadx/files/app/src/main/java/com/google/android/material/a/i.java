package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MotionTiming.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private long a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private TimeInterpolator f14918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14920e;

    public i(long j2, long j3) {
        this.a = 0L;
        this.b = 300L;
        this.f14918c = null;
        this.f14919d = 0;
        this.f14920e = 1;
        this.a = j2;
        this.b = j3;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long b() {
        return this.b;
    }

    @Nullable
    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f14918c;
        return timeInterpolator != null ? timeInterpolator : a.b;
    }

    public int d() {
        return this.f14919d;
    }

    public int e() {
        return this.f14920e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    @NonNull
    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }

    private static TimeInterpolator b(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.b : interpolator instanceof AccelerateInterpolator ? a.f14914c : interpolator instanceof DecelerateInterpolator ? a.f14915d : interpolator;
    }

    public long a() {
        return this.a;
    }

    @NonNull
    static i a(@NonNull ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f14919d = valueAnimator.getRepeatCount();
        iVar.f14920e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public i(long j2, long j3, @NonNull TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.b = 300L;
        this.f14918c = null;
        this.f14919d = 0;
        this.f14920e = 1;
        this.a = j2;
        this.b = j3;
        this.f14918c = timeInterpolator;
    }
}
