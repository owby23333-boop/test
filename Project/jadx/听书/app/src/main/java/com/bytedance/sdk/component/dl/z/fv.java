package com.bytedance.sdk.component.dl.z;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface fv extends Closeable, Flushable {
    void a_(dl dlVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    tb z();
}
