package com.bytedance.sdk.component.d.e;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface k extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long e(d dVar, long j) throws IOException;

    dt e();
}
