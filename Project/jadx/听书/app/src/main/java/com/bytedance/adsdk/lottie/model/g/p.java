package com.bytedance.adsdk.lottie.model.g;

/* JADX INFO: loaded from: classes2.dex */
public class p implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f176a;
    private final com.bytedance.adsdk.lottie.model.z.gz dl;
    private final int g;
    private final String z;

    public p(String str, int i, com.bytedance.adsdk.lottie.model.z.gz gzVar, boolean z) {
        this.z = str;
        this.g = i;
        this.dl = gzVar;
        this.f176a = z;
    }

    public String z() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.z.gz g() {
        return this.dl;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.fv(gzVar, dlVar, this);
    }

    public boolean dl() {
        return this.f176a;
    }

    public String toString() {
        return "ShapePath{name=" + this.z + ", index=" + this.g + '}';
    }
}
