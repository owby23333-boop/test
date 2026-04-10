package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet aUo;
    protected boolean aUp;
    protected boolean aUq;
    protected byte[] aUr;
    protected int aUs;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.aUp = false;
        this.aUq = false;
        this.aUs = -1;
        this.aUo = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.aUq && i < 4) {
            while (i < 4 && i3 > 0) {
                this.aUr[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.aUo.b(bArr, i2, i3);
            if (this.aUp) {
                System.arraycopy(bArr, i2, NP().data, this.aTH, i3);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    protected void NQ() {
        int iG;
        if (!this.aUq || this.aUs < 0 || (iG = n.g(this.aUr, 0)) == this.aUs) {
            return;
        }
        new PngjException("bad chunk sequence for fDAT chunk " + iG + " expected " + this.aUs);
    }

    public final void ee(int i) {
        this.aUs = i;
    }
}
