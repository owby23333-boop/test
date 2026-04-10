package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements z.InterfaceC0041z, gc, kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.dl f206a;
    private final Paint dl;
    private final List<i> e;
    private final com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> fo;
    private final Path g;
    private final String gc;
    private final com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> gz;
    private com.bytedance.adsdk.lottie.z.g.dl i;
    private final com.bytedance.adsdk.lottie.gz kb;
    private final boolean m;
    private com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> uy;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> wp;
    float z;

    public e(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.pf pfVar) {
        Path path = new Path();
        this.g = path;
        this.dl = new com.bytedance.adsdk.lottie.z.z(1);
        this.e = new ArrayList();
        this.f206a = dlVar;
        this.gc = pfVar.z();
        this.m = pfVar.gc();
        this.kb = gzVar;
        if (dlVar.wp() != null) {
            com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ = dlVar.wp().z().z();
            this.wp = zVarZ;
            zVarZ.z(this);
            dlVar.z(this.wp);
        }
        if (dlVar.i() != null) {
            this.i = new com.bytedance.adsdk.lottie.z.g.dl(this, dlVar, dlVar.i());
        }
        if (pfVar.g() == null || pfVar.dl() == null) {
            this.gz = null;
            this.fo = null;
            return;
        }
        path.setFillType(pfVar.a());
        com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVarZ2 = pfVar.g().z();
        this.gz = zVarZ2;
        zVarZ2.z(this);
        dlVar.z(zVarZ2);
        com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVarZ3 = pfVar.dl().z();
        this.fo = zVarZ3;
        zVarZ3.z(this);
        dlVar.z(zVarZ3);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        this.kb.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
        for (int i = 0; i < list2.size(); i++) {
            dl dlVar = list2.get(i);
            if (dlVar instanceof i) {
                this.e.add((i) dlVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(Canvas canvas, Matrix matrix, int i) {
        if (this.m) {
            return;
        }
        com.bytedance.adsdk.lottie.gc.z("FillContent#draw");
        this.dl.setColor((com.bytedance.adsdk.lottie.gc.gz.z((int) ((((i / 255.0f) * this.fo.e().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.lottie.z.g.g) this.gz).fo() & 16777215));
        com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> zVar = this.uy;
        if (zVar != null) {
            this.dl.setColorFilter(zVar.e());
        }
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVar2 = this.wp;
        if (zVar2 != null) {
            float fFloatValue = zVar2.e().floatValue();
            if (fFloatValue == 0.0f) {
                this.dl.setMaskFilter(null);
            } else if (fFloatValue != this.z) {
                this.dl.setMaskFilter(this.f206a.g(fFloatValue));
            }
            this.z = fFloatValue;
        }
        com.bytedance.adsdk.lottie.z.g.dl dlVar = this.i;
        if (dlVar != null) {
            dlVar.z(this.dl);
        }
        this.g.reset();
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            this.g.addPath(this.e.get(i2).a(), matrix);
        }
        canvas.drawPath(this.g, this.dl);
        com.bytedance.adsdk.lottie.gc.g("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        this.g.reset();
        for (int i = 0; i < this.e.size(); i++) {
            this.g.addPath(this.e.get(i).a(), matrix);
        }
        this.g.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
