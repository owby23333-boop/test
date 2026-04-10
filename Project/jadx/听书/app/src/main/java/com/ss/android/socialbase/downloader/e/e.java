package com.ss.android.socialbase.downloader.e;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public class e implements Closeable {
    private RandomAccessFile dl;
    private FileDescriptor g;
    private BufferedOutputStream z;

    public e(File file, int i) throws com.ss.android.socialbase.downloader.gc.z {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.dl = randomAccessFile;
            this.g = randomAccessFile.getFD();
            if (i > 0) {
                int i2 = 8192;
                if (i >= 8192) {
                    i2 = 131072;
                    i = i > 131072 ? i2 : i;
                }
                this.z = new BufferedOutputStream(new FileOutputStream(this.dl.getFD()), i);
                return;
            }
            this.z = new BufferedOutputStream(new FileOutputStream(this.dl.getFD()));
        } catch (IOException e) {
            throw new com.ss.android.socialbase.downloader.gc.z(1039, e);
        }
    }

    public void z(byte[] bArr, int i, int i2) throws IOException {
        this.z.write(bArr, i, i2);
    }

    public void z() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.z;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.g;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void g() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.z;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void dl() throws IOException {
        FileDescriptor fileDescriptor = this.g;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.ss.android.socialbase.downloader.pf.m.z(this.dl, this.z);
    }

    public void z(long j) throws IOException {
        this.dl.seek(j);
    }

    public void g(long j) throws IOException {
        this.dl.setLength(j);
    }
}
