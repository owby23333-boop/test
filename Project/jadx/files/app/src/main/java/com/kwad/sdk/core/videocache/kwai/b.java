package com.kwad.sdk.core.videocache.kwai;

import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a amS;
    private RandomAccessFile anG;
    public File file;

    public b(File file, a aVar) throws ProxyCacheException {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.amS = aVar;
            d.p(file.getParentFile());
            boolean zExists = file.exists();
            if (zExists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.file = file2;
            this.anG = new RandomAccessFile(this.file, zExists ? "r" : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    private static boolean o(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized int a(byte[] bArr, long j2, int i2) {
        try {
            this.anG.seek(j2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(yH()), Integer.valueOf(bArr.length)), e2);
        }
        return this.anG.read(bArr, 0, i2);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void close() {
        try {
            this.anG.close();
            this.amS.n(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.file, e2);
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
            this.anG = new RandomAccessFile(this.file, "r");
            this.amS.n(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void d(byte[] bArr, int i2) {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.anG.seek(yH());
            this.anG.write(bArr, 0, i2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.anG, 8192), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized boolean isCompleted() {
        return !o(this.file);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized long yH() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e2);
        }
        return (int) this.anG.length();
    }
}
