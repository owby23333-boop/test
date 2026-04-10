package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Closeable {
    protected ErrorBehaviour auj = ErrorBehaviour.STRICT;
    public final boolean avF;
    protected final c avG;
    protected final a avH;
    protected final w avI;
    protected int avJ;
    private i<? extends Object> avK;
    public final k avj;

    public o(InputStream inputStream, boolean z2) {
        this.avJ = -1;
        this.avH = new a(inputStream);
        boolean z3 = true;
        this.avH.bh(true);
        this.avG = Ce();
        try {
            if (this.avH.b(this.avG, 36) != 36) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.avj = this.avG.BE();
            if (this.avG.BF() == null) {
                z3 = false;
            }
            this.avF = z3;
            ad(5024024L);
            ab(901001001L);
            ac(2024024L);
            this.avI = new w(this.avG.aup);
            a(m.BX());
            this.avJ = -1;
        } catch (RuntimeException e2) {
            this.avH.close();
            this.avG.close();
            throw e2;
        }
    }

    private void Ca() {
        while (true) {
            c cVar = this.avG;
            if (cVar.auo >= 4) {
                return;
            }
            if (this.avH.a(cVar) <= 0) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    private void Cd() {
        this.avG.bj(false);
    }

    private static c Ce() {
        return new c(false);
    }

    private void a(i<? extends Object> iVar) {
        this.avK = iVar;
    }

    private void ab(long j2) {
        this.avG.ab(901001001L);
    }

    private void ac(long j2) {
        this.avG.ac(2024024L);
    }

    private void ad(long j2) {
        this.avG.ad(5024024L);
    }

    public final w Cb() {
        if (this.avG.BC()) {
            Ca();
        }
        return this.avI;
    }

    public final void Cc() {
        Cd();
        if (this.avG.BC()) {
            Ca();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.avG);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.avH);
    }

    public final void end() {
        try {
            if (this.avG.BC()) {
                Ca();
            }
            if (this.avG.BD() != null && !this.avG.BD().isDone()) {
                this.avG.BD().BK();
            }
            while (!this.avG.isDone() && this.avH.a(this.avG) > 0) {
            }
        } finally {
            close();
        }
    }

    public final String toString() {
        return this.avj.toString() + " interlaced=" + this.avF;
    }
}
