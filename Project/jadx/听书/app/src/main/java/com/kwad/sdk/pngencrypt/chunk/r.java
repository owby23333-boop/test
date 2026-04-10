package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: classes4.dex */
public final class r extends p {
    private int aWt;
    private int aWu;
    private int aWv;
    private int hour;
    private int min;
    private int year;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 7) {
            throw new PngjException("bad chunk " + dVar);
        }
        this.year = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        this.aWt = com.kwad.sdk.pngencrypt.n.e(dVar.data, 2);
        this.aWu = com.kwad.sdk.pngencrypt.n.e(dVar.data, 3);
        this.hour = com.kwad.sdk.pngencrypt.n.e(dVar.data, 4);
        this.min = com.kwad.sdk.pngencrypt.n.e(dVar.data, 5);
        this.aWv = com.kwad.sdk.pngencrypt.n.e(dVar.data, 6);
    }
}
