package com.yuewen;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface my0 extends Cloneable {
    my0 clone();

    void close();

    long getLength();

    boolean isLowQuality();

    boolean isOpen();

    int read(ByteBuffer byteBuffer, long j);
}
