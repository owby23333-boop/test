package com.kwai.filedownloader.d;

import com.kwai.filedownloader.e.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwai.filedownloader.d.a {
    private final BufferedOutputStream aHO;
    private final RandomAccessFile aHP;
    private final FileDescriptor fd;

    public static class a implements c.e {
        @Override // com.kwai.filedownloader.e.c.e
        public final com.kwai.filedownloader.d.a ac(File file) {
            return new b(file);
        }
    }

    b(File file) {
        this.aHP = new RandomAccessFile(file, "rw");
        this.fd = this.aHP.getFD();
        this.aHO = new BufferedOutputStream(new FileOutputStream(this.aHP.getFD()));
    }

    @Override // com.kwai.filedownloader.d.a
    public final void IL() throws IOException {
        this.aHO.flush();
        this.fd.sync();
    }

    @Override // com.kwai.filedownloader.d.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.aHO.close();
        this.aHP.close();
    }

    @Override // com.kwai.filedownloader.d.a
    public final void seek(long j2) throws IOException {
        this.aHP.seek(j2);
    }

    @Override // com.kwai.filedownloader.d.a
    public final void setLength(long j2) throws IOException {
        this.aHP.setLength(j2);
    }

    @Override // com.kwai.filedownloader.d.a
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        this.aHO.write(bArr, 0, i3);
    }
}
