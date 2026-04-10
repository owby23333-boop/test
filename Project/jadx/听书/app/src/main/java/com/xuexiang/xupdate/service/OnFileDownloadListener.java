package com.xuexiang.xupdate.service;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public interface OnFileDownloadListener {
    boolean onCompleted(File file);

    void onError(Throwable th);

    void onProgress(float f, long j);

    void onStart();
}
