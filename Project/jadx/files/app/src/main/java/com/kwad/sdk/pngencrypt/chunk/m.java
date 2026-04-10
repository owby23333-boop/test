package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends p {
    private int awB;
    private int[] awC;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.awB = 0;
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.awC[i2] = (i3 << 16) | (i4 << 8) | i5;
    }

    private void bY(int i2) {
        this.awB = i2;
        int i3 = this.awB;
        if (i3 <= 0 || i3 > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.awB);
        }
        int[] iArr = this.awC;
        if (iArr == null || iArr.length != i3) {
            this.awC = new int[this.awB];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        bY(dVar.len / 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.awB) {
            byte[] bArr = dVar.data;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            a(i2, bArr[i3] & 255, bArr[i4] & 255, bArr[i5] & 255);
            i2++;
            i3 = i5 + 1;
        }
    }
}
