package com.bytedance.adsdk.lottie.z.g;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.lottie.z.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements z.InterfaceC0041z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z<Float, Float> f194a;
    private final z<Float, Float> dl;
    private boolean e = true;
    private final z<Integer, Integer> g;
    private final z<Float, Float> gc;
    private final z<Float, Float> m;
    private final z.InterfaceC0041z z;

    public dl(z.InterfaceC0041z interfaceC0041z, com.bytedance.adsdk.lottie.model.layer.dl dlVar, com.bytedance.adsdk.lottie.a.uy uyVar) {
        this.z = interfaceC0041z;
        z<Integer, Integer> zVarZ = uyVar.z().z();
        this.g = zVarZ;
        zVarZ.z(this);
        dlVar.z(zVarZ);
        z<Float, Float> zVarZ2 = uyVar.g().z();
        this.dl = zVarZ2;
        zVarZ2.z(this);
        dlVar.z(zVarZ2);
        z<Float, Float> zVarZ3 = uyVar.dl().z();
        this.f194a = zVarZ3;
        zVarZ3.z(this);
        dlVar.z(zVarZ3);
        z<Float, Float> zVarZ4 = uyVar.a().z();
        this.gc = zVarZ4;
        zVarZ4.z(this);
        dlVar.z(zVarZ4);
        z<Float, Float> zVarZ5 = uyVar.gc().z();
        this.m = zVarZ5;
        zVarZ5.z(this);
        dlVar.z(zVarZ5);
    }

    @Override // com.bytedance.adsdk.lottie.z.g.z.InterfaceC0041z
    public void z() {
        this.e = true;
        this.z.z();
    }

    public void z(Paint paint) {
        if (this.e) {
            this.e = false;
            double dFloatValue = ((double) this.f194a.e().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.gc.e().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.g.e().intValue();
            paint.setShadowLayer(this.m.e().floatValue(), fSin, fCos, Color.argb(Math.round(this.dl.e().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
