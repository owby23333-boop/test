package com.ss.android.ttmd5;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface IRandomAccess {
    void close() throws IOException;

    long length() throws IOException;

    int read(byte[] bArr, int i2, int i3) throws IOException;

    void seek(long j2, long j3) throws IOException;
}
