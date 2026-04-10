package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode atS;
    private final com.kwad.sdk.pngencrypt.chunk.d atT;
    private boolean atW;
    protected int atU = 0;
    private int atV = 0;
    protected ErrorBehaviour atX = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i2, String str, long j2, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i2 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.atS = chunkReaderMode;
        this.atT = new com.kwad.sdk.pngencrypt.chunk.d(i2, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.atT.ae(j2);
        this.atW = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d Bu() {
        return this.atT;
    }

    protected abstract void Bv();

    protected abstract void a(int i2, byte[] bArr, int i3, int i4);

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("negative length??"));
        }
        if (this.atU == 0 && this.atV == 0 && this.atW) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.atT;
            dVar.f(dVar.awa, 0, 4);
        }
        int i4 = this.atT.len - this.atU;
        if (i4 > i3) {
            i4 = i3;
        }
        if (i4 > 0 || this.atV == 0) {
            if (this.atW && this.atS != ChunkReaderMode.BUFFER && i4 > 0) {
                this.atT.f(bArr, i2, i4);
            }
            ChunkReaderMode chunkReaderMode = this.atS;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.atT.data;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i2, bArr2, this.atU, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.atU, bArr, i2, i4);
            }
            this.atU += i4;
            i2 += i4;
            i3 -= i4;
        }
        if (this.atU == this.atT.len) {
            int i5 = 4 - this.atV;
            if (i5 <= i3) {
                i3 = i5;
            }
            if (i3 > 0) {
                byte[] bArr3 = this.atT.awd;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i2, bArr3, this.atV, i3);
                }
                this.atV += i3;
                if (this.atV == 4) {
                    if (this.atW) {
                        if (this.atS == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.atT;
                            dVar2.f(dVar2.data, 0, dVar2.len);
                        }
                        this.atT.bk(this.atX == ErrorBehaviour.STRICT);
                    }
                    com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "Chunk done");
                    Bv();
                }
            }
        } else {
            i3 = 0;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    public final void bi(boolean z2) {
        this.atW = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.atT;
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).atT;
        if (dVar == null) {
            if (dVar2 != null) {
                return false;
            }
        } else if (!dVar.equals(dVar2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.atT;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.atV == 4;
    }

    public String toString() {
        return this.atT.toString();
    }
}
