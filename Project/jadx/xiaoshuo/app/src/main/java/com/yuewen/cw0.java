package com.yuewen;

import com.duokan.kernel.DkStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class cw0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kr0 f9999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DkStream f10000b;

    public cw0(kr0 kr0Var, DkStream dkStream) {
        this.f9999a = kr0Var;
        this.f10000b = dkStream;
        kr0Var.a();
    }

    public long a() {
        return this.f10000b.length();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f10000b.available();
    }

    public Object clone() {
        return new cw0(this.f9999a, (DkStream) this.f10000b.clone());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10000b.close();
        this.f9999a.b();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f10000b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f10000b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f10000b.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f10000b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f10000b.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f10000b.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f10000b.read(bArr);
    }
}
