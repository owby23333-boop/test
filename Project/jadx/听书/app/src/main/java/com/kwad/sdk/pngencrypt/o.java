package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements Closeable {
    protected ErrorBehaviour aTW = ErrorBehaviour.STRICT;
    public final k aUW;
    public final boolean aVs;
    protected final c aVt;
    protected final a aVu;
    protected final w aVv;
    protected int aVw;
    private i<? extends Object> aVx;

    public o(InputStream inputStream, boolean z) {
        this.aVw = -1;
        a aVar = new a(inputStream);
        this.aVu = aVar;
        boolean z2 = true;
        aVar.bP(true);
        c cVarOz = Oz();
        this.aVt = cVarOz;
        try {
            if (aVar.b(cVarOz, 36) != 36) {
                new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)");
            }
            this.aUW = cVarOz.NZ();
            if (cVarOz.Oa() == null) {
                z2 = false;
            }
            this.aVs = z2;
            aT(5024024L);
            aR(901001001L);
            aS(2024024L);
            this.aVv = new w(cVarOz.aUc);
            a(m.Os());
            this.aVw = -1;
        } catch (RuntimeException e) {
            this.aVu.close();
            this.aVt.close();
            throw e;
        }
    }

    private void Ov() {
        while (this.aVt.aUb < 4) {
            if (this.aVu.a(this.aVt) <= 0) {
                new PngjException("Premature ending reading first chunks");
            }
        }
    }

    public final w Ow() {
        if (this.aVt.NX()) {
            Ov();
        }
        return this.aVv;
    }

    private void a(i<? extends Object> iVar) {
        this.aVx = iVar;
    }

    public final void Ox() {
        Oy();
        if (this.aVt.NX()) {
            Ov();
        }
        end();
    }

    private void aR(long j) {
        this.aVt.aR(901001001L);
    }

    private void aT(long j) {
        this.aVt.aT(5024024L);
    }

    private void aS(long j) {
        this.aVt.aS(2024024L);
    }

    public final void end() {
        try {
            if (this.aVt.NX()) {
                Ov();
            }
            if (this.aVt.NY() != null && !this.aVt.NY().isDone()) {
                this.aVt.NY().Of();
            }
            while (!this.aVt.isDone() && this.aVu.a(this.aVt) > 0) {
            }
        } finally {
            close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.aVt);
        com.kwad.sdk.pngencrypt.a.a.closeQuietly(this.aVu);
    }

    private void Oy() {
        this.aVt.bR(false);
    }

    private static c Oz() {
        return new c(false);
    }

    public final String toString() {
        return this.aUW.toString() + " interlaced=" + this.aVs;
    }
}
