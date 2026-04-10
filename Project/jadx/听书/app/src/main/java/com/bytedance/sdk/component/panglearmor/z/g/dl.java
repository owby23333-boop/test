package com.bytedance.sdk.component.panglearmor.z.g;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl {
    public static g z(RandomAccessFile randomAccessFile, long j, long j2) {
        return z(randomAccessFile.getChannel(), j, j2);
    }

    public static g z(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new a(fileChannel, j, j2);
    }
}
