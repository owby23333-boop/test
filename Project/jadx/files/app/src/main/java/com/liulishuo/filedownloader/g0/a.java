package com.liulishuo.filedownloader.g0;

import java.io.IOException;

/* JADX INFO: compiled from: FileDownloadOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a {
    void a() throws IOException;

    void close() throws IOException;

    void seek(long j2) throws IllegalAccessException, IOException;

    void setLength(long j2) throws IllegalAccessException, IOException;

    void write(byte[] bArr, int i2, int i3) throws IOException;
}
