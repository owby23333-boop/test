package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: compiled from: BitMatrix.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f16145s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f16146t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f16147u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int[] f16148v;

    public b(int i2) {
        this(i2, i2);
    }

    public void a(int i2, int i3) {
        int i4 = (i3 * this.f16147u) + (i2 / 32);
        int[] iArr = this.f16148v;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean b(int i2, int i3) {
        return ((this.f16148v[(i3 * this.f16147u) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public void c(int i2, int i3) {
        int i4 = (i3 * this.f16147u) + (i2 / 32);
        int[] iArr = this.f16148v;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public int[] d() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f16148v;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        int[] iArr2 = this.f16148v;
        if (i2 == iArr2.length) {
            return null;
        }
        int i3 = this.f16147u;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr2[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public int e() {
        return this.f16145s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f16145s == bVar.f16145s && this.f16146t == bVar.f16146t && this.f16147u == bVar.f16147u && Arrays.equals(this.f16148v, bVar.f16148v);
    }

    public void f() {
        int iE = e();
        int iC = c();
        a aVar = new a(iE);
        a aVar2 = new a(iE);
        for (int i2 = 0; i2 < (iC + 1) / 2; i2++) {
            aVar = a(i2, aVar);
            int i3 = (iC - 1) - i2;
            aVar2 = a(i3, aVar2);
            aVar.e();
            aVar2.e();
            b(i2, aVar2);
            b(i3, aVar);
        }
    }

    public int hashCode() {
        int i2 = this.f16145s;
        return (((((((i2 * 31) + i2) * 31) + this.f16146t) * 31) + this.f16147u) * 31) + Arrays.hashCode(this.f16148v);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f16145s = i2;
        this.f16146t = i3;
        this.f16147u = (i2 + 31) / 32;
        this.f16148v = new int[this.f16147u * i3];
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public b m64clone() {
        return new b(this.f16145s, this.f16146t, this.f16147u, (int[]) this.f16148v.clone());
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 > 0 && i4 > 0) {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.f16146t || i6 > this.f16145s) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f16147u * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f16148v;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public void b(int i2, a aVar) {
        int[] iArrB = aVar.b();
        int[] iArr = this.f16148v;
        int i3 = this.f16147u;
        System.arraycopy(iArrB, 0, iArr, i2 * i3, i3);
    }

    public int c() {
        return this.f16146t;
    }

    public int[] b() {
        int i2 = this.f16145s;
        int i3 = -1;
        int i4 = this.f16146t;
        int i5 = -1;
        int i6 = i2;
        int i7 = 0;
        while (i7 < this.f16146t) {
            int i8 = i5;
            int i9 = i3;
            int i10 = i6;
            int i11 = 0;
            while (true) {
                int i12 = this.f16147u;
                if (i11 < i12) {
                    int i13 = this.f16148v[(i12 * i7) + i11];
                    if (i13 != 0) {
                        if (i7 < i4) {
                            i4 = i7;
                        }
                        if (i7 > i8) {
                            i8 = i7;
                        }
                        int i14 = i11 << 5;
                        int i15 = 31;
                        if (i14 < i10) {
                            int i16 = 0;
                            while ((i13 << (31 - i16)) == 0) {
                                i16++;
                            }
                            int i17 = i16 + i14;
                            if (i17 < i10) {
                                i10 = i17;
                            }
                        }
                        if (i14 + 31 > i9) {
                            while ((i13 >>> i15) == 0) {
                                i15--;
                            }
                            int i18 = i14 + i15;
                            if (i18 > i9) {
                                i9 = i18;
                            }
                        }
                    }
                    i11++;
                }
            }
            i7++;
            i6 = i10;
            i3 = i9;
            i5 = i8;
        }
        if (i3 < i6 || i5 < i4) {
            return null;
        }
        return new int[]{i6, i4, (i3 - i6) + 1, (i5 - i4) + 1};
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.f16145s = i2;
        this.f16146t = i3;
        this.f16147u = i4;
        this.f16148v = iArr;
    }

    public a a(int i2, a aVar) {
        if (aVar != null && aVar.c() >= this.f16145s) {
            aVar.a();
        } else {
            aVar = new a(this.f16145s);
        }
        int i3 = i2 * this.f16147u;
        for (int i4 = 0; i4 < this.f16147u; i4++) {
            aVar.b(i4 << 5, this.f16148v[i3 + i4]);
        }
        return aVar;
    }

    public int[] a() {
        int length = this.f16148v.length - 1;
        while (length >= 0 && this.f16148v[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f16147u;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f16148v[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f16146t * (this.f16145s + 1));
        for (int i2 = 0; i2 < this.f16146t; i2++) {
            for (int i3 = 0; i3 < this.f16145s; i3++) {
                sb.append(b(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
