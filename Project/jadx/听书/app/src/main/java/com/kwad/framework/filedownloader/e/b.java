package com.kwad.framework.filedownloader.e;

import com.kwad.framework.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.kwad.framework.filedownloader.e.a {
    private final BufferedOutputStream apy;
    private final RandomAccessFile apz;
    private final FileDescriptor fd;

    b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.apz = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.apy = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.apy.write(bArr, 0, i2);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void zw() throws IOException {
        this.apy.flush();
        this.fd.sync();
    }

    @Override // com.kwad.framework.filedownloader.e.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.apy.close();
        this.apz.close();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void seek(long j) throws IOException {
        this.apz.seek(j);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void setLength(long j) throws IOException {
        this.apz.setLength(j);
    }

    public static class a implements c.e {
        @Override // com.kwad.framework.filedownloader.f.c.e
        public final com.kwad.framework.filedownloader.e.a c(File file) {
            return new b(file);
        }
    }
}
