package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class bf {
    public String bf;
    public PointF bh;
    public float d;
    public String e;
    public int ga;
    public float m;
    public float p;
    public e tg;

    @ColorInt
    public int v;
    public float vn;
    public boolean wu;
    public PointF xu;

    @ColorInt
    public int zk;

    public enum e {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public bf(String str, String str2, float f, e eVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        e(str, str2, f, eVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public void e(String str, String str2, float f, e eVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.e = str;
        this.bf = str2;
        this.d = f;
        this.tg = eVar;
        this.ga = i;
        this.vn = f2;
        this.p = f3;
        this.v = i2;
        this.zk = i3;
        this.m = f4;
        this.wu = z;
        this.xu = pointF;
        this.bh = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.e.hashCode() * 31) + this.bf.hashCode()) * 31) + this.d)) * 31) + this.tg.ordinal()) * 31) + this.ga;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.vn);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.v;
    }

    public bf() {
    }
}
