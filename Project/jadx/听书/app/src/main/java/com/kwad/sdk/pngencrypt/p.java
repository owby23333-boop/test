package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes4.dex */
final class p {
    int aUG;
    int aUJ;
    int aUK;
    int aUL;
    int aUM;
    public final k aUW;
    public final e aUa;
    int aVA;
    int aVB;
    int aVC;
    int aVD;
    int aVE;
    int aVF;
    public final boolean aVy;
    int aVz;
    byte[] buf;

    public p(k kVar, e eVar) {
        this.aUW = kVar;
        this.aUa = eVar;
        this.aVy = eVar != null;
    }

    final void update(int i) {
        this.aVz = i;
        if (this.aVy) {
            this.aUG = this.aUa.Ok();
            this.aUK = this.aUa.aUK;
            this.aUJ = this.aUa.aUJ;
            this.aUM = this.aUa.aUM;
            this.aUL = this.aUa.aUL;
            this.aVA = this.aUa.Oj();
            this.aVB = this.aUa.Oi();
            this.aVC = this.aUa.Ol();
            this.aVD = this.aUa.Om();
            this.aVE = ((this.aUW.aVg * this.aVD) + 7) / 8;
            return;
        }
        this.aUG = 1;
        this.aUJ = 1;
        this.aUK = 1;
        this.aUL = 0;
        this.aUM = 0;
        this.aVB = i;
        this.aVA = i;
        this.aVC = this.aUW.aUH;
        this.aVD = this.aUW.aUI;
        this.aVE = this.aUW.aVi;
    }

    final void h(byte[] bArr, int i) {
        this.buf = bArr;
        this.aVF = i;
    }
}
