package com.bytedance.sdk.component.d.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public interface ga extends k, ReadableByteChannel {
    long bh() throws IOException;

    @Deprecated
    d d();

    vn d(long j) throws IOException;

    long e(byte b2) throws IOException;

    String e(Charset charset) throws IOException;

    void e(long j) throws IOException;

    void e(byte[] bArr) throws IOException;

    boolean e(long j, vn vnVar) throws IOException;

    String ga(long j) throws IOException;

    boolean ga() throws IOException;

    byte[] l() throws IOException;

    int m() throws IOException;

    byte[] p(long j) throws IOException;

    byte v() throws IOException;

    void v(long j) throws IOException;

    InputStream vn();

    String w() throws IOException;

    short wu() throws IOException;

    int xu() throws IOException;

    short zk() throws IOException;
}
