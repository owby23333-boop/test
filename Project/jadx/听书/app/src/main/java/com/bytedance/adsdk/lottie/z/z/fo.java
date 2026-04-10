package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f207a;
    private final LongSparseArray<RadialGradient> e;
    private final com.bytedance.adsdk.lottie.model.g.e fo;
    private final boolean gc;
    private final RectF gz;
    private final com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> i;
    private final com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.a, com.bytedance.adsdk.lottie.model.g.a> kb;
    private final LongSparseArray<LinearGradient> m;
    private final int uy;
    private com.bytedance.adsdk.lottie.z.g.p v;
    private final com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> wp;

    public fo(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.m mVar) {
        super(gzVar, dlVar, mVar.gz().z(), mVar.fo().z(), mVar.wp(), mVar.a(), mVar.e(), mVar.uy(), mVar.kb());
        this.m = new LongSparseArray<>();
        this.e = new LongSparseArray<>();
        this.gz = new RectF();
        this.f207a = mVar.z();
        this.fo = mVar.g();
        this.gc = mVar.i();
        this.uy = (int) (gzVar.hh().gc() / 32.0f);
        com.bytedance.adsdk.lottie.z.g.z<com.bytedance.adsdk.lottie.model.g.a, com.bytedance.adsdk.lottie.model.g.a> zVarZ = mVar.dl().z();
        this.kb = zVarZ;
        zVarZ.z(this);
        dlVar.z(zVarZ);
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ2 = mVar.gc().z();
        this.wp = zVarZ2;
        zVarZ2.z(this);
        dlVar.z(zVarZ2);
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ3 = mVar.m().z();
        this.i = zVarZ3;
        zVarZ3.z(this);
        dlVar.z(zVarZ3);
    }

    @Override // com.bytedance.adsdk.lottie.z.z.z, com.bytedance.adsdk.lottie.z.z.gc
    public void z(Canvas canvas, Matrix matrix, int i) {
        Shader shaderDl;
        if (this.gc) {
            return;
        }
        z(this.gz, matrix, false);
        if (this.fo == com.bytedance.adsdk.lottie.model.g.e.LINEAR) {
            shaderDl = g();
        } else {
            shaderDl = dl();
        }
        shaderDl.setLocalMatrix(matrix);
        this.g.setShader(shaderDl);
        super.z(canvas, matrix, i);
    }

    private LinearGradient g() {
        long jA = a();
        LinearGradient linearGradient = this.m.get(jA);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFE = this.wp.e();
        PointF pointFE2 = this.i.e();
        com.bytedance.adsdk.lottie.model.g.a aVarE = this.kb.e();
        LinearGradient linearGradient2 = new LinearGradient(pointFE.x, pointFE.y, pointFE2.x, pointFE2.y, z(aVarE.g()), aVarE.z(), Shader.TileMode.CLAMP);
        this.m.put(jA, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient dl() {
        long jA = a();
        RadialGradient radialGradient = this.e.get(jA);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFE = this.wp.e();
        PointF pointFE2 = this.i.e();
        com.bytedance.adsdk.lottie.model.g.a aVarE = this.kb.e();
        int[] iArrZ = z(aVarE.g());
        float[] fArrZ = aVarE.z();
        RadialGradient radialGradient2 = new RadialGradient(pointFE.x, pointFE.y, (float) Math.hypot(pointFE2.x - r7, pointFE2.y - r8), iArrZ, fArrZ, Shader.TileMode.CLAMP);
        this.e.put(jA, radialGradient2);
        return radialGradient2;
    }

    private int a() {
        int iRound = Math.round(this.wp.gz() * this.uy);
        int iRound2 = Math.round(this.i.gz() * this.uy);
        int iRound3 = Math.round(this.kb.gz() * this.uy);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] z(int[] iArr) {
        com.bytedance.adsdk.lottie.z.g.p pVar = this.v;
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
