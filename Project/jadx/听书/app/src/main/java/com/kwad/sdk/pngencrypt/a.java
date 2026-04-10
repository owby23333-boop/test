package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int aTC;
    private boolean aTD;
    private long aTE;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, 16384);
    }

    private a(InputStream inputStream, int i) {
        this.eof = false;
        this.aTD = true;
        this.aTE = 0L;
        this.stream = inputStream;
        this.buf = new byte[16384];
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    private int a(f fVar, int i) {
        NO();
        if (i <= 0 || i >= this.aTC) {
            i = this.aTC;
        }
        if (i > 0) {
            int iA = fVar.a(this.buf, this.offset, i);
            if (iA > 0) {
                this.offset += iA;
                this.aTC -= iA;
            }
            if (iA > 0) {
                return iA;
            }
            if (!fVar.isDone()) {
                new PngjException("This should not happen!");
            }
            return -1;
        }
        if (!this.eof) {
            new PngjException("This should not happen");
        }
        return fVar.isDone() ? -1 : 0;
    }

    public final int b(f fVar, int i) {
        int i2 = 36;
        while (i2 > 0) {
            int iA = a(fVar, i2);
            if (iA <= 0) {
                return iA;
            }
            i2 -= iA;
        }
        return 36;
    }

    private void NO() {
        if (this.aTC > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int i = this.stream.read(this.buf);
            this.aTC = i;
            if (i == 0) {
                new PngjException("This should not happen: stream.read(buf) returned 0");
            } else if (i < 0) {
                close();
            } else {
                this.aTE += (long) i;
            }
        } catch (IOException e) {
            new PngjException(e);
        }
    }

    public final void bP(boolean z) {
        this.aTD = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aTC = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aTD) {
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(inputStream);
        }
        this.stream = null;
    }
}
