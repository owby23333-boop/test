package com.bytedance.adsdk.lottie.model.g;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public class pf implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.z.z f177a;
    private final String dl;
    private final Path.FillType g;
    private final com.bytedance.adsdk.lottie.model.z.a gc;
    private final boolean m;
    private final boolean z;

    public pf(String str, boolean z, Path.FillType fillType, com.bytedance.adsdk.lottie.model.z.z zVar, com.bytedance.adsdk.lottie.model.z.a aVar, boolean z2) {
        this.dl = str;
        this.z = z;
        this.g = fillType;
        this.f177a = zVar;
        this.gc = aVar;
        this.m = z2;
    }

    public String z() {
        return this.dl;
    }

    public com.bytedance.adsdk.lottie.model.z.z g() {
        return this.f177a;
    }

    public com.bytedance.adsdk.lottie.model.z.a dl() {
        return this.gc;
    }

    public Path.FillType a() {
        return this.g;
    }

    public boolean gc() {
        return this.m;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.e(gzVar, dlVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.z + '}';
    }
}
