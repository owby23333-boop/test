package com.bytedance.sdk.component.g.z;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p implements Closeable {
    public abstract byte[] a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract InputStream dl();

    public abstract String g();

    public abstract uy gc();

    public abstract long z();
}
