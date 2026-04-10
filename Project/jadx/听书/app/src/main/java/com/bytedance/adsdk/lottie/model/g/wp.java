package com.bytedance.adsdk.lottie.model.g;

/* JADX INFO: loaded from: classes2.dex */
public class wp implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.z.wp f180a;
    private final com.bytedance.adsdk.lottie.model.z.g dl;
    private final com.bytedance.adsdk.lottie.model.z.g g;
    private final boolean gc;
    private final String z;

    public wp(String str, com.bytedance.adsdk.lottie.model.z.g gVar, com.bytedance.adsdk.lottie.model.z.g gVar2, com.bytedance.adsdk.lottie.model.z.wp wpVar, boolean z) {
        this.z = str;
        this.g = gVar;
        this.dl = gVar2;
        this.f180a = wpVar;
        this.gc = z;
    }

    public String z() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.z.g g() {
        return this.g;
    }

    public com.bytedance.adsdk.lottie.model.z.g dl() {
        return this.dl;
    }

    public com.bytedance.adsdk.lottie.model.z.wp a() {
        return this.f180a;
    }

    public boolean gc() {
        return this.gc;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.ls(gzVar, dlVar, this);
    }
}
