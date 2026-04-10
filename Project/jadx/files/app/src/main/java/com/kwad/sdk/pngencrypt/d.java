package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet auB;
    protected boolean auC;
    protected boolean auD;
    protected byte[] auE;
    protected int auF;

    public d(int i2, String str, long j2, DeflatedChunksSet deflatedChunksSet) {
        super(i2, str, j2, ChunkReader.ChunkReaderMode.PROCESS);
        this.auC = false;
        this.auD = false;
        this.auF = -1;
        this.auB = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected void Bv() {
        int iG;
        if (!this.auD || this.auF < 0 || (iG = n.g(this.auE, 0)) == this.auF) {
            return;
        }
        com.kwad.sdk.core.d.b.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + iG + " expected " + this.auF));
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected final void a(int i2, byte[] bArr, int i3, int i4) {
        if (this.auD && i2 < 4) {
            while (i2 < 4 && i4 > 0) {
                this.auE[i2] = bArr[i3];
                i2++;
                i3++;
                i4--;
            }
        }
        if (i4 > 0) {
            this.auB.c(bArr, i3, i4);
            if (this.auC) {
                System.arraycopy(bArr, i3, Bu().data, this.atU, i4);
            }
        }
    }

    public final void bF(int i2) {
        this.auF = i2;
    }
}
