package com.anythink.expressad.exoplayer.k;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    private static final int a = 32;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f9857c;

    public m() {
        this((byte) 0);
    }

    private void a(long j2) {
        int i2 = this.b;
        long[] jArr = this.f9857c;
        if (i2 == jArr.length) {
            this.f9857c = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f9857c;
        int i3 = this.b;
        this.b = i3 + 1;
        jArr2[i3] = j2;
    }

    private long[] b() {
        return Arrays.copyOf(this.f9857c, this.b);
    }

    private m(byte b) {
        this.f9857c = new long[32];
    }

    private long a(int i2) {
        if (i2 >= 0 && i2 < this.b) {
            return this.f9857c[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.b);
    }

    private int a() {
        return this.b;
    }
}
