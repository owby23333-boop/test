package com.duokan.kernel;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public class DkBufferStream extends InputStream {
    private InputStream mDkStream;
    private long mSkip = 0;

    public DkBufferStream(InputStream inputStream) {
        this.mDkStream = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.mDkStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            i = this.mDkStream.read();
            if (i < 0) {
                this.mSkip = -1L;
                Log.i("", "readbyte: " + i);
            } else {
                this.mSkip++;
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        synchronized (this.mDkStream) {
            this.mSkip = 0L;
            this.mDkStream.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            Log.i("", "mSkip: " + j);
            jSkip = this.mDkStream.skip(j);
            this.mSkip = this.mSkip + jSkip;
        }
        return jSkip;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            i3 = this.mDkStream.read(bArr, i, i2);
            if (i3 < 0) {
                this.mSkip = -1L;
                Log.i("", "readbyte: " + i3);
            } else {
                this.mSkip += (long) i3;
            }
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr) throws IOException {
        int i;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            i = this.mDkStream.read(bArr);
            if (i < 0) {
                this.mSkip = -1L;
                Log.i("", "readbyte: " + i);
            } else {
                this.mSkip += (long) i;
            }
        }
        return i;
    }
}
