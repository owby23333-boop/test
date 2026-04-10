package com.yuewen;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;

/* JADX INFO: loaded from: classes5.dex */
public class i13 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12332b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final int g = 32;
    public static final int h = 64;
    public static final int i = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12333a = TsExtractor.TS_STREAM_TYPE_AC3;

    public final void a(int i2) {
        if (i2 == 0) {
            return;
        }
        int i3 = this.f12333a | i2;
        this.f12333a = i3;
        if ((i2 & 1) == 1) {
            this.f12333a = i3 & (-5) & (-33) & (-9);
        }
        if ((i2 & 2) == 2) {
            this.f12333a &= -2;
        }
        if ((i2 & 4) == 4) {
            this.f12333a = this.f12333a & (-2) & (-17) & (-9) & (-65);
        }
        if ((i2 & 8) == 8) {
            this.f12333a = this.f12333a & (-2) & (-5) & (-17) & (-65);
        }
        if ((i2 & 16) == 16) {
            this.f12333a = this.f12333a & (-5) & (-9);
        }
        if ((i2 & 64) == 64) {
            this.f12333a = this.f12333a & (-5) & (-9);
        }
    }

    public boolean b(int i2, int i3) {
        int i4 = this.f12333a;
        a(i2);
        d(i3);
        return this.f12333a != i4;
    }

    public boolean c(int i2) {
        return (this.f12333a & i2) == i2;
    }

    public final void d(int i2) {
        if (i2 == 0) {
            return;
        }
        this.f12333a = (~i2) & this.f12333a;
        if (c(4) || c(8) || c(2)) {
            return;
        }
        a(1);
    }

    public int e() {
        return this.f12333a;
    }

    public void f(i13 i13Var) {
        this.f12333a = i13Var.f12333a;
    }
}
