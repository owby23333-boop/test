package com.bytedance.adsdk.lottie.model.g;

/* JADX INFO: loaded from: classes2.dex */
public class i implements dl {
    private final com.bytedance.adsdk.lottie.model.z.i<Float, Float> g;
    private final String z;

    public i(String str, com.bytedance.adsdk.lottie.model.z.i<Float, Float> iVar) {
        this.z = str;
        this.g = iVar;
    }

    public String z() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.z.i<Float, Float> g() {
        return this.g;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.p(gzVar, dlVar, this);
    }
}
