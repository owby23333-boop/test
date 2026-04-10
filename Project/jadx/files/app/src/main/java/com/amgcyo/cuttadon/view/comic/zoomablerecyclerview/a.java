package com.amgcyo.cuttadon.view.comic.zoomablerecyclerview;

import android.graphics.Matrix;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.amgcyo.cuttadon.view.comic.j;
import com.amgcyo.cuttadon.view.comic.m.d;

/* JADX INFO: compiled from: AnimatedScaleRunnable.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final View f4578s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Matrix f4579t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final float f4580u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final float f4581v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f4583x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f4584y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final d f4585z;
    private final Interpolator A = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f4582w = System.currentTimeMillis();

    a(float f2, float f3, float f4, View view, Matrix matrix, d dVar) {
        this.f4580u = f3;
        this.f4581v = f4;
        this.f4583x = j.a(matrix);
        this.f4584y = f2;
        this.f4578s = view;
        this.f4579t = matrix;
        this.f4585z = dVar;
    }

    private float a() {
        return this.A.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f4582w) * 1.0f) / 200.0f));
    }

    @Override // java.lang.Runnable
    public void run() {
        float fA = a();
        float f2 = this.f4583x;
        this.f4585z.a((f2 + ((this.f4584y - f2) * fA)) / j.a(this.f4579t), this.f4580u, this.f4581v);
        if (fA < 1.0f) {
            j.a(this.f4578s, this);
        }
    }
}
