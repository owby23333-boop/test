package com.bytedance.sdk.component.dl.z;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gz implements js {
    private final js z;

    public gz(js jsVar) {
        if (jsVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.z = jsVar;
    }

    public final js g() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public long z(dl dlVar, long j) throws IOException {
        return this.z.z(dlVar, j);
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public tb z() {
        return this.z.z();
    }

    @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.z.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.z.toString() + ")";
    }
}
