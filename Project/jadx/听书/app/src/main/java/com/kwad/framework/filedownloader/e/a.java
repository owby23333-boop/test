package com.kwad.framework.filedownloader.e;

import java.io.Closeable;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j);

    void setLength(long j);

    void write(byte[] bArr, int i, int i2);

    void zw();
}
