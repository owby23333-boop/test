package com.bytedance.sdk.component.dl.z;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class p extends m {
    final transient int[] e;
    final transient byte[][] m;

    p(dl dlVar, int i) {
        super(null);
        q.z(dlVar.g, 0L, i);
        pf pfVar = dlVar.z;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (pfVar.dl == pfVar.g) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += pfVar.dl - pfVar.g;
            i4++;
            pfVar = pfVar.m;
        }
        this.m = new byte[i4][];
        this.e = new int[i4 * 2];
        pf pfVar2 = dlVar.z;
        int i5 = 0;
        while (i2 < i) {
            this.m[i5] = pfVar2.z;
            i2 += pfVar2.dl - pfVar2.g;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.e;
            iArr[i5] = i2;
            iArr[this.m.length + i5] = pfVar2.g;
            pfVar2.f696a = true;
            i5++;
            pfVar2 = pfVar2.m;
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public String z() {
        return fo().z();
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public String g() {
        return fo().g();
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public String gc() {
        return fo().gc();
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public m m() {
        return fo().m();
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public m dl() {
        return fo().dl();
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public m a() {
        return fo().a();
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public m z(int i, int i2) {
        return fo().z(i, i2);
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public byte z(int i) {
        q.z(this.e[this.m.length - 1], i, 1L);
        int iG = g(i);
        int i2 = iG == 0 ? 0 : this.e[iG - 1];
        int[] iArr = this.e;
        byte[][] bArr = this.m;
        return bArr[iG][(i - i2) + iArr[bArr.length + iG]];
    }

    private int g(int i) {
        int iBinarySearch = Arrays.binarySearch(this.e, 0, this.m.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public int e() {
        return this.e[this.m.length - 1];
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public byte[] gz() {
        int[] iArr = this.e;
        byte[][] bArr = this.m;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.e;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.m[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    void z(dl dlVar) {
        int length = this.m.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.e;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            pf pfVar = new pf(this.m[i], i3, (i3 + i4) - i2, true, false);
            if (dlVar.z == null) {
                pfVar.e = pfVar;
                pfVar.m = pfVar;
                dlVar.z = pfVar;
            } else {
                dlVar.z.e.z(pfVar);
            }
            i++;
            i2 = i4;
        }
        dlVar.g += (long) i2;
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public boolean z(int i, m mVar, int i2, int i3) {
        if (i < 0 || i > e() - i3) {
            return false;
        }
        int iG = g(i);
        while (i3 > 0) {
            int i4 = iG == 0 ? 0 : this.e[iG - 1];
            int iMin = Math.min(i3, ((this.e[iG] - i4) + i4) - i);
            int[] iArr = this.e;
            byte[][] bArr = this.m;
            if (!mVar.z(i2, bArr[iG], (i - i4) + iArr[bArr.length + iG], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iG++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public boolean z(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > e() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iG = g(i);
        while (i3 > 0) {
            int i4 = iG == 0 ? 0 : this.e[iG - 1];
            int iMin = Math.min(i3, ((this.e[iG] - i4) + i4) - i);
            int[] iArr = this.e;
            byte[][] bArr2 = this.m;
            if (!q.z(bArr2[iG], (i - i4) + iArr[bArr2.length + iG], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iG++;
        }
        return true;
    }

    private m fo() {
        return new m(gz());
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.e() == e() && z(0, mVar, 0, e())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public int hashCode() {
        int i = this.f695a;
        if (i != 0) {
            return i;
        }
        int length = this.m.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.m[i2];
            int[] iArr = this.e;
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
        this.f695a = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.dl.z.m
    public String toString() {
        return fo().toString();
    }
}
