package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends p {
    private int auU;
    private int auV;
    private int awq;
    private int awr;
    private int aws;
    private int awt;
    private int awu;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Co();
        }
    }

    private int BQ() {
        return this.auU;
    }

    private int BR() {
        return this.auV;
    }

    private int Ck() {
        return this.awq;
    }

    private int Cl() {
        return this.awr;
    }

    private int Cm() {
        return this.awu;
    }

    private void Co() {
        bR(this.avj.auV);
        bS(this.avj.auU);
        bT(this.avj.avn);
        int i2 = this.avj.avp ? 4 : 0;
        if (this.avj.avr) {
            i2++;
        }
        if (!this.avj.avq) {
            i2 += 2;
        }
        bU(i2);
        bV(0);
        bW(0);
        bX(0);
    }

    private void Cq() {
        if (this.auV <= 0 || this.auU <= 0 || this.aws != 0 || this.awt != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i2 = this.awq;
        if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 8 && i2 != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i3 = this.awu;
        if (i3 < 0 || i3 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i4 = this.awr;
        if (i4 != 0) {
            if (i4 != 6 && i4 != 2) {
                if (i4 == 3) {
                    if (this.awq == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i4 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            int i5 = this.awq;
            if (i5 != 8 && i5 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private void bR(int i2) {
        this.auV = i2;
    }

    private void bS(int i2) {
        this.auU = i2;
    }

    private void bT(int i2) {
        this.awq = i2;
    }

    private void bU(int i2) {
        this.awr = i2;
    }

    private void bV(int i2) {
        this.aws = 0;
    }

    private void bW(int i2) {
        this.awt = 0;
    }

    private void bX(int i2) {
        this.awu = 0;
    }

    public final boolean Cn() {
        return Cm() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Cp() {
        Cq();
        return new com.kwad.sdk.pngencrypt.k(BR(), BQ(), Ck(), (Cl() & 4) != 0, Cl() == 0 || Cl() == 4, (Cl() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream byteArrayInputStreamCg = dVar.Cg();
        this.auV = com.kwad.sdk.pngencrypt.n.f(byteArrayInputStreamCg);
        this.auU = com.kwad.sdk.pngencrypt.n.f(byteArrayInputStreamCg);
        this.awq = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamCg);
        this.awr = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamCg);
        this.aws = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamCg);
        this.awt = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamCg);
        this.awu = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamCg);
    }
}
