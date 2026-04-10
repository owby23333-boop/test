package com.bumptech.glide.util;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: ExceptionPassthroughInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends InputStream {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @GuardedBy("POOL")
    private static final Queue<d> f13895u = l.a(0);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private InputStream f13896s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private IOException f13897t;

    d() {
    }

    @NonNull
    public static d b(@NonNull InputStream inputStream) {
        d dVarPoll;
        synchronized (f13895u) {
            dVarPoll = f13895u.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.a(inputStream);
        return dVarPoll;
    }

    void a(@NonNull InputStream inputStream) {
        this.f13896s = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f13896s.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f13896s.close();
    }

    @Nullable
    public IOException i() {
        return this.f13897t;
    }

    public void j() {
        this.f13897t = null;
        this.f13896s = null;
        synchronized (f13895u) {
            f13895u.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f13896s.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f13896s.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f13896s.read();
        } catch (IOException e2) {
            this.f13897t = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f13896s.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        try {
            return this.f13896s.skip(j2);
        } catch (IOException e2) {
            this.f13897t = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f13896s.read(bArr);
        } catch (IOException e2) {
            this.f13897t = e2;
            throw e2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.f13896s.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f13897t = e2;
            throw e2;
        }
    }
}
