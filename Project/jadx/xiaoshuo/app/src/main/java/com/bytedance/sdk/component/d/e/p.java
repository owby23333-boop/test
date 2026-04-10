package com.bytedance.sdk.component.d.e;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements f {
    private final f e;

    public p(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.e = fVar;
    }

    @Override // com.bytedance.sdk.component.d.e.f
    public void a_(d dVar, long j) throws IOException {
        this.e.a_(dVar, j);
    }

    @Override // com.bytedance.sdk.component.d.e.f, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.e.close();
    }

    @Override // com.bytedance.sdk.component.d.e.f
    public dt e() {
        return this.e.e();
    }

    @Override // com.bytedance.sdk.component.d.e.f, java.io.Flushable
    public void flush() throws IOException {
        this.e.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.e.toString() + ")";
    }
}
