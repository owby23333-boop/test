package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends b {
    protected k aTY;
    protected k aTZ;
    protected e aUa;
    protected int aUb = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e aUc = null;
    private long aUe = 0;
    private boolean aUf = true;
    private boolean aUg = false;
    private Set<String> aUh = new HashSet();
    private long aUi = 0;
    private long aUj = 0;
    private long aUk = 0;
    private ChunkLoadBehaviour aUm = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean aUd = false;
    private g aUl = new com.kwad.sdk.pngencrypt.chunk.a();

    public c(boolean z) {
    }

    private void gv(String str) {
        if (str.equals("IHDR")) {
            if (this.aUb < 0) {
                this.aUb = 0;
                return;
            } else {
                new PngjException("unexpected chunk " + str);
                return;
            }
        }
        if (str.equals("PLTE")) {
            int i = this.aUb;
            if (i == 0 || i == 1) {
                this.aUb = 2;
                return;
            } else {
                new PngjException("unexpected chunk here " + str);
                return;
            }
        }
        if (str.equals("IDAT")) {
            int i2 = this.aUb;
            if (i2 >= 0 && i2 <= 4) {
                this.aUb = 4;
                return;
            } else {
                new PngjException("unexpected chunk " + str);
                return;
            }
        }
        if (str.equals("IEND")) {
            if (this.aUb >= 4) {
                this.aUb = 6;
                return;
            } else {
                new PngjException("unexpected chunk " + str);
                return;
            }
        }
        int i3 = this.aUb;
        if (i3 <= 1) {
            this.aUb = 1;
        } else if (i3 <= 3) {
            this.aUb = 3;
        } else {
            this.aUb = 5;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean y(int i, String str) {
        if (super.y(i, str)) {
            return true;
        }
        if (this.aUi > 0 && ((long) i) + NS() > this.aUi) {
            new PngjException("Maximum total bytes to read exceeeded: " + this.aUi + " offset:" + NS() + " len=" + i);
        }
        if (this.aUh.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.gz(str)) {
            return false;
        }
        long j = this.aUj;
        if (j > 0 && i > j) {
            return true;
        }
        long j2 = this.aUk;
        if (j2 > 0 && i > j2 - this.aUe) {
            return true;
        }
        int i2 = AnonymousClass1.aUn[this.aUm.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.gB(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aUn;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aUn = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aUn[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private int NW() {
        return this.aUb;
    }

    public final boolean NX() {
        return NW() < 4;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.NP().aoB.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.NP());
            k kVarOK = iVar.OK();
            this.aTY = kVarOK;
            this.aTZ = kVarOK;
            if (iVar.OI()) {
                this.aUa = new e(this.aTZ);
            }
            this.aUc = new com.kwad.sdk.pngencrypt.chunk.e(this.aTY);
        }
        if (chunkReader.aTF == ChunkReader.ChunkReaderMode.BUFFER && gw(chunkReader.NP().aoB)) {
            this.aUe += (long) chunkReader.NP().len;
        }
        if (chunkReader.aTF == ChunkReader.ChunkReaderMode.BUFFER || this.aUg) {
            this.aUc.a(this.aUl.a(chunkReader.NP(), NZ()), this.aUb);
        }
    }

    private static boolean gw(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.gz(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final DeflatedChunksSet gt(String str) {
        return new j(str, this.aUd, Ob(), this.aUa);
    }

    public final j NY() {
        DeflatedChunksSet deflatedChunksSetNT = NT();
        if (deflatedChunksSetNT instanceof j) {
            return (j) deflatedChunksSetNT;
        }
        return null;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean gu(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        return super.a(bArr, i, i2);
    }

    public final k NZ() {
        return this.aTY;
    }

    public final e Oa() {
        return this.aUa;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final void c(int i, String str, long j) {
        gv(str);
        super.c(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aUb != 6) {
            this.aUb = 6;
        }
        super.close();
    }

    public final void aR(long j) {
        this.aUi = j;
    }

    public final void aS(long j) {
        this.aUj = j;
    }

    public final void aT(long j) {
        this.aUk = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean NR() {
        return this.aUf;
    }

    public final void bR(boolean z) {
        this.aUf = false;
    }

    private k Ob() {
        return this.aTZ;
    }
}
