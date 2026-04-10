package com.bytedance.pangle.res.z;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class uy extends FilterInputStream {
    protected void z(int i) throws IOException {
    }

    public uy(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        try {
            int i = this.in.read();
            z(i != -1 ? 1 : -1);
            return i;
        } catch (IOException e) {
            z(e);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int i = this.in.read(bArr);
            z(i);
            return i;
        } catch (IOException e) {
            z(e);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int i3 = this.in.read(bArr, i, i2);
            z(i3);
            return i3;
        } catch (IOException e) {
            z(e);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.in.skip(j);
        } catch (IOException e) {
            z(e);
            return 0L;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e) {
            z(e);
            return 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.in.close();
        } catch (IOException e) {
            z(e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.in.mark(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.in.reset();
        } catch (IOException e) {
            z(e);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    protected void z(IOException iOException) throws IOException {
        throw iOException;
    }
}
