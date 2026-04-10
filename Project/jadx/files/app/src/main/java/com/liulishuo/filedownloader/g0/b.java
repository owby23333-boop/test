package com.liulishuo.filedownloader.g0;

import com.liulishuo.filedownloader.h0.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: FileDownloadRandomAccessFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements com.liulishuo.filedownloader.g0.a {
    private final BufferedOutputStream a;
    private final FileDescriptor b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RandomAccessFile f17203c;

    /* JADX INFO: compiled from: FileDownloadRandomAccessFile.java */
    public static class a implements c.e {
        @Override // com.liulishuo.filedownloader.h0.c.e
        public com.liulishuo.filedownloader.g0.a a(File file) throws IOException {
            return new b(file);
        }

        @Override // com.liulishuo.filedownloader.h0.c.e
        public boolean a() {
            return true;
        }
    }

    b(File file) throws IOException {
        this.f17203c = new RandomAccessFile(file, "rw");
        this.b = this.f17203c.getFD();
        this.a = new BufferedOutputStream(new FileOutputStream(this.f17203c.getFD()));
    }

    @Override // com.liulishuo.filedownloader.g0.a
    public void a() throws IOException {
        this.a.flush();
        this.b.sync();
    }

    @Override // com.liulishuo.filedownloader.g0.a
    public void close() throws IOException {
        this.a.close();
        this.f17203c.close();
    }

    @Override // com.liulishuo.filedownloader.g0.a
    public void seek(long j2) throws IOException {
        this.f17203c.seek(j2);
    }

    @Override // com.liulishuo.filedownloader.g0.a
    public void setLength(long j2) throws IOException {
        this.f17203c.setLength(j2);
    }

    @Override // com.liulishuo.filedownloader.g0.a
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.a.write(bArr, i2, i3);
    }
}
