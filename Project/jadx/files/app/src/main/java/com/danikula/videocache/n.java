package com.danikula.videocache;

/* JADX INFO: compiled from: Source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface n {
    void a(long j2) throws ProxyCacheException;

    void close() throws ProxyCacheException;

    long length() throws ProxyCacheException;

    int read(byte[] bArr) throws ProxyCacheException;
}
