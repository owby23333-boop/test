package com.kwad.sdk.pngencrypt.chunk;

import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PngChunk {
    protected final com.kwad.sdk.pngencrypt.k avj;
    public final String awb;
    public final boolean awk;
    public final boolean awl;
    public final boolean awm;
    protected d awn;
    private boolean awo = false;
    protected int awp = -1;

    public enum ChunkOrderingConstraint {
        NONE,
        BEFORE_PLTE_AND_IDAT,
        AFTER_PLTE_BEFORE_IDAT,
        AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED,
        BEFORE_IDAT,
        AFTER_IDAT,
        NA;

        public final boolean isOk(int i2, boolean z2) {
            if (this == NONE) {
                return true;
            }
            return this == BEFORE_IDAT ? i2 < 4 : this == BEFORE_PLTE_AND_IDAT ? i2 < 2 : this == AFTER_PLTE_BEFORE_IDAT ? z2 ? i2 < 4 : i2 < 4 && i2 > 2 : this == AFTER_IDAT && i2 > 4;
        }

        public final boolean mustGoAfterIDAT() {
            return this == AFTER_IDAT;
        }

        public final boolean mustGoAfterPLTE() {
            return this == AFTER_PLTE_BEFORE_IDAT || this == AFTER_PLTE_BEFORE_IDAT_PLTE_REQUIRED;
        }

        public final boolean mustGoBeforeIDAT() {
            return this == BEFORE_IDAT || this == BEFORE_PLTE_AND_IDAT || this == AFTER_PLTE_BEFORE_IDAT;
        }

        public final boolean mustGoBeforePLTE() {
            return this == BEFORE_PLTE_AND_IDAT;
        }
    }

    public PngChunk(String str, com.kwad.sdk.pngencrypt.k kVar) {
        this.awb = str;
        this.avj = kVar;
        this.awk = b.dU(str);
        this.awl = b.dV(str);
        this.awm = b.dW(str);
    }

    private long Ch() {
        d dVar = this.awn;
        if (dVar != null) {
            return dVar.Ch();
        }
        return -1L;
    }

    private int Cj() {
        d dVar = this.awn;
        if (dVar != null) {
            return dVar.len;
        }
        return -1;
    }

    protected abstract void a(d dVar);

    final void b(d dVar) {
        this.awn = dVar;
    }

    final void bQ(int i2) {
        this.awp = i2;
    }

    public String toString() {
        return "chunk id= " + this.awb + " (len=" + Cj() + " offset=" + Ch() + ad.f20406s;
    }
}
