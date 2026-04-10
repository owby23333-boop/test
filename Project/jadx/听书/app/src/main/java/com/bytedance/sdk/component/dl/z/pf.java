package com.bytedance.sdk.component.dl.z;

/* JADX INFO: loaded from: classes2.dex */
final class pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f696a;
    int dl;
    pf e;
    int g;
    boolean gc;
    pf m;
    final byte[] z;

    pf() {
        this.z = new byte[8192];
        this.gc = true;
        this.f696a = false;
    }

    pf(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.z = bArr;
        this.g = i;
        this.dl = i2;
        this.f696a = z;
        this.gc = z2;
    }

    final pf z() {
        this.f696a = true;
        return new pf(this.z, this.g, this.dl, true, false);
    }

    public final pf g() {
        pf pfVar = this.m;
        pf pfVar2 = pfVar != this ? pfVar : null;
        pf pfVar3 = this.e;
        if (pfVar3 != null) {
            pfVar3.m = pfVar;
        }
        pf pfVar4 = this.m;
        if (pfVar4 != null) {
            pfVar4.e = pfVar3;
        }
        this.m = null;
        this.e = null;
        return pfVar2;
    }

    public final pf z(pf pfVar) {
        pfVar.e = this;
        pfVar.m = this.m;
        this.m.e = pfVar;
        this.m = pfVar;
        return pfVar;
    }

    public final pf z(int i) {
        pf pfVarZ;
        if (i <= 0 || i > this.dl - this.g) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            pfVarZ = z();
        } else {
            pfVarZ = ls.z();
            System.arraycopy(this.z, this.g, pfVarZ.z, 0, i);
        }
        pfVarZ.dl = pfVarZ.g + i;
        this.g += i;
        this.e.z(pfVarZ);
        return pfVarZ;
    }

    public final void dl() {
        pf pfVar = this.e;
        if (pfVar == this) {
            throw new IllegalStateException();
        }
        if (pfVar.gc) {
            int i = this.dl - this.g;
            if (i > (8192 - pfVar.dl) + (pfVar.f696a ? 0 : pfVar.g)) {
                return;
            }
            z(pfVar, i);
            g();
            ls.z(this);
        }
    }

    public final void z(pf pfVar, int i) {
        if (!pfVar.gc) {
            throw new IllegalArgumentException();
        }
        int i2 = pfVar.dl;
        if (i2 + i > 8192) {
            if (pfVar.f696a) {
                throw new IllegalArgumentException();
            }
            int i3 = pfVar.g;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = pfVar.z;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            pfVar.dl -= pfVar.g;
            pfVar.g = 0;
        }
        System.arraycopy(this.z, this.g, pfVar.z, pfVar.dl, i);
        pfVar.dl += i;
        this.g += i;
    }
}
