package com.yuewen;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes12.dex */
public class bh1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f9078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9079b;
    public long c = 0;

    public bh1(HttpEntity httpEntity) throws IllegalStateException, IOException {
        this.f9078a = httpEntity.getContent();
        this.f9079b = httpEntity.getContentLength();
    }

    public long a() {
        return this.f9079b;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f9078a.available();
    }

    public long b() {
        return this.c;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9078a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f9078a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9078a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f9078a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.f9078a.skip(j);
        this.c += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f9078a.read(bArr, i, i2);
        if (i3 >= 0) {
            this.c += (long) i3;
        } else if (this.c < this.f9079b) {
            throw new IOException(String.format("content break. read: %d bytes, expected: %d bytes.", Long.valueOf(this.c), Long.valueOf(this.f9079b)));
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f9078a.read();
        if (i >= 0) {
            this.c++;
        } else if (this.c < this.f9079b) {
            throw new IOException(String.format("content break. read: %d bytes, expected: %d bytes.", Long.valueOf(this.c), Long.valueOf(this.f9079b)));
        }
        return i;
    }
}
