package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f163a;
    public float dl;
    public float e;
    public int fo;
    public String g;
    public int gc;
    public int gz;
    public PointF i;
    public boolean kb;
    public float m;
    public float uy;
    public PointF wp;
    public String z;

    public enum z {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public g(String str, String str2, float f, z zVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z2, PointF pointF, PointF pointF2) {
        z(str, str2, f, zVar, i, f2, f3, i2, i3, f4, z2, pointF, pointF2);
    }

    public g() {
    }

    public void z(String str, String str2, float f, z zVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z2, PointF pointF, PointF pointF2) {
        this.z = str;
        this.g = str2;
        this.dl = f;
        this.f163a = zVar;
        this.gc = i;
        this.m = f2;
        this.e = f3;
        this.gz = i2;
        this.fo = i3;
        this.uy = f4;
        this.kb = z2;
        this.wp = pointF;
        this.i = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.z.hashCode() * 31) + this.g.hashCode()) * 31) + this.dl)) * 31) + this.f163a.ordinal()) * 31) + this.gc;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.m);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.gz;
    }
}
