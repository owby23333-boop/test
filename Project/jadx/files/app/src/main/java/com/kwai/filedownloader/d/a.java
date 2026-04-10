package com.kwai.filedownloader.d;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends Closeable {
    void IL();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j2);

    void setLength(long j2);

    void write(byte[] bArr, int i2, int i3);
}
