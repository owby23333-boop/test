package com.google.zxing.qrcode.detector;

import com.google.zxing.i;

/* JADX INFO: compiled from: AlignmentPattern.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f16353c;

    a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f16353c = f4;
    }

    boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f16353c);
        return fAbs <= 1.0f || fAbs <= this.f16353c;
    }

    a b(float f2, float f3, float f4) {
        return new a((a() + f3) / 2.0f, (b() + f2) / 2.0f, (this.f16353c + f4) / 2.0f);
    }
}
