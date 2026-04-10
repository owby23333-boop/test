package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final PointF dl;
    private final PointF g;
    private final PointF z;

    public z() {
        this.z = new PointF();
        this.g = new PointF();
        this.dl = new PointF();
    }

    public z(PointF pointF, PointF pointF2, PointF pointF3) {
        this.z = pointF;
        this.g = pointF2;
        this.dl = pointF3;
    }

    public void z(float f, float f2) {
        this.z.set(f, f2);
    }

    public PointF z() {
        return this.z;
    }

    public void g(float f, float f2) {
        this.g.set(f, f2);
    }

    public PointF g() {
        return this.g;
    }

    public void dl(float f, float f2) {
        this.dl.set(f, f2);
    }

    public PointF dl() {
        return this.dl;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.dl.x), Float.valueOf(this.dl.y), Float.valueOf(this.z.x), Float.valueOf(this.z.y), Float.valueOf(this.g.x), Float.valueOf(this.g.y));
    }
}
