package com.bytedance.sdk.component.dl.z;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface gc extends js, ReadableByteChannel {
    @Deprecated
    dl dl();

    m dl(long j) throws IOException;

    byte[] e(long j) throws IOException;

    short fo() throws IOException;

    String gc(long j) throws IOException;

    boolean gc() throws IOException;

    byte gz() throws IOException;

    void gz(long j) throws IOException;

    long i() throws IOException;

    short kb() throws IOException;

    String ls() throws IOException;

    InputStream m();

    byte[] p() throws IOException;

    int uy() throws IOException;

    int wp() throws IOException;

    long z(byte b) throws IOException;

    String z(Charset charset) throws IOException;

    void z(long j) throws IOException;

    void z(byte[] bArr) throws IOException;

    boolean z(long j, m mVar) throws IOException;
}
