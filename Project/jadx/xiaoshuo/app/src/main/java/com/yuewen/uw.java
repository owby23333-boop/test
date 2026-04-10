package com.yuewen;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes3.dex */
public class uw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f18820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f18821b;
    public final PointF c;
    public final float d;
    public final float e;
    public r93 f;
    public r93 g;

    public uw(PointF pointF, PointF pointF2, float f, float f2, float f3) {
        this.f18820a = f;
        this.f18821b = pointF;
        this.c = pointF2;
        this.d = f2;
        this.e = f3;
    }

    public r93 a() {
        return this.g;
    }

    public float b() {
        return this.e;
    }

    public PointF c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    public float e() {
        return this.f18820a;
    }

    public PointF f() {
        return this.f18821b;
    }

    public r93 g() {
        return this.f;
    }

    public void h(r93 r93Var) {
        this.g = r93Var;
    }

    public void i(r93 r93Var) {
        this.f = r93Var;
    }
}
