package com.bytedance.sdk.component.bf.e.bf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class p extends tg {
    final transient byte[][] p;
    final transient int[] v;

    public p(e eVar, int i) {
        super(null);
        zk.e(eVar.bf, 0L, i);
        ga gaVar = eVar.e;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = gaVar.d;
            int i6 = gaVar.bf;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            gaVar = gaVar.vn;
        }
        this.p = new byte[i4][];
        this.v = new int[i4 * 2];
        ga gaVar2 = eVar.e;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.p;
            bArr[i7] = gaVar2.e;
            int i8 = gaVar2.d;
            int i9 = gaVar2.bf;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.v;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            gaVar2.tg = true;
            i7++;
            gaVar2 = gaVar2.vn;
        }
    }

    private tg ga() {
        return new tg(tg());
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public String bf() {
        return ga().bf();
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public int d() {
        return this.v[this.p.length - 1];
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public String e() {
        return ga().e();
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tg) {
            tg tgVar = (tg) obj;
            if (tgVar.d() == d() && e(0, tgVar, 0, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public int hashCode() {
        int i = this.ga;
        if (i != 0) {
            return i;
        }
        int length = this.p.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.p[i2];
            int[] iArr = this.v;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.ga = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public byte[] tg() {
        int[] iArr = this.v;
        byte[][] bArr = this.p;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.v;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.p[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public String toString() {
        return ga().toString();
    }

    private int bf(int i) {
        int iBinarySearch = Arrays.binarySearch(this.v, 0, this.p.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public tg e(int i, int i2) {
        return ga().e(i, i2);
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public byte e(int i) {
        zk.e(this.v[this.p.length - 1], i, 1L);
        int iBf = bf(i);
        int i2 = iBf == 0 ? 0 : this.v[iBf - 1];
        int[] iArr = this.v;
        byte[][] bArr = this.p;
        return bArr[iBf][(i - i2) + iArr[bArr.length + iBf]];
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public boolean e(int i, tg tgVar, int i2, int i3) {
        if (i < 0 || i > d() - i3) {
            return false;
        }
        int iBf = bf(i);
        while (i3 > 0) {
            int i4 = iBf == 0 ? 0 : this.v[iBf - 1];
            int iMin = Math.min(i3, ((this.v[iBf] - i4) + i4) - i);
            int[] iArr = this.v;
            byte[][] bArr = this.p;
            if (!tgVar.e(i2, bArr[iBf], (i - i4) + iArr[bArr.length + iBf], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iBf++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.bf.e.bf.tg
    public boolean e(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > d() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iBf = bf(i);
        while (i3 > 0) {
            int i4 = iBf == 0 ? 0 : this.v[iBf - 1];
            int iMin = Math.min(i3, ((this.v[iBf] - i4) + i4) - i);
            int[] iArr = this.v;
            byte[][] bArr2 = this.p;
            if (!zk.e(bArr2[iBf], (i - i4) + iArr[bArr2.length + iBf], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iBf++;
        }
        return true;
    }
}
