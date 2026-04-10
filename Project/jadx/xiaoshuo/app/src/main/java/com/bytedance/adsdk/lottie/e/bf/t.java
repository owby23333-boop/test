package com.bytedance.adsdk.lottie.e.bf;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class t extends e<PointF, PointF> {
    protected com.bytedance.adsdk.lottie.p.d<Float> ga;
    private final PointF p;
    protected com.bytedance.adsdk.lottie.p.d<Float> tg;
    private final e<Float, Float> v;
    private final PointF vn;
    private final e<Float, Float> zk;

    public t(e<Float, Float> eVar, e<Float, Float> eVar2) {
        super(Collections.emptyList());
        this.vn = new PointF();
        this.p = new PointF();
        this.v = eVar;
        this.zk = eVar2;
        e(v());
    }

    public void bf(com.bytedance.adsdk.lottie.p.d<Float> dVar) {
        com.bytedance.adsdk.lottie.p.d<Float> dVar2 = this.tg;
        if (dVar2 != null) {
            dVar2.e(null);
        }
        this.tg = dVar;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    public void d(com.bytedance.adsdk.lottie.p.d<Float> dVar) {
        com.bytedance.adsdk.lottie.p.d<Float> dVar2 = this.ga;
        if (dVar2 != null) {
            dVar2.e(null);
        }
        this.ga = dVar;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    /* JADX INFO: renamed from: zk, reason: merged with bridge method [inline-methods] */
    public PointF p() {
        return e(null, 0.0f);
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    public void e(float f) {
        this.v.e(f);
        this.zk.e(f);
        this.vn.set(this.v.p().floatValue(), this.zk.p().floatValue());
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).e();
        }
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public PointF e(com.bytedance.adsdk.lottie.p.e<PointF> eVar, float f) {
        Float fE;
        com.bytedance.adsdk.lottie.p.e<Float> eVarD;
        com.bytedance.adsdk.lottie.p.e<Float> eVarD2;
        Float fE2 = null;
        if (this.tg == null || (eVarD2 = this.v.d()) == null) {
            fE = null;
        } else {
            float fGa = this.v.ga();
            Float f2 = eVarD2.p;
            com.bytedance.adsdk.lottie.p.d<Float> dVar = this.tg;
            float f3 = eVarD2.vn;
            fE = dVar.e(f3, f2 == null ? f3 : f2.floatValue(), eVarD2.e, eVarD2.bf, f, f, fGa);
        }
        if (this.ga != null && (eVarD = this.zk.d()) != null) {
            float fGa2 = this.zk.ga();
            Float f4 = eVarD.p;
            com.bytedance.adsdk.lottie.p.d<Float> dVar2 = this.ga;
            float f5 = eVarD.vn;
            fE2 = dVar2.e(f5, f4 == null ? f5 : f4.floatValue(), eVarD.e, eVarD.bf, f, f, fGa2);
        }
        if (fE == null) {
            this.p.set(this.vn.x, 0.0f);
        } else {
            this.p.set(fE.floatValue(), 0.0f);
        }
        if (fE2 == null) {
            PointF pointF = this.p;
            pointF.set(pointF.x, this.vn.y);
        } else {
            PointF pointF2 = this.p;
            pointF2.set(pointF2.x, fE2.floatValue());
        }
        return this.p;
    }
}
