package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IBufferPool {
    @NonNull
    Buffer obtain() throws InterruptedException, StreamClosedException;

    void recycle(@NonNull Buffer buffer);
}
