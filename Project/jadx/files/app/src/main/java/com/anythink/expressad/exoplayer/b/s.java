package com.anythink.expressad.exoplayer.b;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class s {
    private static final int a = 65;
    private static final int b = 400;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8668c = 4000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f8671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f8672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f8673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f8674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f8675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f8676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final short[] f8677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private short[] f8678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private short[] f8680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8681p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private short[] f8682q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f8683r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8684s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8685t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f8686u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8687v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8688w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f8689x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f8690y;

    public s(int i2, int i3, float f2, float f3, int i4) {
        this.f8669d = i2;
        this.f8670e = i3;
        this.f8671f = f2;
        this.f8672g = f3;
        this.f8673h = i2 / i4;
        this.f8674i = i2 / 400;
        this.f8675j = i2 / 65;
        this.f8676k = this.f8675j * 2;
        int i5 = this.f8676k;
        this.f8677l = new short[i5];
        this.f8678m = new short[i5 * i3];
        this.f8680o = new short[i5 * i3];
        this.f8682q = new short[i5 * i3];
    }

    private void d(int i2) {
        if (i2 == 0) {
            return;
        }
        short[] sArr = this.f8682q;
        int i3 = this.f8670e;
        System.arraycopy(sArr, i2 * i3, sArr, 0, (this.f8683r - i2) * i3);
        this.f8683r -= i2;
    }

    public final void a(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i2 = this.f8670e;
        int i3 = iRemaining / i2;
        this.f8678m = a(this.f8678m, this.f8679n, i3);
        shortBuffer.get(this.f8678m, this.f8679n * this.f8670e, ((i2 * i3) * 2) / 2);
        this.f8679n += i3;
        d();
    }

    public final void b(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f8670e, this.f8681p);
        shortBuffer.put(this.f8680o, 0, this.f8670e * iMin);
        this.f8681p -= iMin;
        short[] sArr = this.f8680o;
        int i2 = this.f8670e;
        System.arraycopy(sArr, iMin * i2, sArr, 0, this.f8681p * i2);
    }

    public final int c() {
        return this.f8681p;
    }

    private void c(short[] sArr, int i2, int i3) {
        int i4 = this.f8676k / i3;
        int i5 = this.f8670e;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f8677l[i8] = (short) (i9 / i6);
        }
    }

    private void d() {
        int i2 = this.f8681p;
        float f2 = this.f8671f;
        float f3 = this.f8672g;
        float f4 = f2 / f3;
        float f5 = this.f8673h * f3;
        double d2 = f4;
        if (d2 <= 1.00001d && d2 >= 0.99999d) {
            b(this.f8678m, 0, this.f8679n);
            this.f8679n = 0;
        } else {
            a(f4);
        }
        if (f5 != 1.0f) {
            a(f5, i2);
        }
    }

    public final void b() {
        this.f8679n = 0;
        this.f8681p = 0;
        this.f8683r = 0;
        this.f8684s = 0;
        this.f8685t = 0;
        this.f8686u = 0;
        this.f8687v = 0;
        this.f8688w = 0;
        this.f8689x = 0;
        this.f8690y = 0;
    }

    public final void a() {
        int i2;
        int i3 = this.f8679n;
        float f2 = this.f8671f;
        float f3 = this.f8672g;
        int i4 = this.f8681p + ((int) ((((i3 / (f2 / f3)) + this.f8683r) / (this.f8673h * f3)) + 0.5f));
        this.f8678m = a(this.f8678m, i3, (this.f8676k * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f8676k;
            int i6 = this.f8670e;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.f8678m[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.f8679n += i2 * 2;
        d();
        if (this.f8681p > i4) {
            this.f8681p = i4;
        }
        this.f8679n = 0;
        this.f8686u = 0;
        this.f8683r = 0;
    }

    private void c(int i2) {
        int i3 = this.f8681p - i2;
        this.f8682q = a(this.f8682q, this.f8683r, i3);
        short[] sArr = this.f8680o;
        int i4 = this.f8670e;
        System.arraycopy(sArr, i2 * i4, this.f8682q, this.f8683r * i4, i4 * i3);
        this.f8681p = i2;
        this.f8683r += i3;
    }

    private void b(short[] sArr, int i2, int i3) {
        this.f8680o = a(this.f8680o, this.f8681p, i3);
        int i4 = this.f8670e;
        System.arraycopy(sArr, i2 * i4, this.f8680o, this.f8681p * i4, i4 * i3);
        this.f8681p += i3;
    }

    private int b(int i2) {
        int iMin = Math.min(this.f8676k, this.f8686u);
        b(this.f8678m, i2, iMin);
        this.f8686u -= iMin;
        return iMin;
    }

    private short[] a(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.f8670e;
        int i5 = length / i4;
        return i2 + i3 <= i5 ? sArr : Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    private short b(short[] sArr, int i2, int i3, int i4) {
        short s2 = sArr[i2];
        short s3 = sArr[i2 + this.f8670e];
        int i5 = this.f8685t * i3;
        int i6 = this.f8684s;
        int i7 = i6 * i4;
        int i8 = (i6 + 1) * i4;
        int i9 = i8 - i5;
        int i10 = i8 - i7;
        return (short) (((s2 * i9) + ((i10 - i9) * s3)) / i10);
    }

    private void a(int i2) {
        int i3 = this.f8679n - i2;
        short[] sArr = this.f8678m;
        int i4 = this.f8670e;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.f8679n = i3;
    }

    private int b(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((i3 * f2) / (1.0f - f2));
        } else {
            this.f8686u = (int) ((i3 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        int i5 = i3 + i4;
        this.f8680o = a(this.f8680o, this.f8681p, i5);
        int i6 = this.f8670e;
        System.arraycopy(sArr, i2 * i6, this.f8680o, this.f8681p * i6, i6 * i3);
        a(i4, this.f8670e, this.f8680o, this.f8681p + i3, sArr, i2 + i3, sArr, i2);
        this.f8681p += i5;
        return i4;
    }

    private int a(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f8670e;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 255;
        while (i3 <= i4) {
            int iAbs = 0;
            for (int i10 = 0; i10 < i3; i10++) {
                iAbs += Math.abs(sArr[i5 + i10] - sArr[(i5 + i3) + i10]);
            }
            if (iAbs * i7 < i6 * i3) {
                i7 = i3;
                i6 = iAbs;
            }
            if (iAbs * i9 > i8 * i3) {
                i9 = i3;
                i8 = iAbs;
            }
            i3++;
        }
        this.f8689x = i6 / i7;
        this.f8690y = i8 / i9;
        return i7;
    }

    private boolean a(int i2, int i3) {
        return i2 != 0 && this.f8687v != 0 && i3 <= i2 * 3 && i2 * 2 > this.f8688w * 3;
    }

    private int a(short[] sArr, int i2) {
        int iA;
        int i3 = this.f8669d;
        int i4 = i3 > f8668c ? i3 / f8668c : 1;
        boolean z2 = false;
        if (this.f8670e == 1 && i4 == 1) {
            iA = a(sArr, i2, this.f8674i, this.f8675j);
        } else {
            c(sArr, i2, i4);
            int iA2 = a(this.f8677l, 0, this.f8674i / i4, this.f8675j / i4);
            if (i4 != 1) {
                int i5 = iA2 * i4;
                int i6 = i4 * 4;
                int i7 = i5 - i6;
                int i8 = i5 + i6;
                int i9 = this.f8674i;
                if (i7 >= i9) {
                    i9 = i7;
                }
                int i10 = this.f8675j;
                if (i8 > i10) {
                    i8 = i10;
                }
                if (this.f8670e == 1) {
                    iA = a(sArr, i2, i9, i8);
                } else {
                    c(sArr, i2, 1);
                    iA = a(this.f8677l, 0, i9, i8);
                }
            } else {
                iA = iA2;
            }
        }
        int i11 = this.f8689x;
        int i12 = this.f8690y;
        if (i11 != 0 && this.f8687v != 0 && i12 <= i11 * 3 && i11 * 2 > this.f8688w * 3) {
            z2 = true;
        }
        int i13 = z2 ? this.f8687v : iA;
        this.f8688w = this.f8689x;
        this.f8687v = iA;
        return i13;
    }

    private void a(float f2, int i2) {
        int i3;
        int i4;
        int i5;
        if (this.f8681p == i2) {
            return;
        }
        int i6 = this.f8669d;
        int i7 = (int) (i6 / f2);
        while (true) {
            if (i7 <= 16384 && i6 <= 16384) {
                break;
            }
            i7 /= 2;
            i6 /= 2;
        }
        int i8 = this.f8681p - i2;
        this.f8682q = a(this.f8682q, this.f8683r, i8);
        short[] sArr = this.f8680o;
        int i9 = this.f8670e;
        System.arraycopy(sArr, i2 * i9, this.f8682q, this.f8683r * i9, i9 * i8);
        this.f8681p = i2;
        this.f8683r += i8;
        int i10 = 0;
        while (true) {
            i3 = this.f8683r;
            if (i10 >= i3 - 1) {
                break;
            }
            while (true) {
                i4 = this.f8684s;
                int i11 = (i4 + 1) * i7;
                i5 = this.f8685t;
                if (i11 <= i5 * i6) {
                    break;
                }
                this.f8680o = a(this.f8680o, this.f8681p, 1);
                int i12 = 0;
                while (true) {
                    int i13 = this.f8670e;
                    if (i12 < i13) {
                        short[] sArr2 = this.f8680o;
                        int i14 = (this.f8681p * i13) + i12;
                        short[] sArr3 = this.f8682q;
                        int i15 = (i10 * i13) + i12;
                        short s2 = sArr3[i15];
                        short s3 = sArr3[i15 + i13];
                        int i16 = this.f8685t * i6;
                        int i17 = this.f8684s;
                        int i18 = i17 * i7;
                        int i19 = (i17 + 1) * i7;
                        int i20 = i19 - i16;
                        int i21 = i19 - i18;
                        sArr2[i14] = (short) (((s2 * i20) + ((i21 - i20) * s3)) / i21);
                        i12++;
                    }
                }
                this.f8685t++;
                this.f8681p++;
            }
            this.f8684s = i4 + 1;
            if (this.f8684s == i6) {
                this.f8684s = 0;
                com.anythink.expressad.exoplayer.k.a.b(i5 == i7);
                this.f8685t = 0;
            }
            i10++;
        }
        int i22 = i3 - 1;
        if (i22 != 0) {
            short[] sArr4 = this.f8682q;
            int i23 = this.f8670e;
            System.arraycopy(sArr4, i22 * i23, sArr4, 0, (i3 - i22) * i23);
            this.f8683r -= i22;
        }
    }

    private int a(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (i3 / (f2 - 1.0f));
        } else {
            this.f8686u = (int) ((i3 * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        this.f8680o = a(this.f8680o, this.f8681p, i4);
        a(i4, this.f8670e, this.f8680o, this.f8681p, sArr, i2, sArr, i2 + i3);
        this.f8681p += i4;
        return i4;
    }

    private void a(float f2) {
        int iA;
        int i2;
        int i3;
        int i4 = this.f8679n;
        if (i4 < this.f8676k) {
            return;
        }
        int i5 = 0;
        do {
            int i6 = this.f8686u;
            if (i6 > 0) {
                int iMin = Math.min(this.f8676k, i6);
                b(this.f8678m, i5, iMin);
                this.f8686u -= iMin;
                i5 += iMin;
            } else {
                short[] sArr = this.f8678m;
                int i7 = this.f8669d;
                int i8 = i7 > f8668c ? i7 / f8668c : 1;
                if (this.f8670e == 1 && i8 == 1) {
                    iA = a(sArr, i5, this.f8674i, this.f8675j);
                } else {
                    c(sArr, i5, i8);
                    int iA2 = a(this.f8677l, 0, this.f8674i / i8, this.f8675j / i8);
                    if (i8 != 1) {
                        int i9 = iA2 * i8;
                        int i10 = i8 * 4;
                        int i11 = i9 - i10;
                        int i12 = i9 + i10;
                        int i13 = this.f8674i;
                        if (i11 >= i13) {
                            i13 = i11;
                        }
                        int i14 = this.f8675j;
                        if (i12 > i14) {
                            i12 = i14;
                        }
                        if (this.f8670e == 1) {
                            iA = a(sArr, i5, i13, i12);
                        } else {
                            c(sArr, i5, 1);
                            iA = a(this.f8677l, 0, i13, i12);
                        }
                    } else {
                        iA = iA2;
                    }
                }
                int i15 = this.f8689x;
                int i16 = i15 != 0 && this.f8687v != 0 && this.f8690y <= i15 * 3 && i15 * 2 > this.f8688w * 3 ? this.f8687v : iA;
                this.f8688w = this.f8689x;
                this.f8687v = iA;
                if (f2 > 1.0d) {
                    short[] sArr2 = this.f8678m;
                    if (f2 >= 2.0f) {
                        i3 = (int) (i16 / (f2 - 1.0f));
                    } else {
                        this.f8686u = (int) ((i16 * (2.0f - f2)) / (f2 - 1.0f));
                        i3 = i16;
                    }
                    this.f8680o = a(this.f8680o, this.f8681p, i3);
                    a(i3, this.f8670e, this.f8680o, this.f8681p, sArr2, i5, sArr2, i5 + i16);
                    this.f8681p += i3;
                    i5 += i16 + i3;
                } else {
                    short[] sArr3 = this.f8678m;
                    if (f2 < 0.5f) {
                        i2 = (int) ((i16 * f2) / (1.0f - f2));
                    } else {
                        this.f8686u = (int) ((i16 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                        i2 = i16;
                    }
                    int i17 = i16 + i2;
                    this.f8680o = a(this.f8680o, this.f8681p, i17);
                    int i18 = this.f8670e;
                    System.arraycopy(sArr3, i5 * i18, this.f8680o, this.f8681p * i18, i18 * i16);
                    a(i2, this.f8670e, this.f8680o, this.f8681p + i16, sArr3, i5 + i16, sArr3, i5);
                    this.f8681p += i17;
                    i5 += i2;
                }
            }
        } while (this.f8676k + i5 <= i4);
        int i19 = this.f8679n - i5;
        short[] sArr4 = this.f8678m;
        int i20 = this.f8670e;
        System.arraycopy(sArr4, i5 * i20, sArr4, 0, i20 * i19);
        this.f8679n = i19;
    }

    private static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i5 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i4 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i10] = (short) (((sArr2[i8] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i10 += i3;
                i8 += i3;
                i9 += i3;
            }
        }
    }
}
