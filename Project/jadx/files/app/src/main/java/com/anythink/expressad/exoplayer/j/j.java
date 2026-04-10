package com.anythink.expressad.exoplayer.j;

import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends InputStream {
    private final h a;
    private final k b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9666f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9664d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9665e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f9663c = new byte[1];

    public j(h hVar, k kVar) {
        this.a = hVar;
        this.b = kVar;
    }

    private void c() {
        if (this.f9664d) {
            return;
        }
        this.a.a(this.b);
        this.f9664d = true;
    }

    public final long a() {
        return this.f9666f;
    }

    public final void b() {
        c();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f9665e) {
            return;
        }
        this.a.b();
        this.f9665e = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (read(this.f9663c) == -1) {
            return -1;
        }
        return this.f9663c[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(@NonNull byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(@NonNull byte[] bArr, int i2, int i3) {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9665e);
        c();
        int iA = this.a.a(bArr, i2, i3);
        if (iA == -1) {
            return -1;
        }
        this.f9666f += (long) iA;
        return iA;
    }
}
