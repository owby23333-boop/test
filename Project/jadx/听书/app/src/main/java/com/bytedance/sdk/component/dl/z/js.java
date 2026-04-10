package com.bytedance.sdk.component.dl.z;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface js extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long z(dl dlVar, long j) throws IOException;

    tb z();
}
