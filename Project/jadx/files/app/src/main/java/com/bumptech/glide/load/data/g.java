package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ExifOrientationStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends FilterInputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final byte[] f13441u = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f13442v = f13441u.length;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f13443w = f13442v + 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final byte f13444s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f13445t;

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.f13444s = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i3 = this.f13445t;
        int i4 = (i3 < 2 || i3 > (i2 = f13443w)) ? super.read() : i3 == i2 ? this.f13444s : f13441u[i3 - 2] & 255;
        if (i4 != -1) {
            this.f13445t++;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jSkip = super.skip(j2);
        if (jSkip > 0) {
            this.f13445t = (int) (((long) this.f13445t) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f13445t;
        int i6 = f13443w;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f13444s;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int iMin = Math.min(i6 - i5, i3);
            System.arraycopy(f13441u, this.f13445t - 2, bArr, i2, iMin);
            i4 = iMin;
        }
        if (i4 > 0) {
            this.f13445t += i4;
        }
        return i4;
    }
}
