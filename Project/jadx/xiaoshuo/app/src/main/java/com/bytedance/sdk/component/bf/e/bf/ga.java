package com.bytedance.sdk.component.bf.e.bf;

/* JADX INFO: loaded from: classes.dex */
final class ga {
    int bf;
    int d;
    final byte[] e;
    boolean ga;
    ga p;
    boolean tg;
    ga vn;

    public ga() {
        this.e = new byte[8192];
        this.ga = true;
        this.tg = false;
    }

    public final ga bf() {
        ga gaVar = this.vn;
        ga gaVar2 = gaVar != this ? gaVar : null;
        ga gaVar3 = this.p;
        if (gaVar3 != null) {
            gaVar3.vn = gaVar;
        }
        ga gaVar4 = this.vn;
        if (gaVar4 != null) {
            gaVar4.p = gaVar3;
        }
        this.vn = null;
        this.p = null;
        return gaVar2;
    }

    public final ga e() {
        this.tg = true;
        return new ga(this.e, this.bf, this.d, true, false);
    }

    public final ga e(ga gaVar) {
        gaVar.p = this;
        gaVar.vn = this.vn;
        this.vn.p = gaVar;
        this.vn = gaVar;
        return gaVar;
    }

    public ga(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.e = bArr;
        this.bf = i;
        this.d = i2;
        this.tg = z;
        this.ga = z2;
    }
}
