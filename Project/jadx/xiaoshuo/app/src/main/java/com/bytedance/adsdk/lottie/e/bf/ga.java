package com.bytedance.adsdk.lottie.e.bf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ga extends p<com.bytedance.adsdk.lottie.d.bf.tg> {
    private final com.bytedance.adsdk.lottie.d.bf.tg tg;

    public ga(List<com.bytedance.adsdk.lottie.p.e<com.bytedance.adsdk.lottie.d.bf.tg>> list) {
        super(list);
        com.bytedance.adsdk.lottie.d.bf.tg tgVar = list.get(0).e;
        int iD = tgVar != null ? tgVar.d() : 0;
        this.tg = new com.bytedance.adsdk.lottie.d.bf.tg(new float[iD], new int[iD]);
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.d.bf.tg e(com.bytedance.adsdk.lottie.p.e<com.bytedance.adsdk.lottie.d.bf.tg> eVar, float f) {
        this.tg.e(eVar.e, eVar.bf, f);
        return this.tg;
    }
}
