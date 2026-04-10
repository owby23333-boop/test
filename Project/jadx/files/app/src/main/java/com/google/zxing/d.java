package com.google.zxing;

/* JADX INFO: compiled from: LuminanceSource.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    private final int a;
    private final int b;

    protected d(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final int a() {
        return this.b;
    }

    public abstract byte[] a(int i2, byte[] bArr);

    public abstract byte[] b();

    public final int c() {
        return this.a;
    }

    public d d() {
        return new c(this);
    }

    public boolean e() {
        return false;
    }

    public d f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i2 = this.a;
        StringBuilder sb = new StringBuilder(this.b * (i2 + 1));
        byte[] bArrA = new byte[i2];
        for (int i3 = 0; i3 < this.b; i3++) {
            bArrA = a(i3, bArrA);
            for (int i4 = 0; i4 < this.a; i4++) {
                int i5 = bArrA[i4] & 255;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
