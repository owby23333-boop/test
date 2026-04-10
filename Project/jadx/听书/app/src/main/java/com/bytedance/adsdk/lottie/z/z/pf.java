package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.z.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class pf implements z.InterfaceC0041z, i, kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f213a;
    private final String dl;
    private final com.bytedance.adsdk.lottie.z.g.z<?, PointF> e;
    private final com.bytedance.adsdk.lottie.gz gc;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> gz;
    private boolean kb;
    private final com.bytedance.adsdk.lottie.z.g.z<?, PointF> m;
    private final Path z = new Path();
    private final RectF g = new RectF();
    private final g fo = new g();
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> uy = null;

    public pf(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.kb kbVar) {
        this.dl = kbVar.z();
        this.f213a = kbVar.gc();
        this.gc = gzVar;
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ = kbVar.a().z();
        this.m = zVarZ;
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ2 = kbVar.dl().z();
        this.e = zVarZ2;
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ3 = kbVar.g().z();
        this.gz = zVarZ3;
        dlVar.z(zVarZ);
        dlVar.z(zVarZ2);
        dlVar.z(zVarZ3);
        zVarZ.z(this);
        zVarZ2.z(this);
        zVarZ3.z(this);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        g();
    }

    private void g() {
        this.kb = false;
        this.gc.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // com.bytedance.adsdk.lottie.z.z.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(java.util.List<com.bytedance.adsdk.lottie.z.z.dl> r5, java.util.List<com.bytedance.adsdk.lottie.z.z.dl> r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            int r0 = r5.size()
            if (r6 >= r0) goto L34
            java.lang.Object r0 = r5.get(r6)
            com.bytedance.adsdk.lottie.z.z.dl r0 = (com.bytedance.adsdk.lottie.z.z.dl) r0
            boolean r1 = r0 instanceof com.bytedance.adsdk.lottie.z.z.q
            if (r1 == 0) goto L25
            r1 = r0
            com.bytedance.adsdk.lottie.z.z.q r1 = (com.bytedance.adsdk.lottie.z.z.q) r1
            com.bytedance.adsdk.lottie.model.g.js$z r2 = r1.getType()
            com.bytedance.adsdk.lottie.model.g.js$z r3 = com.bytedance.adsdk.lottie.model.g.js.z.SIMULTANEOUSLY
            if (r2 != r3) goto L25
            com.bytedance.adsdk.lottie.z.z.g r0 = r4.fo
            r0.z(r1)
            r1.z(r4)
            goto L31
        L25:
            boolean r1 = r0 instanceof com.bytedance.adsdk.lottie.z.z.p
            if (r1 == 0) goto L31
            com.bytedance.adsdk.lottie.z.z.p r0 = (com.bytedance.adsdk.lottie.z.z.p) r0
            com.bytedance.adsdk.lottie.z.g.z r0 = r0.g()
            r4.uy = r0
        L31:
            int r6 = r6 + 1
            goto L1
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.z.z.pf.z(java.util.List, java.util.List):void");
    }

    @Override // com.bytedance.adsdk.lottie.z.z.i
    public Path a() {
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVar;
        if (this.kb) {
            return this.z;
        }
        this.z.reset();
        if (this.f213a) {
            this.kb = true;
            return this.z;
        }
        PointF pointFE = this.e.e();
        float f = pointFE.x / 2.0f;
        float f2 = pointFE.y / 2.0f;
        com.bytedance.adsdk.lottie.z.g.z<?, Float> zVar2 = this.gz;
        float fFo = zVar2 == null ? 0.0f : ((com.bytedance.adsdk.lottie.z.g.a) zVar2).fo();
        if (fFo == 0.0f && (zVar = this.uy) != null) {
            fFo = Math.min(zVar.e().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fFo > fMin) {
            fFo = fMin;
        }
        PointF pointFE2 = this.m.e();
        this.z.moveTo(pointFE2.x + f, (pointFE2.y - f2) + fFo);
        this.z.lineTo(pointFE2.x + f, (pointFE2.y + f2) - fFo);
        if (fFo > 0.0f) {
            float f3 = fFo * 2.0f;
            this.g.set((pointFE2.x + f) - f3, (pointFE2.y + f2) - f3, pointFE2.x + f, pointFE2.y + f2);
            this.z.arcTo(this.g, 0.0f, 90.0f, false);
        }
        this.z.lineTo((pointFE2.x - f) + fFo, pointFE2.y + f2);
        if (fFo > 0.0f) {
            float f4 = fFo * 2.0f;
            this.g.set(pointFE2.x - f, (pointFE2.y + f2) - f4, (pointFE2.x - f) + f4, pointFE2.y + f2);
            this.z.arcTo(this.g, 90.0f, 90.0f, false);
        }
        this.z.lineTo(pointFE2.x - f, (pointFE2.y - f2) + fFo);
        if (fFo > 0.0f) {
            float f5 = fFo * 2.0f;
            this.g.set(pointFE2.x - f, pointFE2.y - f2, (pointFE2.x - f) + f5, (pointFE2.y - f2) + f5);
            this.z.arcTo(this.g, 180.0f, 90.0f, false);
        }
        this.z.lineTo((pointFE2.x + f) - fFo, pointFE2.y - f2);
        if (fFo > 0.0f) {
            float f6 = fFo * 2.0f;
            this.g.set((pointFE2.x + f) - f6, pointFE2.y - f2, pointFE2.x + f, (pointFE2.y - f2) + f6);
            this.z.arcTo(this.g, 270.0f, 90.0f, false);
        }
        this.z.close();
        this.fo.z(this.z);
        this.kb = true;
        return this.z;
    }
}
