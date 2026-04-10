package com.bytedance.adsdk.lottie.z.g;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class v extends z<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.adsdk.lottie.m.dl<Float> f201a;
    private final PointF e;
    private final z<Float, Float> fo;
    protected com.bytedance.adsdk.lottie.m.dl<Float> gc;
    private final z<Float, Float> gz;
    private final PointF m;

    public v(z<Float, Float> zVar, z<Float, Float> zVar2) {
        super(Collections.emptyList());
        this.m = new PointF();
        this.e = new PointF();
        this.gz = zVar;
        this.fo = zVar2;
        z(gz());
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    public void z(float f) {
        this.gz.z(f);
        this.fo.z(f);
        this.m.set(this.gz.e().floatValue(), this.fo.e().floatValue());
        for (int i = 0; i < this.z.size(); i++) {
            this.z.get(i).z();
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: fo, reason: merged with bridge method [inline-methods] */
    public PointF e() {
        return z(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.z.g.z
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public PointF z(com.bytedance.adsdk.lottie.m.z<PointF> zVar, float f) {
        Float fZ;
        com.bytedance.adsdk.lottie.m.z<Float> zVarDl;
        com.bytedance.adsdk.lottie.m.z<Float> zVarDl2;
        Float fZ2 = null;
        if (this.f201a == null || (zVarDl2 = this.gz.dl()) == null) {
            fZ = null;
        } else {
            float fGc = this.gz.gc();
            Float f2 = zVarDl2.e;
            fZ = this.f201a.z(zVarDl2.m, f2 == null ? zVarDl2.m : f2.floatValue(), zVarDl2.z, zVarDl2.g, f, f, fGc);
        }
        if (this.gc != null && (zVarDl = this.fo.dl()) != null) {
            float fGc2 = this.fo.gc();
            Float f3 = zVarDl.e;
            fZ2 = this.gc.z(zVarDl.m, f3 == null ? zVarDl.m : f3.floatValue(), zVarDl.z, zVarDl.g, f, f, fGc2);
        }
        if (fZ == null) {
            this.e.set(this.m.x, 0.0f);
        } else {
            this.e.set(fZ.floatValue(), 0.0f);
        }
        if (fZ2 == null) {
            PointF pointF = this.e;
            pointF.set(pointF.x, this.m.y);
        } else {
            PointF pointF2 = this.e;
            pointF2.set(pointF2.x, fZ2.floatValue());
        }
        return this.e;
    }
}
