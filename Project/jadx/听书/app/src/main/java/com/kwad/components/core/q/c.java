package com.kwad.components.core.q;

import androidx.media3.datasource.cache.CacheDataSink;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends InputStream {
    private InputStream XR;
    private int XS;
    private volatile float XU;
    private volatile long XV;
    private int XO = -1;
    private int XP = 10000;
    private long XQ = -1;
    private long XT = -1;
    private int XW = CacheDataSink.DEFAULT_BUFFER_SIZE;

    c(InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.XR = inputStream;
        this.XU = i / 1000.0f;
    }

    public final long sC() {
        return this.XV;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.XT <= 0) {
            this.XT = System.currentTimeMillis();
        }
        this.XS++;
        if (!(b.XM && b.XL)) {
            return this.XR.read();
        }
        if (this.XO < 0) {
            sD();
        }
        int i = this.XR.read();
        this.XO++;
        sE();
        return i;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.XR.skip(j);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.XR.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.XR.close();
        b.a(this);
        this.XT = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.XR.mark(i);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.XR.reset();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.XR.markSupported();
    }

    private void sD() {
        this.XO = 0;
        this.XQ = System.currentTimeMillis();
    }

    private void sE() {
        if (this.XO < this.XP) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.XQ;
        float f = this.XO / this.XU;
        this.XV = g(this.XS, jCurrentTimeMillis - this.XT);
        float f2 = j;
        if (f > f2) {
            N((long) (f - f2));
        }
        sD();
    }

    private static long g(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    private static void N(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
