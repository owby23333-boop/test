package com.bytedance.adsdk.lottie.z.z;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements z.InterfaceC0041z, gc, kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.layer.dl f209a;
    private final boolean dl;
    private final Path e;
    private final RectF fo;
    private final com.bytedance.adsdk.lottie.gz fv;
    private final String g;
    private final Paint gz;
    private final com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> i;
    private final int js;
    private final com.bytedance.adsdk.lottie.model.g.e kb;
    private com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> ls;
    private com.bytedance.adsdk.lottie.z.g.p p;
    private final com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> pf;
    private com.bytedance.adsdk.lottie.z.g.dl q;
    private com.bytedance.adsdk.lottie.z.g.z<Float, Float> tb;
    private final List<i> uy;
    private final com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> v;
    private final com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.a, com.bytedance.adsdk.lottie.model.g.a> wp;
    float z;
    private final LongSparseArray<LinearGradient> gc = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> m = new LongSparseArray<>();

    public gz(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.gc gcVar) {
        Path path = new Path();
        this.e = path;
        this.gz = new com.bytedance.adsdk.lottie.z.z(1);
        this.fo = new RectF();
        this.uy = new ArrayList();
        this.z = 0.0f;
        this.f209a = dlVar;
        this.g = gcVar.z();
        this.dl = gcVar.gz();
        this.fv = gzVar;
        this.kb = gcVar.g();
        path.setFillType(gcVar.dl());
        this.js = (int) (mVar.gc() / 32.0f);
        com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.a, com.bytedance.adsdk.lottie.model.g.a> zVarZ = gcVar.a().z();
        this.wp = zVarZ;
        zVarZ.z(this);
        dlVar.z(zVarZ);
        com.bytedance.adsdk.lottie.z.g.z<Integer, Integer> zVarZ2 = gcVar.gc().z();
        this.i = zVarZ2;
        zVarZ2.z(this);
        dlVar.z(zVarZ2);
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ3 = gcVar.m().z();
        this.v = zVarZ3;
        zVarZ3.z(this);
        dlVar.z(zVarZ3);
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ4 = gcVar.e().z();
        this.pf = zVarZ4;
        zVarZ4.z(this);
        dlVar.z(zVarZ4);
        if (dlVar.wp() != null) {
            com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ5 = dlVar.wp().z().z();
            this.tb = zVarZ5;
            zVarZ5.z(this);
            dlVar.z(this.tb);
        }
        if (dlVar.i() != null) {
            this.q = new com.bytedance.adsdk.lottie.z.g.dl(this, dlVar, dlVar.i());
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        this.fv.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
        for (int i = 0; i < list2.size(); i++) {
            dl dlVar = list2.get(i);
            if (dlVar instanceof i) {
                this.uy.add((i) dlVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(Canvas canvas, Matrix matrix, int i) {
        Shader shaderDl;
        if (this.dl) {
            return;
        }
        com.bytedance.adsdk.lottie.gc.z("GradientFillContent#draw");
        this.e.reset();
        for (int i2 = 0; i2 < this.uy.size(); i2++) {
            this.e.addPath(this.uy.get(i2).a(), matrix);
        }
        this.e.computeBounds(this.fo, false);
        if (this.kb == com.bytedance.adsdk.lottie.model.g.e.LINEAR) {
            shaderDl = g();
        } else {
            shaderDl = dl();
        }
        shaderDl.setLocalMatrix(matrix);
        this.gz.setShader(shaderDl);
        com.bytedance.adsdk.lottie.z.g.z<ColorFilter, ColorFilter> zVar = this.ls;
        if (zVar != null) {
            this.gz.setColorFilter(zVar.e());
        }
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVar2 = this.tb;
        if (zVar2 != null) {
            float fFloatValue = zVar2.e().floatValue();
            if (fFloatValue == 0.0f) {
                this.gz.setMaskFilter(null);
            } else if (fFloatValue != this.z) {
                this.gz.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.z = fFloatValue;
        }
        com.bytedance.adsdk.lottie.z.g.dl dlVar = this.q;
        if (dlVar != null) {
            dlVar.z(this.gz);
        }
        this.gz.setAlpha(com.bytedance.adsdk.lottie.gc.gz.z((int) ((((i / 255.0f) * this.i.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.e, this.gz);
        com.bytedance.adsdk.lottie.gc.g("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.z.z.gc
    public void z(RectF rectF, Matrix matrix, boolean z) {
        this.e.reset();
        for (int i = 0; i < this.uy.size(); i++) {
            this.e.addPath(this.uy.get(i).a(), matrix);
        }
        this.e.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private LinearGradient g() {
        long jA = a();
        LinearGradient linearGradient = this.gc.get(jA);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFE = this.v.e();
        PointF pointFE2 = this.pf.e();
        com.bytedance.adsdk.lottie.model.g.a aVarE = this.wp.e();
        LinearGradient linearGradient2 = new LinearGradient(pointFE.x, pointFE.y, pointFE2.x, pointFE2.y, z(aVarE.g()), aVarE.z(), Shader.TileMode.CLAMP);
        this.gc.put(jA, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient dl() {
        long jA = a();
        RadialGradient radialGradient = this.m.get(jA);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFE = this.v.e();
        PointF pointFE2 = this.pf.e();
        com.bytedance.adsdk.lottie.model.g.a aVarE = this.wp.e();
        int[] iArrZ = z(aVarE.g());
        float[] fArrZ = aVarE.z();
        float f = pointFE.x;
        float f2 = pointFE.y;
        float fHypot = (float) Math.hypot(pointFE2.x - f, pointFE2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArrZ, fArrZ, Shader.TileMode.CLAMP);
        this.m.put(jA, radialGradient2);
        return radialGradient2;
    }

    private int a() {
        int iRound = Math.round(this.v.gz() * this.js);
        int iRound2 = Math.round(this.pf.gz() * this.js);
        int iRound3 = Math.round(this.wp.gz() * this.js);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] z(int[] iArr) {
        com.bytedance.adsdk.lottie.z.g.p pVar = this.p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.e();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }
}
