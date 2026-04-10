package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int atP;
    private boolean atQ;
    private long atR;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    private a(InputStream inputStream, int i2) {
        this.eof = false;
        this.atQ = true;
        this.atR = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    private void Bt() {
        if (this.atP > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            this.atP = this.stream.read(this.buf);
            if (this.atP == 0) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen: stream.read(buf) returned 0"));
            } else if (this.atP < 0) {
                close();
            } else {
                this.atR += (long) this.atP;
            }
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException(e2));
        }
    }

    private int a(f fVar, int i2) {
        Bt();
        if (i2 <= 0 || i2 >= this.atP) {
            i2 = this.atP;
        }
        if (i2 <= 0) {
            if (!this.eof) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen"));
            }
            return fVar.isDone() ? -1 : 0;
        }
        int iB = fVar.b(this.buf, this.offset, i2);
        if (iB > 0) {
            this.offset += iB;
            this.atP -= iB;
        }
        if (iB > 0) {
            return iB;
        }
        if (!fVar.isDone()) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen!"));
        }
        return -1;
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final int b(f fVar, int i2) {
        int i3 = 36;
        while (i3 > 0) {
            int iA = a(fVar, i3);
            if (iA <= 0) {
                return iA;
            }
            i3 -= iA;
        }
        return 36;
    }

    public final void bh(boolean z2) {
        this.atQ = z2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.atP = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.atQ) {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
        this.stream = null;
    }
}
