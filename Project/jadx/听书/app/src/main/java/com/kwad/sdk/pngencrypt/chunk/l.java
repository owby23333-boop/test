package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: classes4.dex */
public final class l extends p {
    private long aWk;
    private long aWl;
    private int aWm;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long jG = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.aWk = jG;
        if (jG < 0) {
            this.aWk = jG + 4294967296L;
        }
        long jG2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.aWl = jG2;
        if (jG2 < 0) {
            this.aWl = jG2 + 4294967296L;
        }
        this.aWm = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
