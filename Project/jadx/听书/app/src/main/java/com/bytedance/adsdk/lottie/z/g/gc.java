package com.bytedance.adsdk.lottie.z.g;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends e<com.bytedance.adsdk.lottie.model.g.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.g.a f195a;

    public gc(List<com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.a>> list) {
        super(list);
        com.bytedance.adsdk.lottie.model.g.a aVar = list.get(0).z;
        int iDl = aVar != null ? aVar.dl() : 0;
        this.f195a = new com.bytedance.adsdk.lottie.model.g.a(new float[iDl], new int[iDl]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.g.a z(com.bytedance.adsdk.lottie.m.z<com.bytedance.adsdk.lottie.model.g.a> zVar, float f) {
        this.f195a.z(zVar.z, zVar.g, f);
        return this.f195a;
    }
}
