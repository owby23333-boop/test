package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k aUW;
    public final boolean aVW;
    public final boolean aVX;
    public final boolean aVY;
    protected d aVZ;
    private boolean aWa = false;
    protected int aWb = -1;
    public final String aoB;

    protected abstract void a(d dVar);

    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean isOk(int i, boolean z) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i < 4 : this == BEFORE_PLTE_AND_IDAT ? i < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z ? i < 4 : i < 4 && i > 2 : this == AFTER_IDAT && i > 4;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.aoB = str;
        this.aUW = kVar;
        this.aVW = b.gz(str);
        this.aVX = b.gA(str);
        this.aVY = b.gB(str);
    }

    final void ep(int i) {
        this.aWb = i;
    }

    final void b(d dVar) {
        this.aVZ = dVar;
    }

    private int OE() {
        d dVar = this.aVZ;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    private long OC() {
        d dVar = this.aVZ;
        if (dVar != null) {
            return dVar.OC();
        }
        return -1L;
    }

    public String toString() {
        return "chunk id= " + this.aoB + " (len=" + OE() + " offset=" + OC() + ")";
    }
}
