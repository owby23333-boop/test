package com.bytedance.adsdk.lottie.z.g;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.z.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f198a;
    private final Matrix dl;
    private z<?, PointF> e;
    private z<Float, Float> fo;
    private final Matrix g;
    private final float[] gc;
    private z<com.bytedance.adsdk.lottie.m.a, com.bytedance.adsdk.lottie.m.a> gz;
    private z<?, Float> i;
    private a kb;
    private z<PointF, PointF> m;
    private z<Integer, Integer> uy;
    private z<?, Float> v;
    private a wp;
    private final Matrix z = new Matrix();

    public ls(com.bytedance.adsdk.lottie.model.z.wp wpVar) {
        this.m = wpVar.z() == null ? null : wpVar.z().z();
        this.e = wpVar.g() == null ? null : wpVar.g().z();
        this.gz = wpVar.dl() == null ? null : wpVar.dl().z();
        this.fo = wpVar.a() == null ? null : wpVar.a().z();
        a aVar = wpVar.gz() == null ? null : (a) wpVar.gz().z();
        this.kb = aVar;
        if (aVar != null) {
            this.g = new Matrix();
            this.dl = new Matrix();
            this.f198a = new Matrix();
            this.gc = new float[9];
        } else {
            this.g = null;
            this.dl = null;
            this.f198a = null;
            this.gc = null;
        }
        this.wp = wpVar.fo() == null ? null : (a) wpVar.fo().z();
        if (wpVar.gc() != null) {
            this.uy = wpVar.gc().z();
        }
        if (wpVar.m() != null) {
            this.i = wpVar.m().z();
        } else {
            this.i = null;
        }
        if (wpVar.e() != null) {
            this.v = wpVar.e().z();
        } else {
            this.v = null;
        }
    }

    public void z(com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        dlVar.z(this.uy);
        dlVar.z(this.i);
        dlVar.z(this.v);
        dlVar.z(this.m);
        dlVar.z(this.e);
        dlVar.z(this.gz);
        dlVar.z(this.fo);
        dlVar.z(this.kb);
        dlVar.z(this.wp);
    }

    public void z(z.InterfaceC0041z interfaceC0041z) {
        z<Integer, Integer> zVar = this.uy;
        if (zVar != null) {
            zVar.z(interfaceC0041z);
        }
        z<?, Float> zVar2 = this.i;
        if (zVar2 != null) {
            zVar2.z(interfaceC0041z);
        }
        z<?, Float> zVar3 = this.v;
        if (zVar3 != null) {
            zVar3.z(interfaceC0041z);
        }
        z<PointF, PointF> zVar4 = this.m;
        if (zVar4 != null) {
            zVar4.z(interfaceC0041z);
        }
        z<?, PointF> zVar5 = this.e;
        if (zVar5 != null) {
            zVar5.z(interfaceC0041z);
        }
        z<com.bytedance.adsdk.lottie.m.a, com.bytedance.adsdk.lottie.m.a> zVar6 = this.gz;
        if (zVar6 != null) {
            zVar6.z(interfaceC0041z);
        }
        z<Float, Float> zVar7 = this.fo;
        if (zVar7 != null) {
            zVar7.z(interfaceC0041z);
        }
        a aVar = this.kb;
        if (aVar != null) {
            aVar.z(interfaceC0041z);
        }
        a aVar2 = this.wp;
        if (aVar2 != null) {
            aVar2.z(interfaceC0041z);
        }
    }

    public void z(float f) {
        z<Integer, Integer> zVar = this.uy;
        if (zVar != null) {
            zVar.z(f);
        }
        z<?, Float> zVar2 = this.i;
        if (zVar2 != null) {
            zVar2.z(f);
        }
        z<?, Float> zVar3 = this.v;
        if (zVar3 != null) {
            zVar3.z(f);
        }
        z<PointF, PointF> zVar4 = this.m;
        if (zVar4 != null) {
            zVar4.z(f);
        }
        z<?, PointF> zVar5 = this.e;
        if (zVar5 != null) {
            zVar5.z(f);
        }
        z<com.bytedance.adsdk.lottie.m.a, com.bytedance.adsdk.lottie.m.a> zVar6 = this.gz;
        if (zVar6 != null) {
            zVar6.z(f);
        }
        z<Float, Float> zVar7 = this.fo;
        if (zVar7 != null) {
            zVar7.z(f);
        }
        a aVar = this.kb;
        if (aVar != null) {
            aVar.z(f);
        }
        a aVar2 = this.wp;
        if (aVar2 != null) {
            aVar2.z(f);
        }
    }

    public z<?, Integer> z() {
        return this.uy;
    }

    public z<?, Float> g() {
        return this.i;
    }

    public z<?, Float> dl() {
        return this.v;
    }

    public Matrix a() {
        PointF pointFE;
        float fFo;
        PointF pointFE2;
        this.z.reset();
        z<?, PointF> zVar = this.e;
        if (zVar != null && (pointFE2 = zVar.e()) != null && (pointFE2.x != 0.0f || pointFE2.y != 0.0f)) {
            this.z.preTranslate(pointFE2.x, pointFE2.y);
        }
        z<Float, Float> zVar2 = this.fo;
        if (zVar2 != null) {
            if (zVar2 instanceof p) {
                fFo = zVar2.e().floatValue();
            } else {
                fFo = ((a) zVar2).fo();
            }
            if (fFo != 0.0f) {
                this.z.preRotate(fFo);
            }
        }
        if (this.kb != null) {
            float fCos = this.wp == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.fo()) + 90.0f));
            float fSin = this.wp == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.fo()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.fo()));
            gc();
            float[] fArr = this.gc;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f = -fSin;
            fArr[3] = f;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.g.setValues(fArr);
            gc();
            float[] fArr2 = this.gc;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.dl.setValues(fArr2);
            gc();
            float[] fArr3 = this.gc;
            fArr3[0] = fCos;
            fArr3[1] = f;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f198a.setValues(fArr3);
            this.dl.preConcat(this.g);
            this.f198a.preConcat(this.dl);
            this.z.preConcat(this.f198a);
        }
        z<com.bytedance.adsdk.lottie.m.a, com.bytedance.adsdk.lottie.m.a> zVar3 = this.gz;
        if (zVar3 != null) {
            com.bytedance.adsdk.lottie.m.a aVarE = zVar3.e();
            if (aVarE.z() != 1.0f || aVarE.g() != 1.0f) {
                this.z.preScale(aVarE.z(), aVarE.g());
            }
        }
        z<PointF, PointF> zVar4 = this.m;
        if (zVar4 != null && (((pointFE = zVar4.e()) != null && pointFE.x != 0.0f) || pointFE.y != 0.0f)) {
            this.z.preTranslate(-pointFE.x, -pointFE.y);
        }
        return this.z;
    }

    private void gc() {
        for (int i = 0; i < 9; i++) {
            this.gc[i] = 0.0f;
        }
    }

    public Matrix g(float f) {
        z<?, PointF> zVar = this.e;
        PointF pointFE = zVar == null ? null : zVar.e();
        z<com.bytedance.adsdk.lottie.m.a, com.bytedance.adsdk.lottie.m.a> zVar2 = this.gz;
        com.bytedance.adsdk.lottie.m.a aVarE = zVar2 == null ? null : zVar2.e();
        this.z.reset();
        if (pointFE != null) {
            this.z.preTranslate(pointFE.x * f, pointFE.y * f);
        }
        if (aVarE != null) {
            double d = f;
            this.z.preScale((float) Math.pow(aVarE.z(), d), (float) Math.pow(aVarE.g(), d));
        }
        z<Float, Float> zVar3 = this.fo;
        if (zVar3 != null) {
            float fFloatValue = zVar3.e().floatValue();
            z<PointF, PointF> zVar4 = this.m;
            PointF pointFE2 = zVar4 != null ? zVar4.e() : null;
            this.z.preRotate(fFloatValue * f, pointFE2 == null ? 0.0f : pointFE2.x, pointFE2 != null ? pointFE2.y : 0.0f);
        }
        return this.z;
    }
}
