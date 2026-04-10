package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a aKM;
    private RandomAccessFile aLD;
    public File file;

    public b(File file, a aVar) throws ProxyCacheException {
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.aKM = aVar;
            d.u(file.getParentFile());
            boolean zExists = file.exists();
            this.file = zExists ? file : new File(file.getParentFile(), file.getName() + ".download");
            this.aLD = new RandomAccessFile(this.file, zExists ? "r" : "rw");
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized long Kk() {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e);
        }
        return (int) this.aLD.length();
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.aLD.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(Kk()), Integer.valueOf(bArr.length)), e);
        }
        return this.aLD.read(bArr, 0, i);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void d(byte[] bArr, int i) {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.aLD.seek(Kk());
            this.aLD.write(bArr, 0, i);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.aLD, 1024), e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void close() {
        try {
            this.aLD.close();
            this.aKM.s(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.file, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (!this.file.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
        }
        this.file = file;
        try {
            this.aLD = new RandomAccessFile(this.file, "r");
            this.aKM.s(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized boolean isCompleted() {
        return !t(this.file);
    }

    private static boolean t(File file) {
        return file.getName().endsWith(".download");
    }
}
