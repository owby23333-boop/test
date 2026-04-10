package com.bytedance.sdk.component.dl.z;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends fv, WritableByteChannel {
    a dl(byte[] bArr) throws IOException;

    a dl(byte[] bArr, int i, int i2) throws IOException;

    dl dl();

    a e(int i) throws IOException;

    @Override // com.bytedance.sdk.component.dl.z.fv, java.io.Flushable
    void flush() throws IOException;

    a fo(int i) throws IOException;

    a g(m mVar) throws IOException;

    a g(String str) throws IOException;

    a gz(int i) throws IOException;

    a kb(long j) throws IOException;

    a q() throws IOException;

    a wp(long j) throws IOException;
}
