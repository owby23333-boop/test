package com.kwad.components.core.o;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends InputStream {
    private InputStream Pg;
    private int Ph;
    private volatile float Pj;
    private volatile long Pk;
    private int Pd = -1;
    private int Pe = 10000;
    private long Pf = -1;
    private long Pi = -1;
    private int Pl = com.anythink.expressad.exoplayer.j.a.b.a;

    c(@NonNull InputStream inputStream, int i2) {
        int i3 = this.Pl;
        i2 = i2 < i3 ? i3 : i2;
        this.Pg = inputStream;
        this.Pj = i2 / 1000.0f;
    }

    private static long d(long j2, long j3) {
        if (j2 <= 0) {
            return 0L;
        }
        if (j3 <= 0) {
            return -1L;
        }
        return j2 / j3;
    }

    private void pH() {
        this.Pd = 0;
        this.Pf = System.currentTimeMillis();
    }

    private void pI() {
        if (this.Pd < this.Pe) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.Pf;
        float f2 = this.Pd / this.Pj;
        this.Pk = d(this.Ph, jCurrentTimeMillis - this.Pi);
        float f3 = j2;
        if (f2 > f3) {
            u((long) (f2 - f3));
        }
        pH();
    }

    @WorkerThread
    private static void u(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.Pg.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.Pg.close();
        b.a(this);
        this.Pi = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i2) {
        this.Pg.mark(i2);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.Pg.markSupported();
    }

    public final long pG() {
        return this.Pk;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.Pi <= 0) {
            this.Pi = System.currentTimeMillis();
        }
        this.Ph++;
        if (!(b.Pb && b.Pa)) {
            return this.Pg.read();
        }
        if (this.Pd < 0) {
            pH();
        }
        int i2 = this.Pg.read();
        this.Pd++;
        pI();
        return i2;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.Pg.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        return this.Pg.skip(j2);
    }
}
