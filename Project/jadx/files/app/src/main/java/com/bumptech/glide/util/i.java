package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: MarkEnforcingInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends FilterInputStream {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f13899s;

    public i(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f13899s = Integer.MIN_VALUE;
    }

    private long f(long j2) {
        int i2 = this.f13899s;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
    }

    private void g(long j2) {
        int i2 = this.f13899s;
        if (i2 == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.f13899s = (int) (((long) i2) - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i2 = this.f13899s;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        super.mark(i2);
        this.f13899s = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (f(1L) == -1) {
            return -1;
        }
        int i2 = super.read();
        g(1L);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f13899s = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jF = f(j2);
        if (jF == -1) {
            return 0L;
        }
        long jSkip = super.skip(jF);
        g(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int iF = (int) f(i3);
        if (iF == -1) {
            return -1;
        }
        int i4 = super.read(bArr, i2, iF);
        g(i4);
        return i4;
    }
}
