package com.google.zxing.common;

/* JADX INFO: compiled from: PerspectiveTransform.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private final float a;
    private final float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f16159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f16160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f16161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f16162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f16163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f16164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f16165i;

    private j(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a = f2;
        this.b = f5;
        this.f16159c = f8;
        this.f16160d = f3;
        this.f16161e = f6;
        this.f16162f = f9;
        this.f16163g = f4;
        this.f16164h = f7;
        this.f16165i = f10;
    }

    public static j a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return b(f10, f11, f12, f13, f14, f15, f16, f17).a(a(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public static j b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new j(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new j((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    public void a(float[] fArr) {
        int length = fArr.length;
        float f2 = this.a;
        float f3 = this.b;
        float f4 = this.f16159c;
        float f5 = this.f16160d;
        float f6 = this.f16161e;
        float f7 = this.f16162f;
        float f8 = this.f16163g;
        float f9 = this.f16164h;
        float f10 = this.f16165i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr[i2];
            int i3 = i2 + 1;
            float f12 = fArr[i3];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr[i2] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr[i3] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }

    public static j a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return b(f2, f3, f4, f5, f6, f7, f8, f9).a();
    }

    j a() {
        float f2 = this.f16161e;
        float f3 = this.f16165i;
        float f4 = this.f16162f;
        float f5 = this.f16164h;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = this.f16163g;
        float f8 = this.f16160d;
        float f9 = (f4 * f7) - (f8 * f3);
        float f10 = (f8 * f5) - (f2 * f7);
        float f11 = this.f16159c;
        float f12 = this.b;
        float f13 = (f11 * f5) - (f12 * f3);
        float f14 = this.a;
        return new j(f6, f9, f10, f13, (f3 * f14) - (f11 * f7), (f7 * f12) - (f5 * f14), (f12 * f4) - (f11 * f2), (f11 * f8) - (f4 * f14), (f14 * f2) - (f12 * f8));
    }

    j a(j jVar) {
        float f2 = this.a;
        float f3 = jVar.a;
        float f4 = this.f16160d;
        float f5 = jVar.b;
        float f6 = this.f16163g;
        float f7 = jVar.f16159c;
        float f8 = (f2 * f3) + (f4 * f5) + (f6 * f7);
        float f9 = jVar.f16160d;
        float f10 = jVar.f16161e;
        float f11 = jVar.f16162f;
        float f12 = (f2 * f9) + (f4 * f10) + (f6 * f11);
        float f13 = jVar.f16163g;
        float f14 = jVar.f16164h;
        float f15 = jVar.f16165i;
        float f16 = (f2 * f13) + (f4 * f14) + (f6 * f15);
        float f17 = this.b;
        float f18 = this.f16161e;
        float f19 = this.f16164h;
        float f20 = (f17 * f3) + (f18 * f5) + (f19 * f7);
        float f21 = (f17 * f9) + (f18 * f10) + (f19 * f11);
        float f22 = (f19 * f15) + (f17 * f13) + (f18 * f14);
        float f23 = this.f16159c;
        float f24 = this.f16162f;
        float f25 = (f3 * f23) + (f5 * f24);
        float f26 = this.f16165i;
        return new j(f8, f12, f16, f20, f21, f22, (f7 * f26) + f25, (f9 * f23) + (f10 * f24) + (f11 * f26), (f23 * f13) + (f24 * f14) + (f26 * f15));
    }
}
