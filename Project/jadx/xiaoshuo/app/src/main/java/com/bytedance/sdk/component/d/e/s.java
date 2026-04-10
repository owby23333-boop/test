package com.bytedance.sdk.component.d.e;

/* JADX INFO: loaded from: classes.dex */
final class s {
    int bf;
    int d;
    final byte[] e;
    boolean ga;
    s p;
    boolean tg;
    s vn;

    public s() {
        this.e = new byte[8192];
        this.ga = true;
        this.tg = false;
    }

    public final s bf() {
        s sVar = this.vn;
        s sVar2 = sVar != this ? sVar : null;
        s sVar3 = this.p;
        if (sVar3 != null) {
            sVar3.vn = sVar;
        }
        s sVar4 = this.vn;
        if (sVar4 != null) {
            sVar4.p = sVar3;
        }
        this.vn = null;
        this.p = null;
        return sVar2;
    }

    public final void d() {
        s sVar = this.p;
        if (sVar == this) {
            throw new IllegalStateException();
        }
        if (sVar.ga) {
            int i = this.d - this.bf;
            if (i > (8192 - sVar.d) + (sVar.tg ? 0 : sVar.bf)) {
                return;
            }
            e(sVar, i);
            bf();
            w.e(this);
        }
    }

    public final s e() {
        this.tg = true;
        return new s(this.e, this.bf, this.d, true, false);
    }

    public final s e(s sVar) {
        sVar.p = this;
        sVar.vn = this.vn;
        this.vn.p = sVar;
        this.vn = sVar;
        return sVar;
    }

    public s(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.e = bArr;
        this.bf = i;
        this.d = i2;
        this.tg = z;
        this.ga = z2;
    }

    public final s e(int i) {
        s sVarE;
        if (i > 0 && i <= this.d - this.bf) {
            if (i >= 1024) {
                sVarE = e();
            } else {
                sVarE = w.e();
                System.arraycopy(this.e, this.bf, sVarE.e, 0, i);
            }
            sVarE.d = sVarE.bf + i;
            this.bf += i;
            this.p.e(sVarE);
            return sVarE;
        }
        throw new IllegalArgumentException();
    }

    public final void e(s sVar, int i) {
        if (sVar.ga) {
            int i2 = sVar.d;
            if (i2 + i > 8192) {
                if (!sVar.tg) {
                    int i3 = sVar.bf;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = sVar.e;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        sVar.d -= sVar.bf;
                        sVar.bf = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.e, this.bf, sVar.e, sVar.d, i);
            sVar.d += i;
            this.bf += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
