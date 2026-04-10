package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] aTL;
    private final int aTM;
    private byte[] aTN;
    private int aTO;
    protected boolean aTP;
    protected boolean aTQ;
    private int aTR;
    private long aTS;
    private DeflatedChunksSet aTT;
    private ChunkReader aTU;
    private long aTV;
    private ErrorBehaviour aTW;
    protected boolean closed;

    private static String NU() {
        return "IHDR";
    }

    private static String NV() {
        return "IEND";
    }

    protected boolean NR() {
        return true;
    }

    protected abstract DeflatedChunksSet gt(String str);

    protected boolean gu(String str) {
        return false;
    }

    protected boolean y(int i, String str) {
        return false;
    }

    public b() {
        this(n.Ot());
    }

    private b(byte[] bArr) {
        this.aTN = new byte[8];
        this.aTO = 0;
        this.aTP = false;
        this.aTQ = false;
        this.closed = false;
        this.aTR = 0;
        this.aTS = 0L;
        this.aTW = ErrorBehaviour.STRICT;
        this.aTL = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aTM = length;
        this.aTP = length <= 0;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("This should not happen. Bad length: " + i2);
        }
        if (this.aTP) {
            ChunkReader chunkReader = this.aTU;
            if (chunkReader == null || chunkReader.isDone()) {
                int i3 = this.aTO;
                int i4 = 8 - i3;
                if (i4 <= i2) {
                    i2 = i4;
                }
                System.arraycopy(bArr, i, this.aTN, i3, i2);
                int i5 = this.aTO + i2;
                this.aTO = i5;
                int i6 = i2 + 0;
                this.aTS += (long) i2;
                if (i5 != 8) {
                    return i6;
                }
                this.aTR++;
                c(n.g(this.aTN, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aTN, 4), this.aTS - 8);
                this.aTO = 0;
                return i6;
            }
            int iA = this.aTU.a(bArr, i, i2);
            if (iA < 0) {
                return -1;
            }
            int i7 = iA + 0;
            this.aTS += (long) iA;
            return i7;
        }
        int i8 = this.aTM;
        int i9 = this.aTO;
        int i10 = i8 - i9;
        if (i10 <= i2) {
            i2 = i10;
        }
        System.arraycopy(bArr, i, this.aTN, i9, i2);
        int i11 = this.aTO + i2;
        this.aTO = i11;
        if (i11 == this.aTM) {
            g(this.aTN);
            this.aTO = 0;
            this.aTP = true;
        }
        int i12 = i2 + 0;
        this.aTS += (long) i2;
        return i12;
    }

    protected void c(int i, String str, long j) {
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.aVM.matcher(str).matches()) {
            new PngjException("Bad chunk id: " + str);
        }
        if (i < 0) {
            new PngjException("Bad chunk len: " + i);
        }
        if (str.equals("IDAT")) {
            this.aTV += (long) i;
        }
        boolean zNR = NR();
        boolean zY = y(i, str);
        boolean zGu = gu(str);
        DeflatedChunksSet deflatedChunksSet = this.aTT;
        boolean zGx = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aTT.gx(str);
        if (zGu && !zY) {
            if (!zGx) {
                DeflatedChunksSet deflatedChunksSet2 = this.aTT;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    new PngjException("new IDAT-like chunk when previous was not done");
                }
                this.aTT = gt(str);
            }
            this.aTU = new d(i, str, zNR, j, this.aTT) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                protected final void NQ() {
                    super.NQ();
                    b.this.a(this);
                }
            };
        } else {
            this.aTU = a(str, i, j, zY);
        }
        ChunkReader chunkReader = this.aTU;
        if (chunkReader == null || zNR) {
            return;
        }
        chunkReader.bQ(false);
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void NQ() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void a(int i2, byte[] bArr, int i3, int i4) {
                new PngjException("should never happen");
            }
        };
    }

    protected void a(ChunkReader chunkReader) {
        if (this.aTR == 1 && !NU().equals(chunkReader.NP().aoB)) {
            String str = "Bad first chunk: " + chunkReader.NP().aoB + " expected: " + NU();
            if (this.aTW.c < ErrorBehaviour.SUPER_LENIENT.c) {
                new PngjException(str);
            }
        }
        NV();
        if (chunkReader.NP().aoB.equals(NV())) {
            this.aTQ = true;
            close();
        }
    }

    private static void g(byte[] bArr) {
        if (Arrays.equals(bArr, n.Ot())) {
            return;
        }
        new PngjException("Bad signature:" + Arrays.toString(bArr));
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aTQ;
    }

    public final long NS() {
        return this.aTS;
    }

    public final DeflatedChunksSet NT() {
        return this.aTT;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aTT;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }
}
