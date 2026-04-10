package com.bytedance.adsdk.lottie.model.g;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    private boolean dl;
    private PointF g;
    private final List<com.bytedance.adsdk.lottie.model.z> z;

    public v(PointF pointF, boolean z, List<com.bytedance.adsdk.lottie.model.z> list) {
        this.g = pointF;
        this.dl = z;
        this.z = new ArrayList(list);
    }

    public v() {
        this.z = new ArrayList();
    }

    public void z(float f, float f2) {
        if (this.g == null) {
            this.g = new PointF();
        }
        this.g.set(f, f2);
    }

    public PointF z() {
        return this.g;
    }

    public void z(boolean z) {
        this.dl = z;
    }

    public boolean g() {
        return this.dl;
    }

    public List<com.bytedance.adsdk.lottie.model.z> dl() {
        return this.z;
    }

    public void z(v vVar, v vVar2, float f) {
        if (this.g == null) {
            this.g = new PointF();
        }
        this.dl = vVar.g() || vVar2.g();
        if (vVar.dl().size() != vVar2.dl().size()) {
            com.bytedance.adsdk.lottie.gc.gc.g("Curves must have the same number of control points. Shape 1: " + vVar.dl().size() + "\tShape 2: " + vVar2.dl().size());
        }
        int iMin = Math.min(vVar.dl().size(), vVar2.dl().size());
        if (this.z.size() < iMin) {
            for (int size = this.z.size(); size < iMin; size++) {
                this.z.add(new com.bytedance.adsdk.lottie.model.z());
            }
        } else if (this.z.size() > iMin) {
            for (int size2 = this.z.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.lottie.model.z> list = this.z;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFZ = vVar.z();
        PointF pointFZ2 = vVar2.z();
        z(com.bytedance.adsdk.lottie.gc.gz.z(pointFZ.x, pointFZ2.x, f), com.bytedance.adsdk.lottie.gc.gz.z(pointFZ.y, pointFZ2.y, f));
        for (int size3 = this.z.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.model.z zVar = vVar.dl().get(size3);
            com.bytedance.adsdk.lottie.model.z zVar2 = vVar2.dl().get(size3);
            PointF pointFZ3 = zVar.z();
            PointF pointFG = zVar.g();
            PointF pointFDl = zVar.dl();
            PointF pointFZ4 = zVar2.z();
            PointF pointFG2 = zVar2.g();
            PointF pointFDl2 = zVar2.dl();
            this.z.get(size3).z(com.bytedance.adsdk.lottie.gc.gz.z(pointFZ3.x, pointFZ4.x, f), com.bytedance.adsdk.lottie.gc.gz.z(pointFZ3.y, pointFZ4.y, f));
            this.z.get(size3).g(com.bytedance.adsdk.lottie.gc.gz.z(pointFG.x, pointFG2.x, f), com.bytedance.adsdk.lottie.gc.gz.z(pointFG.y, pointFG2.y, f));
            this.z.get(size3).dl(com.bytedance.adsdk.lottie.gc.gz.z(pointFDl.x, pointFDl2.x, f), com.bytedance.adsdk.lottie.gc.gz.z(pointFDl.y, pointFDl2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.z.size() + "closed=" + this.dl + '}';
    }
}
