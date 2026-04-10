package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: DecodedNumeric.java */
/* JADX INFO: loaded from: classes2.dex */
final class o extends p {
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16227c;

    o(int i2, int i3, int i4) throws FormatException {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw FormatException.f();
        }
        this.b = i3;
        this.f16227c = i4;
    }

    int b() {
        return this.b;
    }

    int c() {
        return this.f16227c;
    }

    boolean d() {
        return this.b == 10;
    }

    boolean e() {
        return this.f16227c == 10;
    }
}
