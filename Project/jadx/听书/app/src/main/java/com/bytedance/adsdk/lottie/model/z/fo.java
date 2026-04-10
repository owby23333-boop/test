package com.bytedance.adsdk.lottie.model.z;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements i<PointF, PointF> {
    private final g g;
    private final g z;

    public fo(g gVar, g gVar2) {
        this.z = gVar;
        this.g = gVar2;
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public List<com.bytedance.adsdk.lottie.m.z<PointF>> dl() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public boolean g() {
        return this.z.g() && this.g.g();
    }

    @Override // com.bytedance.adsdk.lottie.model.z.i
    public com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> z() {
        return new com.bytedance.adsdk.lottie.z.g.v(this.z.z(), this.g.z());
    }
}
