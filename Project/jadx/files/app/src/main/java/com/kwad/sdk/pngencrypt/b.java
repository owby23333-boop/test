package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] atY;
    private final int atZ;
    private byte[] aua;
    private int aub;
    protected boolean auc;
    protected boolean aud;
    private int aue;
    private long auf;
    private DeflatedChunksSet aug;
    private ChunkReader auh;
    private long aui;
    private ErrorBehaviour auj;
    protected boolean closed;

    public b() {
        this(n.BY());
    }

    private b(byte[] bArr) {
        this.aua = new byte[8];
        this.aub = 0;
        this.auc = false;
        this.aud = false;
        this.closed = false;
        this.aue = 0;
        this.auf = 0L;
        this.auj = ErrorBehaviour.STRICT;
        this.atY = bArr;
        byte[] bArr2 = this.atY;
        this.atZ = bArr2 == null ? 0 : bArr2.length;
        this.auc = this.atZ <= 0;
    }

    private static String BA() {
        return "IEND";
    }

    private static String Bz() {
        return "IHDR";
    }

    private ChunkReader a(String str, int i2, long j2, boolean z2) {
        return new ChunkReader(i2, str, j2, z2 ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void Bv() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void a(int i3, byte[] bArr, int i4, int i5) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    private static void h(byte[] bArr) {
        if (Arrays.equals(bArr, n.BY())) {
            return;
        }
        com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    protected boolean Bw() {
        return true;
    }

    public final long Bx() {
        return this.auf;
    }

    public final DeflatedChunksSet By() {
        return this.aug;
    }

    protected void a(ChunkReader chunkReader) {
        if (this.aue == 1 && !Bz().equals(chunkReader.Bu().awb)) {
            String str = "Bad first chunk: " + chunkReader.Bu().awb + " expected: " + Bz();
            if (this.auj.f16966c < ErrorBehaviour.SUPER_LENIENT.f16966c) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", str);
            }
        }
        BA();
        if (chunkReader.Bu().awb.equals(BA())) {
            this.aud = true;
            close();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i2, int i3) {
        int i4;
        long j2;
        long j3;
        if (this.closed) {
            return -1;
        }
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen. Bad length: " + i3));
        }
        if (this.auc) {
            ChunkReader chunkReader = this.auh;
            if (chunkReader == null || chunkReader.isDone()) {
                int i5 = 8 - this.aub;
                if (i5 <= i3) {
                    i3 = i5;
                }
                System.arraycopy(bArr, i2, this.aua, this.aub, i3);
                this.aub += i3;
                i4 = i3 + 0;
                this.auf += (long) i3;
                if (this.aub == 8) {
                    this.aue++;
                    c(n.g(this.aua, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aua, 4), this.auf - 8);
                    this.aub = 0;
                }
                return i4;
            }
            int iB = this.auh.b(bArr, i2, i3);
            if (iB < 0) {
                return -1;
            }
            i4 = iB + 0;
            j2 = this.auf;
            j3 = iB;
        } else {
            int i6 = this.atZ - this.aub;
            if (i6 <= i3) {
                i3 = i6;
            }
            System.arraycopy(bArr, i2, this.aua, this.aub, i3);
            this.aub += i3;
            if (this.aub == this.atZ) {
                h(this.aua);
                this.aub = 0;
                this.auc = true;
            }
            i4 = i3 + 0;
            j2 = this.auf;
            j3 = i3;
        }
        this.auf = j2 + j3;
        return i4;
    }

    protected void c(int i2, String str, long j2) {
        com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "New chunk: " + str + " " + i2 + " off:" + j2);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.avZ.matcher(str).matches()) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk len: " + i2));
        }
        if (str.equals("IDAT")) {
            this.aui += (long) i2;
        }
        boolean zBw = Bw();
        boolean zL = l(i2, str);
        boolean zDP = dP(str);
        DeflatedChunksSet deflatedChunksSet = this.aug;
        boolean zDS = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.aug.dS(str);
        if (!zDP || zL) {
            this.auh = a(str, i2, j2, zL);
        } else {
            if (!zDS) {
                DeflatedChunksSet deflatedChunksSet2 = this.aug;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.d.b.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.aug = dO(str);
            }
            this.auh = new d(i2, str, zBw, j2, this.aug) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                protected final void Bv() {
                    super.Bv();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.auh;
        if (chunkReader == null || zBw) {
            return;
        }
        chunkReader.bi(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aug;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    protected abstract DeflatedChunksSet dO(String str);

    protected boolean dP(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aud;
    }

    protected boolean l(int i2, String str) {
        return false;
    }
}
