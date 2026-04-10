package com.google.zxing.pdf417.decoder.j;

/* JADX INFO: compiled from: ModulusGF.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f16311f = new b(929, 3);
    private final int[] a;
    private final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f16312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f16313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16314e;

    private b(int i2, int i3) {
        this.f16314e = i2;
        this.a = new int[i2];
        this.b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.a[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.b[this.a[i6]] = i6;
        }
        this.f16312c = new c(this, new int[]{0});
        this.f16313d = new c(this, new int[]{1});
    }

    c a() {
        return this.f16313d;
    }

    c b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f16312c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new c(this, iArr);
    }

    c c() {
        return this.f16312c;
    }

    int d(int i2, int i3) {
        int i4 = this.f16314e;
        return ((i2 + i4) - i3) % i4;
    }

    int a(int i2, int i3) {
        return (i2 + i3) % this.f16314e;
    }

    int c(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    int a(int i2) {
        return this.a[i2];
    }

    int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f16314e - 1)];
    }

    int b(int i2) {
        if (i2 != 0) {
            return this.a[(this.f16314e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    int b() {
        return this.f16314e;
    }
}
