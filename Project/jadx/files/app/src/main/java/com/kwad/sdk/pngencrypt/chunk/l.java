package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends p {
    private int awA;
    private long awy;
    private long awz;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        this.awy = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        long j2 = this.awy;
        if (j2 < 0) {
            this.awy = j2 + 4294967296L;
        }
        this.awz = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        long j3 = this.awz;
        if (j3 < 0) {
            this.awz = j3 + 4294967296L;
        }
        this.awA = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
