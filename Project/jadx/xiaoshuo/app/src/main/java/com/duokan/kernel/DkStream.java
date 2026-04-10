package com.duokan.kernel;

import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public class DkStream extends DkNative {
    private final long mHandle;

    private DkStream(long j) {
        this.mHandle = j;
    }

    public native int available() throws IOException;

    public native Object clone();

    public native void close();

    public void finalize() {
        close();
    }

    public native long length();

    public native void mark(int i);

    public native boolean markSupported();

    public native int read() throws IOException;

    public native int read(byte[] bArr) throws IOException;

    public native int read(byte[] bArr, int i, int i2) throws IOException;

    public native void reset() throws IOException;

    public native long skip(long j) throws IOException;
}
