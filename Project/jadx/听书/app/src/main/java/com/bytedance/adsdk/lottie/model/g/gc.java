package com.bytedance.adsdk.lottie.model.g;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.z.a f170a;
    private final com.bytedance.adsdk.lottie.model.z.dl dl;
    private final String e;
    private final com.bytedance.adsdk.lottie.model.z.g fo;
    private final Path.FillType g;
    private final com.bytedance.adsdk.lottie.model.z.m gc;
    private final com.bytedance.adsdk.lottie.model.z.g gz;
    private final com.bytedance.adsdk.lottie.model.z.m m;
    private final boolean uy;
    private final e z;

    public gc(String str, e eVar, Path.FillType fillType, com.bytedance.adsdk.lottie.model.z.dl dlVar, com.bytedance.adsdk.lottie.model.z.a aVar, com.bytedance.adsdk.lottie.model.z.m mVar, com.bytedance.adsdk.lottie.model.z.m mVar2, com.bytedance.adsdk.lottie.model.z.g gVar, com.bytedance.adsdk.lottie.model.z.g gVar2, boolean z) {
        this.z = eVar;
        this.g = fillType;
        this.dl = dlVar;
        this.f170a = aVar;
        this.gc = mVar;
        this.m = mVar2;
        this.e = str;
        this.gz = gVar;
        this.fo = gVar2;
        this.uy = z;
    }

    public String z() {
        return this.e;
    }

    public e g() {
        return this.z;
    }

    public Path.FillType dl() {
        return this.g;
    }

    public com.bytedance.adsdk.lottie.model.z.dl a() {
        return this.dl;
    }

    public com.bytedance.adsdk.lottie.model.z.a gc() {
        return this.f170a;
    }

    public com.bytedance.adsdk.lottie.model.z.m m() {
        return this.gc;
    }

    public com.bytedance.adsdk.lottie.model.z.m e() {
        return this.m;
    }

    public boolean gz() {
        return this.uy;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.gz(gzVar, mVar, dlVar, this);
    }
}
