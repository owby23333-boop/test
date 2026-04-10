package com.bytedance.sdk.component.bf.e;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class w implements Closeable {
    public abstract String bf();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract InputStream d();

    public abstract long e();

    public abstract byte[] tg();
}
