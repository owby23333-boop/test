package com.google.zxing.qrcode.detector;

import com.google.zxing.i;

/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f16361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16362d;

    d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f16361c);
        return fAbs <= 1.0f || fAbs <= this.f16361c;
    }

    d b(float f2, float f3, float f4) {
        int i2 = this.f16362d;
        int i3 = i2 + 1;
        float fA = (i2 * a()) + f3;
        float f5 = i3;
        return new d(fA / f5, ((this.f16362d * b()) + f2) / f5, ((this.f16362d * this.f16361c) + f4) / f5, i3);
    }

    int c() {
        return this.f16362d;
    }

    public float d() {
        return this.f16361c;
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f16361c = f4;
        this.f16362d = i2;
    }
}
