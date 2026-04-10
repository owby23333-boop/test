package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: classes4.dex */
public final class o extends p {
    private byte aWs;

    public o(com.kwad.sdk.pngencrypt.k kVar) {
        super("sTER", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 1) {
            throw new PngjException("bad chunk length " + dVar);
        }
        this.aWs = dVar.data[0];
    }
}
