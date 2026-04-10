package com.bytedance.sdk.component.g.z.g;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class gz extends a {
    final transient byte[][] e;
    final transient int[] gz;

    gz(z zVar, int i) {
        super(null);
        uy.z(zVar.g, 0L, i);
        m mVar = zVar.z;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (mVar.dl == mVar.g) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += mVar.dl - mVar.g;
            i4++;
            mVar = mVar.m;
        }
        this.e = new byte[i4][];
        this.gz = new int[i4 * 2];
        m mVar2 = zVar.z;
        int i5 = 0;
        while (i2 < i) {
            this.e[i5] = mVar2.z;
            i2 += mVar2.dl - mVar2.g;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.gz;
            iArr[i5] = i2;
            iArr[this.e.length + i5] = mVar2.g;
            mVar2.f716a = true;
            i5++;
            mVar2 = mVar2.m;
        }
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public String z() {
        return gc().z();
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public String g() {
        return gc().g();
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public a z(int i, int i2) {
        return gc().z(i, i2);
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public byte z(int i) {
        uy.z(this.gz[this.e.length - 1], i, 1L);
        int iG = g(i);
        int i2 = iG == 0 ? 0 : this.gz[iG - 1];
        int[] iArr = this.gz;
        byte[][] bArr = this.e;
        return bArr[iG][(i - i2) + iArr[bArr.length + iG]];
    }

    private int g(int i) {
        int iBinarySearch = Arrays.binarySearch(this.gz, 0, this.e.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public int dl() {
        return this.gz[this.e.length - 1];
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public byte[] a() {
        int[] iArr = this.gz;
        byte[][] bArr = this.e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.gz;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.e[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public boolean z(int i, a aVar, int i2, int i3) {
        if (i < 0 || i > dl() - i3) {
            return false;
        }
        int iG = g(i);
        while (i3 > 0) {
            int i4 = iG == 0 ? 0 : this.gz[iG - 1];
            int iMin = Math.min(i3, ((this.gz[iG] - i4) + i4) - i);
            int[] iArr = this.gz;
            byte[][] bArr = this.e;
            if (!aVar.z(i2, bArr[iG], (i - i4) + iArr[bArr.length + iG], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iG++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public boolean z(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > dl() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iG = g(i);
        while (i3 > 0) {
            int i4 = iG == 0 ? 0 : this.gz[iG - 1];
            int iMin = Math.min(i3, ((this.gz[iG] - i4) + i4) - i);
            int[] iArr = this.gz;
            byte[][] bArr2 = this.e;
            if (!uy.z(bArr2[iG], (i - i4) + iArr[bArr2.length + iG], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iG++;
        }
        return true;
    }

    private a gc() {
        return new a(a());
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.dl() == dl() && z(0, aVar, 0, dl())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public int hashCode() {
        int i = this.gc;
        if (i != 0) {
            return i;
        }
        int length = this.e.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.e[i2];
            int[] iArr = this.gz;
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
        this.gc = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.g.z.g.a
    public String toString() {
        return gc().toString();
    }
}
