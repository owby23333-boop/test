package com.bytedance.sdk.component.d.e;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface f extends Closeable, Flushable {
    void a_(d dVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    dt e();

    void flush() throws IOException;
}
