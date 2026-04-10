package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface IInput {
    @NonNull
    Buffer read() throws InterruptedException, StreamClosedException;
}
