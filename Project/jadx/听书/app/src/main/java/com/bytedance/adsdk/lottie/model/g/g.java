package com.bytedance.adsdk.lottie.model.g;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class g implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f169a;
    private final com.bytedance.adsdk.lottie.model.z.m dl;
    private final com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> g;
    private final boolean gc;
    private final String z;

    public g(String str, com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> iVar, com.bytedance.adsdk.lottie.model.z.m mVar, boolean z, boolean z2) {
        this.z = str;
        this.g = iVar;
        this.dl = mVar;
        this.f169a = z;
        this.gc = z2;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.m(gzVar, dlVar, this);
    }

    public String z() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.z.i<PointF, PointF> g() {
        return this.g;
    }

    public com.bytedance.adsdk.lottie.model.z.m dl() {
        return this.dl;
    }

    public boolean a() {
        return this.f169a;
    }

    public boolean gc() {
        return this.gc;
    }
}
