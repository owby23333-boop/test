package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends p {
    private int aUH;
    private int aUI;
    private int aWc;
    private int aWd;
    private int aWe;
    private int aWf;
    private int aWg;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            OJ();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream byteArrayInputStreamOB = dVar.OB();
        this.aUI = com.kwad.sdk.pngencrypt.n.f(byteArrayInputStreamOB);
        this.aUH = com.kwad.sdk.pngencrypt.n.f(byteArrayInputStreamOB);
        this.aWc = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamOB);
        this.aWd = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamOB);
        this.aWe = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamOB);
        this.aWf = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamOB);
        this.aWg = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamOB);
    }

    private int Om() {
        return this.aUI;
    }

    private void eq(int i) {
        this.aUI = i;
    }

    private int Ol() {
        return this.aUH;
    }

    private void er(int i) {
        this.aUH = i;
    }

    private int OF() {
        return this.aWc;
    }

    private void es(int i) {
        this.aWc = i;
    }

    private int OG() {
        return this.aWd;
    }

    private void et(int i) {
        this.aWd = i;
    }

    private void eu(int i) {
        this.aWe = 0;
    }

    private void ev(int i) {
        this.aWf = 0;
    }

    private int OH() {
        return this.aWg;
    }

    private void ew(int i) {
        this.aWg = 0;
    }

    public final boolean OI() {
        return OH() == 1;
    }

    private void OJ() {
        eq(this.aUW.aUI);
        er(this.aUW.aUH);
        es(this.aUW.aVa);
        int i = this.aUW.aVc ? 4 : 0;
        if (this.aUW.aVe) {
            i++;
        }
        if (!this.aUW.aVd) {
            i += 2;
        }
        et(i);
        eu(0);
        ev(0);
        ew(0);
    }

    public final com.kwad.sdk.pngencrypt.k OK() {
        OL();
        return new com.kwad.sdk.pngencrypt.k(Om(), Ol(), OF(), (OG() & 4) != 0, OG() == 0 || OG() == 4, (OG() & 1) != 0);
    }

    private void OL() {
        if (this.aUI <= 0 || this.aUH <= 0 || this.aWe != 0 || this.aWf != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.aWc;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.aWg;
        if (i2 < 0 || i2 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i3 = this.aWd;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (i == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            if (i != 8 && i != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }
}
