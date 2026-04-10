package com.bytedance.adsdk.lottie.d.bf;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.yuewen.w51;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private PointF bf;
    private boolean d;
    private final List<com.bytedance.adsdk.lottie.d.e> e;

    public t(PointF pointF, boolean z, List<com.bytedance.adsdk.lottie.d.e> list) {
        this.bf = pointF;
        this.d = z;
        this.e = new ArrayList(list);
    }

    public boolean bf() {
        return this.d;
    }

    public List<com.bytedance.adsdk.lottie.d.e> d() {
        return this.e;
    }

    public void e(float f, float f2) {
        if (this.bf == null) {
            this.bf = new PointF();
        }
        this.bf.set(f, f2);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.e.size() + "closed=" + this.d + '}';
    }

    public PointF e() {
        return this.bf;
    }

    public t() {
        this.e = new ArrayList();
    }

    public void e(boolean z) {
        this.d = z;
    }

    public void e(t tVar, t tVar2, @FloatRange(from = w51.l, to = 1.0d) float f) {
        if (this.bf == null) {
            this.bf = new PointF();
        }
        this.d = tVar.bf() || tVar2.bf();
        if (tVar.d().size() != tVar2.d().size()) {
            com.bytedance.adsdk.lottie.vn.tg.bf("Curves must have the same number of control points. Shape 1: " + tVar.d().size() + "\tShape 2: " + tVar2.d().size());
        }
        int iMin = Math.min(tVar.d().size(), tVar2.d().size());
        if (this.e.size() < iMin) {
            for (int size = this.e.size(); size < iMin; size++) {
                this.e.add(new com.bytedance.adsdk.lottie.d.e());
            }
        } else if (this.e.size() > iMin) {
            for (int size2 = this.e.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.lottie.d.e> list = this.e;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFE = tVar.e();
        PointF pointFE2 = tVar2.e();
        e(com.bytedance.adsdk.lottie.vn.p.e(pointFE.x, pointFE2.x, f), com.bytedance.adsdk.lottie.vn.p.e(pointFE.y, pointFE2.y, f));
        for (int size3 = this.e.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.d.e eVar = tVar.d().get(size3);
            com.bytedance.adsdk.lottie.d.e eVar2 = tVar2.d().get(size3);
            PointF pointFE3 = eVar.e();
            PointF pointFBf = eVar.bf();
            PointF pointFD = eVar.d();
            PointF pointFE4 = eVar2.e();
            PointF pointFBf2 = eVar2.bf();
            PointF pointFD2 = eVar2.d();
            this.e.get(size3).e(com.bytedance.adsdk.lottie.vn.p.e(pointFE3.x, pointFE4.x, f), com.bytedance.adsdk.lottie.vn.p.e(pointFE3.y, pointFE4.y, f));
            this.e.get(size3).bf(com.bytedance.adsdk.lottie.vn.p.e(pointFBf.x, pointFBf2.x, f), com.bytedance.adsdk.lottie.vn.p.e(pointFBf.y, pointFBf2.y, f));
            this.e.get(size3).d(com.bytedance.adsdk.lottie.vn.p.e(pointFD.x, pointFD2.x, f), com.bytedance.adsdk.lottie.vn.p.e(pointFD.y, pointFD2.y, f));
        }
    }
}
