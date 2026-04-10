package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BufferedOutputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final OutputStream f13437s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private byte[] f13438t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.bumptech.glide.load.engine.x.b f13439u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13440v;

    public c(@NonNull OutputStream outputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void i() throws IOException {
        int i2 = this.f13440v;
        if (i2 > 0) {
            this.f13437s.write(this.f13438t, 0, i2);
            this.f13440v = 0;
        }
    }

    private void j() throws IOException {
        if (this.f13440v == this.f13438t.length) {
            i();
        }
    }

    private void k() {
        byte[] bArr = this.f13438t;
        if (bArr != null) {
            this.f13439u.put(bArr);
            this.f13438t = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f13437s.close();
            k();
        } catch (Throwable th) {
            this.f13437s.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        i();
        this.f13437s.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f13438t;
        int i3 = this.f13440v;
        this.f13440v = i3 + 1;
        bArr[i3] = (byte) i2;
        j();
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, com.bumptech.glide.load.engine.x.b bVar, int i2) {
        this.f13437s = outputStream;
        this.f13439u = bVar;
        this.f13438t = (byte[]) bVar.a(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f13440v == 0 && i5 >= this.f13438t.length) {
                this.f13437s.write(bArr, i6, i5);
                return;
            }
            int iMin = Math.min(i5, this.f13438t.length - this.f13440v);
            System.arraycopy(bArr, i6, this.f13438t, this.f13440v, iMin);
            this.f13440v += iMin;
            i4 += iMin;
            j();
        } while (i4 < i3);
    }
}
