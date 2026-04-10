package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    protected k aul;
    protected k aum;
    protected e aun;
    protected int auo = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e aup = null;
    private long aur = 0;
    private boolean aus = true;
    private boolean aut = false;
    private Set<String> auu = new HashSet();
    private long auv = 0;
    private long auw = 0;
    private long aux = 0;
    private ChunkLoadBehaviour auz = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean auq = false;
    private g auy = new com.kwad.sdk.pngencrypt.chunk.a();

    /* JADX INFO: renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] auA = new int[ChunkLoadBehaviour.values().length];

        static {
            try {
                auA[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                auA[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z2) {
    }

    private int BB() {
        return this.auo;
    }

    private k BG() {
        return this.aum;
    }

    private void dQ(String str) {
        if (str.equals("IHDR")) {
            if (this.auo < 0) {
                this.auo = 0;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("PLTE")) {
            int i2 = this.auo;
            if (i2 == 0 || i2 == 1) {
                this.auo = 2;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk here " + str));
            return;
        }
        if (str.equals("IDAT")) {
            int i3 = this.auo;
            if (i3 >= 0 && i3 <= 4) {
                this.auo = 4;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("IEND")) {
            if (this.auo >= 4) {
                this.auo = 6;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        int i4 = this.auo;
        if (i4 <= 1) {
            this.auo = 1;
        } else if (i4 <= 3) {
            this.auo = 3;
        } else {
            this.auo = 5;
        }
    }

    private static boolean dR(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.dU(str);
    }

    public final boolean BC() {
        return BB() < 4;
    }

    public final j BD() {
        DeflatedChunksSet deflatedChunksSetBy = By();
        if (deflatedChunksSetBy instanceof j) {
            return (j) deflatedChunksSetBy;
        }
        return null;
    }

    public final k BE() {
        return this.aul;
    }

    public final e BF() {
        return this.aun;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean Bw() {
        return this.aus;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.Bu().awb.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.Bu());
            this.aul = iVar.Cp();
            this.aum = this.aul;
            if (iVar.Cn()) {
                this.aun = new e(this.aum);
            }
            this.aup = new com.kwad.sdk.pngencrypt.chunk.e(this.aul);
        }
        if (chunkReader.atS == ChunkReader.ChunkReaderMode.BUFFER && dR(chunkReader.Bu().awb)) {
            this.aur += (long) chunkReader.Bu().len;
        }
        if (chunkReader.atS == ChunkReader.ChunkReaderMode.BUFFER || this.aut) {
            try {
                this.aup.a(this.auy.a(chunkReader.Bu(), BE()), this.auo);
            } catch (PngjException e2) {
                throw e2;
            }
        }
    }

    public final void ab(long j2) {
        this.auv = j2;
    }

    public final void ac(long j2) {
        this.auw = j2;
    }

    public final void ad(long j2) {
        this.aux = j2;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i2, int i3) {
        return super.b(bArr, i2, i3);
    }

    public final void bj(boolean z2) {
        this.aus = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void c(int i2, String str, long j2) {
        dQ(str);
        super.c(i2, str, j2);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.auo != 6) {
            this.auo = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final DeflatedChunksSet dO(String str) {
        return new j(str, this.auq, BG(), this.aun);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean dP(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean l(int i2, String str) {
        if (super.l(i2, str)) {
            return true;
        }
        if (this.auv > 0 && ((long) i2) + Bx() > this.auv) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.auv + " offset:" + Bx() + " len=" + i2));
        }
        if (this.auu.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.dU(str)) {
            return false;
        }
        long j2 = this.auw;
        if (j2 > 0 && i2 > j2) {
            return true;
        }
        long j3 = this.aux;
        if (j3 > 0 && i2 > j3 - this.aur) {
            return true;
        }
        int i3 = AnonymousClass1.auA[this.auz.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.dW(str)) {
            return true;
        }
        return false;
    }
}
