package com.bytedance.adsdk.lottie.model.z;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements i<PointF, PointF> {
    private final List<com.bytedance.adsdk.lottie.m.z<PointF>> z;

    public gc(List<com.bytedance.adsdk.lottie.m.z<PointF>> list) {
        this.z = list;
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public List<com.bytedance.adsdk.lottie.m.z<PointF>> dl() {
        return this.z;
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public boolean g() {
        return this.z.size() == 1 && this.z.get(0).gc();
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> z() {
        if (this.z.get(0).gc()) {
            return new com.bytedance.adsdk.lottie.z.g.kb(this.z);
        }
        return new com.bytedance.adsdk.lottie.z.g.uy(this.z);
    }
}
