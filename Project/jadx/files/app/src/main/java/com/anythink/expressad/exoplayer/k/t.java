package com.anythink.expressad.exoplayer.k;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    private byte[] a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9907d = 0;

    public t(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f9906c = i2;
        this.b = i3;
        g();
    }

    private void a(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f9906c = i2;
        this.b = i3;
        this.f9907d = 0;
        g();
    }

    private boolean c(int i2) {
        int i3 = this.f9906c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f9907d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.b) {
                break;
            }
            if (d(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i7 = this.b;
        if (i5 >= i7) {
            return i5 == i7 && i6 == 0;
        }
        return true;
    }

    private boolean e() {
        int i2 = this.f9906c;
        int i3 = this.f9907d;
        int i4 = 0;
        while (this.f9906c < this.b && !b()) {
            i4++;
        }
        boolean z2 = this.f9906c == this.b;
        this.f9906c = i2;
        this.f9907d = i3;
        if (!z2) {
            int i5 = (i4 * 2) + 1;
            int i6 = this.f9906c;
            int i7 = i5 / 8;
            int i8 = i6 + i7;
            int i9 = (this.f9907d + i5) - (i7 * 8);
            if (i9 > 7) {
                i8++;
                i9 -= 8;
            }
            while (true) {
                i6++;
                if (i6 > i8 || i8 >= this.b) {
                    break;
                }
                if (d(i6)) {
                    i8++;
                    i6 += 2;
                }
            }
            int i10 = this.b;
            if (i8 < i10 || (i8 == i10 && i9 == 0)) {
                return true;
            }
        }
        return false;
    }

    private int f() {
        int i2 = 0;
        while (!b()) {
            i2++;
        }
        return ((1 << i2) - 1) + (i2 > 0 ? b(i2) : 0);
    }

    private void g() {
        int i2;
        int i3 = this.f9906c;
        a.b(i3 >= 0 && (i3 < (i2 = this.b) || (i3 == i2 && this.f9907d == 0)));
    }

    public final boolean b() {
        boolean z2 = (this.a[this.f9906c] & (128 >> this.f9907d)) != 0;
        a();
        return z2;
    }

    public final int d() {
        int iF = f();
        return (iF % 2 == 0 ? -1 : 1) * ((iF + 1) / 2);
    }

    private boolean d(int i2) {
        if (2 > i2 || i2 >= this.b) {
            return false;
        }
        byte[] bArr = this.a;
        return bArr[i2] == 3 && bArr[i2 + (-2)] == 0 && bArr[i2 - 1] == 0;
    }

    public final int b(int i2) {
        int i3;
        this.f9907d += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f9907d;
            if (i3 <= 8) {
                break;
            }
            this.f9907d = i3 - 8;
            byte[] bArr = this.a;
            int i5 = this.f9906c;
            i4 |= (bArr[i5] & 255) << this.f9907d;
            if (!d(i5 + 1)) {
                i = 1;
            }
            this.f9906c = i5 + i;
        }
        byte[] bArr2 = this.a;
        int i6 = this.f9906c;
        int i7 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i6] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f9907d = 0;
            this.f9906c = i6 + (d(i6 + 1) ? 2 : 1);
        }
        g();
        return i7;
    }

    public final void a() {
        int i2 = this.f9907d + 1;
        this.f9907d = i2;
        if (i2 == 8) {
            this.f9907d = 0;
            int i3 = this.f9906c;
            this.f9906c = i3 + (d(i3 + 1) ? 2 : 1);
        }
        g();
    }

    public final int c() {
        return f();
    }

    public final void a(int i2) {
        int i3 = this.f9906c;
        int i4 = i2 / 8;
        this.f9906c = i3 + i4;
        this.f9907d += i2 - (i4 * 8);
        int i5 = this.f9907d;
        if (i5 > 7) {
            this.f9906c++;
            this.f9907d = i5 - 8;
        }
        while (true) {
            i3++;
            if (i3 <= this.f9906c) {
                if (d(i3)) {
                    this.f9906c++;
                    i3 += 2;
                }
            } else {
                g();
                return;
            }
        }
    }
}
