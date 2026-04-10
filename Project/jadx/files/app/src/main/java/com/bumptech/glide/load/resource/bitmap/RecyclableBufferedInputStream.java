package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile byte[] f13759s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f13760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f13761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13762v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f13763w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.x.b f13764x;

    static class InvalidMarkException extends IOException {
        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f13762v;
        if (i2 != -1) {
            int i3 = this.f13763w - i2;
            int i4 = this.f13761u;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f13760t == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i4) {
                        length = i4;
                    }
                    byte[] bArr2 = (byte[]) this.f13764x.a(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f13759s = bArr2;
                    this.f13764x.put(bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.f13762v;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                this.f13763w -= this.f13762v;
                this.f13762v = 0;
                this.f13760t = 0;
                int i6 = this.f13763w;
                int i7 = inputStream.read(bArr, i6, bArr.length - i6);
                int i8 = this.f13763w;
                if (i7 > 0) {
                    i8 += i7;
                }
                this.f13760t = i8;
                return i7;
            }
        }
        int i9 = inputStream.read(bArr);
        if (i9 > 0) {
            this.f13762v = -1;
            this.f13763w = 0;
            this.f13760t = i9;
        }
        return i9;
    }

    private static IOException k() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f13759s == null || inputStream == null) {
            k();
            throw null;
        }
        return (this.f13760t - this.f13763w) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f13759s != null) {
            this.f13764x.put(this.f13759s);
            this.f13759s = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void i() {
        this.f13761u = this.f13759s.length;
    }

    public synchronized void j() {
        if (this.f13759s != null) {
            this.f13764x.put(this.f13759s);
            this.f13759s = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f13761u = Math.max(this.f13761u, i2);
        this.f13762v = this.f13763w;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f13759s;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            k();
            throw null;
        }
        if (this.f13763w >= this.f13760t && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f13759s && (bArr = this.f13759s) == null) {
            k();
            throw null;
        }
        if (this.f13760t - this.f13763w <= 0) {
            return -1;
        }
        int i2 = this.f13763w;
        this.f13763w = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f13759s == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f13762v) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f13763w + " markLimit: " + this.f13761u);
        }
        this.f13763w = this.f13762v;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.f13759s;
        if (bArr == null) {
            k();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            k();
            throw null;
        }
        if (this.f13760t - this.f13763w >= j2) {
            this.f13763w = (int) (((long) this.f13763w) + j2);
            return j2;
        }
        long j3 = ((long) this.f13760t) - ((long) this.f13763w);
        this.f13763w = this.f13760t;
        if (this.f13762v == -1 || j2 > this.f13761u) {
            long jSkip = inputStream.skip(j2 - j3);
            if (jSkip > 0) {
                this.f13762v = -1;
            }
            return j3 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j3;
        }
        if (this.f13760t - this.f13763w >= j2 - j3) {
            this.f13763w = (int) ((((long) this.f13763w) + j2) - j3);
            return j2;
        }
        long j4 = (j3 + ((long) this.f13760t)) - ((long) this.f13763w);
        this.f13763w = this.f13760t;
        return j4;
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar, int i2) {
        super(inputStream);
        this.f13762v = -1;
        this.f13764x = bVar;
        this.f13759s = (byte[]) bVar.a(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.f13759s;
        if (bArr2 == null) {
            k();
            throw null;
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.f13763w < this.f13760t) {
                int i6 = this.f13760t - this.f13763w >= i3 ? i3 : this.f13760t - this.f13763w;
                System.arraycopy(bArr2, this.f13763w, bArr, i2, i6);
                this.f13763w += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    return i6;
                }
                i2 += i6;
                i4 = i3 - i6;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f13762v == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.f13759s && (bArr2 = this.f13759s) == null) {
                        k();
                        throw null;
                    }
                    i5 = this.f13760t - this.f13763w >= i4 ? i4 : this.f13760t - this.f13763w;
                    System.arraycopy(bArr2, this.f13763w, bArr, i2, i5);
                    this.f13763w += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            k();
            throw null;
        }
    }
}
