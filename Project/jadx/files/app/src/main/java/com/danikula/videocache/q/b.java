package com.danikula.videocache.q;

import com.danikula.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: FileCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements com.danikula.videocache.a {
    private final a a;
    public File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RandomAccessFile f14791c;

    public b(File file, a aVar) throws ProxyCacheException {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.a = aVar;
            d.b(file.getParentFile());
            boolean zExists = file.exists();
            if (zExists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.b = file2;
            this.f14791c = new RandomAccessFile(this.b, zExists ? "r" : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    @Override // com.danikula.videocache.a
    public synchronized int a(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        try {
            this.f14791c.seek(j2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(available()), Integer.valueOf(bArr.length)), e2);
        }
        return this.f14791c.read(bArr, 0, i2);
    }

    @Override // com.danikula.videocache.a
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.b, e2);
        }
        return (int) this.f14791c.length();
    }

    @Override // com.danikula.videocache.a
    public synchronized void close() throws ProxyCacheException {
        try {
            this.f14791c.close();
            this.a.a(this.b);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.b, e2);
        }
    }

    @Override // com.danikula.videocache.a
    public synchronized void complete() throws ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.b.getParentFile(), this.b.getName().substring(0, this.b.getName().length() - 9));
        if (!this.b.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.b + " to " + file + " for completion!");
        }
        this.b = file;
        try {
            this.f14791c = new RandomAccessFile(this.b, "r");
            this.a.a(this.b);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.b + " as disc cache", e2);
        }
    }

    @Override // com.danikula.videocache.a
    public synchronized boolean isCompleted() {
        return !a(this.b);
    }

    @Override // com.danikula.videocache.a
    public synchronized void a(byte[] bArr, int i2) throws ProxyCacheException {
        try {
            if (!isCompleted()) {
                this.f14791c.seek(available());
                this.f14791c.write(bArr, 0, i2);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.b + " is completed!");
            }
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.f14791c, Integer.valueOf(bArr.length)), e2);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }
}
