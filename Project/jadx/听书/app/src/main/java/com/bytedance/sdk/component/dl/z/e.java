package com.bytedance.sdk.component.dl.z;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements fv {
    private final fv z;

    public e(fv fvVar) {
        if (fvVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.z = fvVar;
    }

    @Override // com.bytedance.sdk.component.dl.z.fv
    public void a_(dl dlVar, long j) throws IOException {
        this.z.a_(dlVar, j);
    }

    @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
    public void flush() throws IOException {
        this.z.flush();
    }

    @Override // com.bytedance.sdk.component.dl.z.fv
    public tb z() {
        return this.z.z();
    }

    @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.z.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.z.toString() + ")";
    }
}
