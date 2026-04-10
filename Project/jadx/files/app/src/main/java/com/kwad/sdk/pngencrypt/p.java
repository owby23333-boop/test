package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes3.dex */
final class p {
    int auT;
    int auW;
    int auX;
    int auY;
    int auZ;
    public final e aun;
    public final boolean avL;
    int avM;
    int avN;
    int avO;
    int avP;
    int avQ;
    int avR;
    int avS;
    public final k avj;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.avj = kVar;
        this.aun = eVar;
        this.avL = eVar != null;
    }

    final void h(byte[] bArr, int i2) {
        this.buf = bArr;
        this.avS = i2;
    }

    final void update(int i2) {
        int i3;
        this.avM = i2;
        if (this.avL) {
            this.auT = this.aun.BP();
            e eVar = this.aun;
            this.auX = eVar.auX;
            this.auW = eVar.auW;
            this.auZ = eVar.auZ;
            this.auY = eVar.auY;
            this.avN = eVar.BO();
            this.avO = this.aun.BN();
            this.avP = this.aun.BQ();
            this.avQ = this.aun.BR();
            i3 = ((this.avj.avt * this.avQ) + 7) / 8;
        } else {
            this.auT = 1;
            this.auW = 1;
            this.auX = 1;
            this.auY = 0;
            this.auZ = 0;
            this.avO = i2;
            this.avN = i2;
            k kVar = this.avj;
            this.avP = kVar.auU;
            this.avQ = kVar.auV;
            i3 = kVar.avv;
        }
        this.avR = i3;
    }
}
