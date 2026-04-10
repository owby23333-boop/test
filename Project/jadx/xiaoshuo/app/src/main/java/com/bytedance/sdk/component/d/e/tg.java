package com.bytedance.sdk.component.d.e;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes.dex */
public interface tg extends f, WritableByteChannel {
    tg bf(vn vnVar) throws IOException;

    tg bf(String str) throws IOException;

    d d();

    tg d(byte[] bArr) throws IOException;

    tg d(byte[] bArr, int i, int i2) throws IOException;

    @Override // com.bytedance.sdk.component.d.e.f, java.io.Flushable
    void flush() throws IOException;

    tg p(int i) throws IOException;

    tg pe() throws IOException;

    tg v(int i) throws IOException;

    tg wu(long j) throws IOException;

    tg xu(long j) throws IOException;

    tg zk(int i) throws IOException;
}
