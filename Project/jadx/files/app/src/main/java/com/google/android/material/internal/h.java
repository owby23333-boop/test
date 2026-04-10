package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class h {
    private final ArrayList<b> a = new ArrayList<>();

    @Nullable
    private b b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    ValueAnimator f15530c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f15531d = new a();

    /* JADX INFO: compiled from: StateListAnimator.java */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h hVar = h.this;
            if (hVar.f15530c == animator) {
                hVar.f15530c = null;
            }
        }
    }

    /* JADX INFO: compiled from: StateListAnimator.java */
    static class b {
        final int[] a;
        final ValueAnimator b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f15530c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f15530c = null;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f15531d);
        this.a.add(bVar);
    }

    public void a(int[] iArr) {
        b bVar;
        int size = this.a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bVar = null;
                break;
            }
            bVar = this.a.get(i2);
            if (StateSet.stateSetMatches(bVar.a, iArr)) {
                break;
            } else {
                i2++;
            }
        }
        b bVar2 = this.b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.b = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    private void a(@NonNull b bVar) {
        this.f15530c = bVar.b;
        this.f15530c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f15530c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f15530c = null;
        }
    }
}
