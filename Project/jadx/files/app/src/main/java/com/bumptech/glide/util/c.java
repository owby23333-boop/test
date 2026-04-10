package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ContentLengthInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f13893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f13894t;

    private c(@NonNull InputStream inputStream, long j2) {
        super(inputStream);
        this.f13893s = j2;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j2) {
        return new c(inputStream, j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f13893s - ((long) this.f13894t), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i2;
        i2 = super.read();
        a(i2 >= 0 ? 1 : -1);
        return i2;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f13894t += i2;
        } else if (this.f13893s - ((long) this.f13894t) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f13893s + ", but read: " + this.f13894t);
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        i4 = super.read(bArr, i2, i3);
        a(i4);
        return i4;
    }
}
