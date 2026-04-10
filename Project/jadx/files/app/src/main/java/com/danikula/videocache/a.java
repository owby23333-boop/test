package com.danikula.videocache;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int a(byte[] bArr, long j2, int i2) throws ProxyCacheException;

    void a(byte[] bArr, int i2) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();
}
