package com.google.zxing.pdf417.decoder.j;

/* JADX INFO: compiled from: ModulusPoly.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    private final b a;
    private final int[] b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.b = new int[]{0};
            return;
        }
        this.b = new int[length - i2];
        int[] iArr2 = this.b;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    int a() {
        return this.b.length - 1;
    }

    boolean b() {
        return this.b[0] == 0;
    }

    c c(c cVar) {
        if (this.a.equals(cVar.a)) {
            return cVar.b() ? this : a(cVar.c());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a() * 8);
        for (int iA = a(); iA >= 0; iA--) {
            int iB = b(iA);
            if (iB != 0) {
                if (iB < 0) {
                    sb.append(" - ");
                    iB = -iB;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iA == 0 || iB != 1) {
                    sb.append(iB);
                }
                if (iA != 0) {
                    if (iA == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iA);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i2) {
        if (i2 == 0) {
            return b(0);
        }
        if (i2 == 1) {
            int iA = 0;
            for (int i3 : this.b) {
                iA = this.a.a(iA, i3);
            }
            return iA;
        }
        int[] iArr = this.b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i4 = 1; i4 < length; i4++) {
            b bVar = this.a;
            iA2 = bVar.a(bVar.c(i2, iA2), this.b[i4]);
        }
        return iA2;
    }

    int b(int i2) {
        return this.b[(r0.length - 1) - i2];
    }

    c b(c cVar) {
        if (this.a.equals(cVar.a)) {
            if (!b() && !cVar.b()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = cVar.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i2 + i4;
                        b bVar = this.a;
                        iArr3[i5] = bVar.a(iArr3[i5], bVar.c(i3, iArr2[i4]));
                    }
                }
                return new c(this.a, iArr3);
            }
            return this.a.c();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    c c() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.d(0, this.b[i2]);
        }
        return new c(this.a, iArr);
    }

    c a(c cVar) {
        if (this.a.equals(cVar.a)) {
            if (b()) {
                return cVar;
            }
            if (cVar.b()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = cVar.b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr3[i2] = this.a.a(iArr[i2 - length], iArr2[i2]);
            }
            return new c(this.a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    c c(int i2) {
        if (i2 == 0) {
            return this.a.c();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.c(this.b[i3], i2);
        }
        return new c(this.a, iArr);
    }

    c a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.a.c();
        }
        int length = this.b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.a.c(this.b[i4], i3);
        }
        return new c(this.a, iArr);
    }
}
