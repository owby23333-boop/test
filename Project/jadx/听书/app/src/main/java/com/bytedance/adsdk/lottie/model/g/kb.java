package com.bytedance.adsdk.lottie.model.g;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.z.g f174a;
    private final com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> dl;
    private final com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> g;
    private final boolean gc;
    private final String z;

    public kb(String str, com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVar, com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVar2, com.bytedance.adsdk.lottie.model.z.g gVar, boolean z) {
        this.z = str;
        this.g = iVar;
        this.dl = iVar2;
        this.f174a = gVar;
        this.gc = z;
    }

    public String z() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.z.g g() {
        return this.f174a;
    }

    public com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> dl() {
        return this.dl;
    }

    public com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> a() {
        return this.g;
    }

    public boolean gc() {
        return this.gc;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.pf(gzVar, dlVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.g + ", size=" + this.dl + '}';
    }
}
