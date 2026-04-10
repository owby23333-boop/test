package com.bytedance.sdk.component.d.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class v implements k {
    private final k e;

    public v(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.e = kVar;
    }

    public final k bf() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.d.e.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e.close();
    }

    @Override // com.bytedance.sdk.component.d.e.k
    public long e(d dVar, long j) throws IOException {
        return this.e.e(dVar, j);
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.e.toString() + ")";
    }

    @Override // com.bytedance.sdk.component.d.e.k
    public dt e() {
        return this.e.e();
    }
}
