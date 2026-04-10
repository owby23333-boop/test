package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends p {
    private int awK;
    private int awL;
    private int awM;
    private int awN;
    private int[] awO;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.awO = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.avj;
        if (kVar.avq) {
            this.awK = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (!kVar.avr) {
            this.awL = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.awM = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
            this.awN = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
        } else {
            int length = dVar.data.length;
            this.awO = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                this.awO[i2] = dVar.data[i2] & 255;
            }
        }
    }
}
