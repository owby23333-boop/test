package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: classes4.dex */
public final class s extends p {
    private int[] aWA;
    private int aWw;
    private int aWx;
    private int aWy;
    private int aWz;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.aWA = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (this.aUW.aVd) {
            this.aWw = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (this.aUW.aVe) {
            int length = dVar.data.length;
            this.aWA = new int[length];
            for (int i = 0; i < length; i++) {
                this.aWA[i] = dVar.data[i] & 255;
            }
            return;
        }
        this.aWx = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        this.aWy = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
        this.aWz = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
    }
}
