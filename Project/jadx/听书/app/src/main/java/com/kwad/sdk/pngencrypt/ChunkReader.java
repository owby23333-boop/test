package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aTF;
    private final com.kwad.sdk.pngencrypt.chunk.d aTG;
    private boolean aTJ;
    protected int aTH = 0;
    private int aTI = 0;
    protected ErrorBehaviour aTK = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    protected abstract void NQ();

    protected abstract void a(int i, byte[] bArr, int i2, int i3);

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            new PngjException("Bad chunk paramenters: " + chunkReaderMode);
        }
        this.aTF = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.aTG = dVar;
        dVar.aU(j);
        this.aTJ = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d NP() {
        return this.aTG;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("negative length??");
        }
        if (this.aTH == 0 && this.aTI == 0 && this.aTJ) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aTG;
            dVar.e(dVar.aVN, 0, 4);
        }
        int i4 = this.aTG.len - this.aTH;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.aTI == 0) {
            if (this.aTJ && this.aTF != ChunkReaderMode.BUFFER && i4 > 0) {
                this.aTG.e(bArr, i, i4);
            }
            if (this.aTF == ChunkReaderMode.BUFFER) {
                if (this.aTG.data != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, this.aTG.data, this.aTH, i4);
                }
            } else if (this.aTF == ChunkReaderMode.PROCESS) {
                a(this.aTH, bArr, i, i4);
            }
            this.aTH += i4;
            i += i4;
            i2 -= i4;
        }
        if (this.aTH == this.aTG.len) {
            int i5 = 4 - this.aTI;
            if (i5 <= i2) {
                i2 = i5;
            }
            if (i2 > 0) {
                if (bArr != this.aTG.aVP) {
                    System.arraycopy(bArr, i, this.aTG.aVP, this.aTI, i2);
                }
                int i6 = this.aTI + i2;
                this.aTI = i6;
                if (i6 == 4) {
                    if (this.aTJ) {
                        if (this.aTF == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aTG;
                            dVar2.e(dVar2.data, 0, this.aTG.len);
                        }
                        this.aTG.bS(this.aTK == ErrorBehaviour.STRICT);
                    }
                    NQ();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aTI == 4;
    }

    public final void bQ(boolean z) {
        this.aTJ = false;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aTG;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aTG;
        if (dVar == null) {
            if (chunkReader.aTG != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.aTG)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.aTG.toString();
    }
}
