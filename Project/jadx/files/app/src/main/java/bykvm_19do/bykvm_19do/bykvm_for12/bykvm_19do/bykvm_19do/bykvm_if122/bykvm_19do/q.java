package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class q extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient byte[][] f882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient int[] f883g;

    q(c cVar, int i2) {
        super(null);
        u.a(cVar.b, 0L, i2);
        int i3 = 0;
        o oVar = cVar.a;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = oVar.f877c;
            int i7 = oVar.b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            oVar = oVar.f880f;
        }
        this.f882f = new byte[i5][];
        this.f883g = new int[i5 * 2];
        o oVar2 = cVar.a;
        int i8 = 0;
        while (i3 < i2) {
            this.f882f[i8] = oVar2.a;
            i3 += oVar2.f877c - oVar2.b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f883g;
            iArr[i8] = i3;
            iArr[this.f882f.length + i8] = oVar2.b;
            oVar2.f878d = true;
            i8++;
            oVar2 = oVar2.f880f;
        }
    }

    private int b(int i2) {
        int iBinarySearch = Arrays.binarySearch(this.f883g, 0, this.f882f.length, i2 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : iBinarySearch ^ (-1);
    }

    private f i() {
        return new f(g());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public byte a(int i2) {
        u.a(this.f883g[this.f882f.length - 1], i2, 1L);
        int iB = b(i2);
        int i3 = iB == 0 ? 0 : this.f883g[iB - 1];
        int[] iArr = this.f883g;
        byte[][] bArr = this.f882f;
        return bArr[iB][(i2 - i3) + iArr[bArr.length + iB]];
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f a(int i2, int i3) {
        return i().a(i2, i3);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String a() {
        return i().a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    void a(c cVar) {
        int length = this.f882f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f883g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            o oVar = new o(this.f882f[i2], i4, (i4 + i5) - i3, true, false);
            o oVar2 = cVar.a;
            if (oVar2 == null) {
                oVar.f881g = oVar;
                oVar.f880f = oVar;
                cVar.a = oVar;
            } else {
                oVar2.f881g.a(oVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.b += (long) i3;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean a(int i2, f fVar, int i3, int i4) {
        if (i2 < 0 || i2 > e() - i4) {
            return false;
        }
        int iB = b(i2);
        while (i4 > 0) {
            int i5 = iB == 0 ? 0 : this.f883g[iB - 1];
            int iMin = Math.min(i4, ((this.f883g[iB] - i5) + i5) - i2);
            int[] iArr = this.f883g;
            byte[][] bArr = this.f882f;
            if (!fVar.a(i3, bArr[iB], (i2 - i5) + iArr[bArr.length + iB], iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iB++;
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > e() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int iB = b(i2);
        while (i4 > 0) {
            int i5 = iB == 0 ? 0 : this.f883g[iB - 1];
            int iMin = Math.min(i4, ((this.f883g[iB] - i5) + i5) - i2);
            int[] iArr = this.f883g;
            byte[][] bArr2 = this.f882f;
            if (!u.a(bArr2[iB], (i2 - i5) + iArr[bArr2.length + iB], bArr, i3, iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iB++;
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String b() {
        return i().b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f c() {
        return i().c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f d() {
        return i().d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public int e() {
        return this.f883g[this.f882f.length - 1];
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (fVar.e() != e() || !a(0, fVar, 0, e())) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f f() {
        return i().f();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public byte[] g() {
        int[] iArr = this.f883g;
        byte[][] bArr = this.f882f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f883g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f882f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String h() {
        return i().h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f882f.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.f882f[i3];
            int[] iArr = this.f883g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = i4;
            for (int i9 = i6; i9 < (i7 - i5) + i6; i9++) {
                i8 = (i8 * 31) + bArr[i9];
            }
            i3++;
            i5 = i7;
            i4 = i8;
        }
        this.b = i4;
        return i4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String toString() {
        return i().toString();
    }
}
