package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements z.InterfaceC0041z, gc, kb {
    float dl;
    final Paint g;
    private final com.bytedance.adsdk.lottie.gz gz;
    private final List<com.bytedance.adsdk.lottie.z.g.z<?, Float>> i;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> kb;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> ls;
    private com.bytedance.adsdk.lottie.z.g.dl p;
    private com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> pf;
    private final float[] uy;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> v;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Integer> wp;
    protected final com.bytedance.adsdk.lottie.model.layer.dl z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PathMeasure f218a = new PathMeasure();
    private final Path gc = new Path();
    private final Path m = new Path();
    private final RectF e = new RectF();
    private final List<C0042z> fo = new ArrayList();

    z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.lottie.model.z.a aVar, com.bytedance.adsdk.lottie.model.z.g gVar, List<com.bytedance.adsdk.lottie.model.z.g> list, com.bytedance.adsdk.lottie.model.z.g gVar2) {
        com.bytedance.adsdk.lottie.z.z zVar = new com.bytedance.adsdk.lottie.z.z(1);
        this.g = zVar;
        this.dl = 0.0f;
        this.gz = gzVar;
        this.z = dlVar;
        zVar.setStyle(Paint.Style.STROKE);
        zVar.setStrokeCap(cap);
        zVar.setStrokeJoin(join);
        zVar.setStrokeMiter(f);
        this.wp = aVar.z();
        this.kb = gVar.z();
        if (gVar2 == null) {
            this.v = null;
        } else {
            this.v = gVar2.z();
        }
        this.i = new ArrayList(list.size());
        this.uy = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.i.add(list.get(i).z());
        }
        dlVar.z(this.wp);
        dlVar.z(this.kb);
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            dlVar.z(this.i.get(i2));
        }
        com.bytedance.adsdk.lottie.z.g.z<?, Float> zVar2 = this.v;
        if (zVar2 != null) {
            dlVar.z(zVar2);
        }
        this.wp.z(this);
        this.kb.z(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.i.get(i3).z(this);
        }
        com.bytedance.adsdk.lottie.z.g.z<?, Float> zVar3 = this.v;
        if (zVar3 != null) {
            zVar3.z(this);
        }
        if (dlVar.wp() != null) {
            com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ = dlVar.wp().z().z();
            this.ls = zVarZ;
            zVarZ.z(this);
            dlVar.z(this.ls);
        }
        if (dlVar.i() != null) {
            this.p = new com.bytedance.adsdk.lottie.z.g.dl(this, dlVar, dlVar.i());
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        this.gz.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.bytedance.adsdk.lottie.z.z.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(java.util.List<com.bytedance.adsdk.lottie.z.z.dl> r8, java.util.List<com.bytedance.adsdk.lottie.z.z.dl> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.bytedance.adsdk.lottie.z.z.dl r3 = (com.bytedance.adsdk.lottie.z.z.dl) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.lottie.z.z.q
            if (r4 == 0) goto L1f
            com.bytedance.adsdk.lottie.z.z.q r3 = (com.bytedance.adsdk.lottie.z.z.q) r3
            com.bytedance.adsdk.lottie.model.g.js$z r4 = r3.getType()
            com.bytedance.adsdk.lottie.model.g.js$z r5 = com.bytedance.adsdk.lottie.model.g.js.z.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.z(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.bytedance.adsdk.lottie.z.z.dl r3 = (com.bytedance.adsdk.lottie.z.z.dl) r3
            boolean r4 = r3 instanceof com.bytedance.adsdk.lottie.z.z.q
            if (r4 == 0) goto L55
            r4 = r3
            com.bytedance.adsdk.lottie.z.z.q r4 = (com.bytedance.adsdk.lottie.z.z.q) r4
            com.bytedance.adsdk.lottie.model.g.js$z r5 = r4.getType()
            com.bytedance.adsdk.lottie.model.g.js$z r6 = com.bytedance.adsdk.lottie.model.g.js.z.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<com.bytedance.adsdk.lottie.z.z.z$z> r3 = r7.fo
            r3.add(r0)
        L4c:
            com.bytedance.adsdk.lottie.z.z.z$z r0 = new com.bytedance.adsdk.lottie.z.z.z$z
            r0.<init>(r4)
            r4.z(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.bytedance.adsdk.lottie.z.z.i
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.bytedance.adsdk.lottie.z.z.z$z r0 = new com.bytedance.adsdk.lottie.z.z.z$z
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.bytedance.adsdk.lottie.z.z.z.C0042z.z(r0)
            com.bytedance.adsdk.lottie.z.z.i r3 = (com.bytedance.adsdk.lottie.z.z.i) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<com.bytedance.adsdk.lottie.z.z.z$z> r8 = r7.fo
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.z.z.z.z(java.util.List, java.util.List):void");
    }

    public void z(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.lottie.gc.z("StrokeContent#draw");
        if (com.bytedance.adsdk.lottie.gc.fo.g(matrix)) {
            com.bytedance.adsdk.lottie.gc.g("StrokeContent#draw");
            return;
        }
        this.g.setAlpha(com.bytedance.adsdk.lottie.gc.gz.z((int) ((((i / 255.0f) * ((com.bytedance.adsdk.lottie.z.g.m) this.wp).fo()) / 100.0f) * 255.0f), 0, 255));
        this.g.setStrokeWidth(((com.bytedance.adsdk.lottie.z.g.a) this.kb).fo() * com.bytedance.adsdk.lottie.gc.fo.z(matrix));
        if (this.g.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.lottie.gc.g("StrokeContent#draw");
            return;
        }
        z(matrix);
        com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> zVar = this.pf;
        if (zVar != null) {
            this.g.setColorFilter(zVar.e());
        }
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVar2 = this.ls;
        if (zVar2 != null) {
            float fFloatValue = zVar2.e().floatValue();
            if (fFloatValue == 0.0f) {
                this.g.setMaskFilter(null);
            } else if (fFloatValue != this.dl) {
                this.g.setMaskFilter(this.z.g(fFloatValue));
            }
            this.dl = fFloatValue;
        }
        com.bytedance.adsdk.lottie.z.g.dl dlVar = this.p;
        if (dlVar != null) {
            dlVar.z(this.g);
        }
        for (int i2 = 0; i2 < this.fo.size(); i2++) {
            C0042z c0042z = this.fo.get(i2);
            if (c0042z.g != null) {
                z(canvas, c0042z, matrix);
            } else {
                com.bytedance.adsdk.lottie.gc.z("StrokeContent#buildPath");
                this.gc.reset();
                for (int size = c0042z.z.size() - 1; size >= 0; size--) {
                    this.gc.addPath(((i) c0042z.z.get(size)).a(), matrix);
                }
                com.bytedance.adsdk.lottie.gc.g("StrokeContent#buildPath");
                com.bytedance.adsdk.lottie.gc.z("StrokeContent#drawPath");
                canvas.drawPath(this.gc, this.g);
                com.bytedance.adsdk.lottie.gc.g("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.lottie.gc.g("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(android.graphics.Canvas r17, com.bytedance.adsdk.lottie.z.z.z.C0042z r18, android.graphics.Matrix r19) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.z.z.z.z(android.graphics.Canvas, com.bytedance.adsdk.lottie.z.z.z$z, android.graphics.Matrix):void");
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.lottie.gc.z("StrokeContent#getBounds");
        this.gc.reset();
        for (int i = 0; i < this.fo.size(); i++) {
            C0042z c0042z = this.fo.get(i);
            for (int i2 = 0; i2 < c0042z.z.size(); i2++) {
                this.gc.addPath(((i) c0042z.z.get(i2)).a(), matrix);
            }
        }
        this.gc.computeBounds(this.e, false);
        float fFo = ((com.bytedance.adsdk.lottie.z.g.a) this.kb).fo();
        RectF rectF2 = this.e;
        float f = fFo / 2.0f;
        rectF2.set(rectF2.left - f, this.e.top - f, this.e.right + f, this.e.bottom + f);
        rectF.set(this.e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.lottie.gc.g("StrokeContent#getBounds");
    }

    private void z(Matrix matrix) {
        com.bytedance.adsdk.lottie.gc.z("StrokeContent#applyDashPattern");
        if (this.i.isEmpty()) {
            com.bytedance.adsdk.lottie.gc.g("StrokeContent#applyDashPattern");
            return;
        }
        float fZ = com.bytedance.adsdk.lottie.gc.fo.z(matrix);
        for (int i = 0; i < this.i.size(); i++) {
            this.uy[i] = this.i.get(i).e().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.uy;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.uy;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.uy;
            fArr3[i] = fArr3[i] * fZ;
        }
        com.bytedance.adsdk.lottie.z.g.z<?, Float> zVar = this.v;
        this.g.setPathEffect(new DashPathEffect(this.uy, zVar == null ? 0.0f : fZ * zVar.e().floatValue()));
        com.bytedance.adsdk.lottie.gc.g("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.z.z.z$z, reason: collision with other inner class name */
    private static final class C0042z {
        private final q g;
        private final List<i> z;

        private C0042z(q qVar) {
            this.z = new ArrayList();
            this.g = qVar;
        }
    }
}
