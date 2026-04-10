package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.g.js;
import com.bytedance.adsdk.lottie.model.g.uy;
import com.bytedance.adsdk.lottie.z.g.z;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class v implements z.InterfaceC0041z, i, kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uy.z f216a;
    private final com.bytedance.adsdk.lottie.gz dl;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> e;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> fo;
    private final String g;
    private final boolean gc;
    private final com.bytedance.adsdk.lottie.z.g.z<?, PointF> gz;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> i;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> kb;
    private final boolean m;
    private boolean pf;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> uy;
    private final com.bytedance.adsdk.lottie.z.g.z<?, Float> wp;
    private final Path z = new Path();
    private final g v = new g();

    public v(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.model.g.uy uyVar) {
        this.dl = gzVar;
        this.g = uyVar.z();
        uy.z type = uyVar.getType();
        this.f216a = type;
        this.gc = uyVar.fo();
        this.m = uyVar.uy();
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ = uyVar.g().z();
        this.e = zVarZ;
        com.bytedance.adsdk.lottie.z.g.z<PointF, PointF> zVarZ2 = uyVar.dl().z();
        this.gz = zVarZ2;
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ3 = uyVar.a().z();
        this.fo = zVarZ3;
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ4 = uyVar.m().z();
        this.kb = zVarZ4;
        com.bytedance.adsdk.lottie.z.g.z<Float, Float> zVarZ5 = uyVar.gz().z();
        this.i = zVarZ5;
        if (type == uy.z.STAR) {
            this.uy = uyVar.gc().z();
            this.wp = uyVar.e().z();
        } else {
            this.uy = null;
            this.wp = null;
        }
        dlVar.z(zVarZ);
        dlVar.z(zVarZ2);
        dlVar.z(zVarZ3);
        dlVar.z(zVarZ4);
        dlVar.z(zVarZ5);
        if (type == uy.z.STAR) {
            dlVar.z(this.uy);
            dlVar.z(this.wp);
        }
        zVarZ.z(this);
        zVarZ2.z(this);
        zVarZ3.z(this);
        zVarZ4.z(this);
        zVarZ5.z(this);
        if (type == uy.z.STAR) {
            this.uy.z(this);
            this.wp.z(this);
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        g();
    }

    private void g() {
        this.pf = false;
        this.dl.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
        for (int i = 0; i < list.size(); i++) {
            dl dlVar = list.get(i);
            if (dlVar instanceof q) {
                q qVar = (q) dlVar;
                if (qVar.getType() == js.z.SIMULTANEOUSLY) {
                    this.v.z(qVar);
                    qVar.z(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.z.i
    public Path a() {
        if (this.pf) {
            return this.z;
        }
        this.z.reset();
        if (this.gc) {
            this.pf = true;
            return this.z;
        }
        int i = AnonymousClass1.z[this.f216a.ordinal()];
        if (i == 1) {
            dl();
        } else if (i == 2) {
            gc();
        }
        this.z.close();
        this.v.z(this.z);
        this.pf = true;
        return this.z;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.z.z.v$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[uy.z.values().length];
            z = iArr;
            try {
                iArr[uy.z.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[uy.z.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void dl() {
        int i;
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        double d3;
        float fFloatValue = this.e.e().floatValue();
        double radians = Math.toRadians((this.fo == null ? 0.0d : r2.e().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f9 = (float) (6.283185307179586d / d4);
        if (this.m) {
            f9 *= -1.0f;
        }
        float f10 = f9 / 2.0f;
        float f11 = fFloatValue - ((int) fFloatValue);
        int i2 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (double) ((1.0f - f11) * f10);
        }
        float fFloatValue2 = this.kb.e().floatValue();
        float fFloatValue3 = this.uy.e().floatValue();
        com.bytedance.adsdk.lottie.z.g.z<?, Float> zVar = this.wp;
        float fFloatValue4 = zVar != null ? zVar.e().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.lottie.z.g.z<?, Float> zVar2 = this.i;
        float fFloatValue5 = zVar2 != null ? zVar2.e().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f3 = ((fFloatValue2 - fFloatValue3) * f11) + fFloatValue3;
            i = i2;
            double d5 = f3;
            float fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.z.moveTo(fCos, fSin);
            d = radians + ((double) ((f9 * f11) / 2.0f));
            f = fCos;
            f2 = f10;
        } else {
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.z.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f10;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i3 = 0;
        float f12 = f2;
        float f13 = f;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 < dCeil) {
                float f14 = z ? fFloatValue2 : fFloatValue3;
                if (f3 == 0.0f || d7 != dCeil - 2.0d) {
                    f4 = f9;
                    f5 = f12;
                } else {
                    f4 = f9;
                    f5 = (f9 * f11) / 2.0f;
                }
                if (f3 == 0.0f || d7 != dCeil - 1.0d) {
                    d2 = d7;
                    f6 = f3;
                    f3 = f14;
                } else {
                    d2 = d7;
                    f6 = f3;
                }
                double d8 = f3;
                double d9 = dCeil;
                float fCos3 = (float) (d8 * Math.cos(d));
                float fSin3 = (float) (d8 * Math.sin(d));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.z.lineTo(fCos3, fSin3);
                    d3 = d;
                    f7 = fFloatValue4;
                    f8 = fFloatValue5;
                } else {
                    f7 = fFloatValue4;
                    double dAtan2 = (float) (Math.atan2(fSin, f13) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f8 = fFloatValue5;
                    d3 = d;
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f15 = z ? f7 : f8;
                    float f16 = z ? f8 : f7;
                    float f17 = (z ? fFloatValue3 : fFloatValue2) * f15 * 0.47829f;
                    float f18 = fCos4 * f17;
                    float f19 = f17 * fSin4;
                    float f20 = (z ? fFloatValue2 : fFloatValue3) * f16 * 0.47829f;
                    float f21 = fCos5 * f20;
                    float f22 = f20 * fSin5;
                    if (i != 0) {
                        if (i3 == 0) {
                            f18 *= f11;
                            f19 *= f11;
                        } else if (d2 == d9 - 1.0d) {
                            f21 *= f11;
                            f22 *= f11;
                        }
                    }
                    this.z.cubicTo(f13 - f18, fSin - f19, fCos3 + f21, fSin3 + f22, fCos3, fSin3);
                }
                d = d3 + ((double) f5);
                z = !z;
                i3++;
                f13 = fCos3;
                fSin = fSin3;
                fFloatValue5 = f8;
                fFloatValue4 = f7;
                f3 = f6;
                f9 = f4;
                dCeil = d9;
            } else {
                PointF pointFE = this.gz.e();
                this.z.offset(pointFE.x, pointFE.y);
                this.z.close();
                return;
            }
        }
    }

    private void gc() {
        int i;
        double d;
        double d2;
        double d3;
        int iFloor = (int) Math.floor(this.e.e().floatValue());
        double radians = Math.toRadians((this.fo == null ? 0.0d : r2.e().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.i.e().floatValue() / 100.0f;
        float fFloatValue2 = this.kb.e().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.z.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.z.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.z.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFE = this.gz.e();
        this.z.offset(pointFE.x, pointFE.y);
        this.z.close();
    }
}
