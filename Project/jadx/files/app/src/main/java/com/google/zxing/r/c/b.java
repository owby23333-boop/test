package com.google.zxing.r.c;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: ByteMatrix.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final byte[][] a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16364c;

    public b(int i2, int i3) {
        this.a = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, i2);
        this.b = i2;
        this.f16364c = i3;
    }

    public byte a(int i2, int i3) {
        return this.a[i3][i2];
    }

    public int b() {
        return this.f16364c;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.f16364c) + 2);
        for (int i2 = 0; i2 < this.f16364c; i2++) {
            byte[] bArr = this.a[i2];
            for (int i3 = 0; i3 < this.b; i3++) {
                byte b = bArr[i3];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte[][] a() {
        return this.a;
    }

    public void a(int i2, int i3, int i4) {
        this.a[i3][i2] = (byte) i4;
    }

    public void a(int i2, int i3, boolean z2) {
        this.a[i3][i2] = z2 ? (byte) 1 : (byte) 0;
    }

    public void a(byte b) {
        for (byte[] bArr : this.a) {
            Arrays.fill(bArr, b);
        }
    }
}
