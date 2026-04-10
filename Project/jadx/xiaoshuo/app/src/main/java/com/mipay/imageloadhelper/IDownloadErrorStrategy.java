package com.mipay.imageloadhelper;

import com.mipay.imageloadhelper.DownloadManager;

/* JADX INFO: loaded from: classes17.dex */
public interface IDownloadErrorStrategy {
    boolean handleDownloadError(int i, String str);

    void setDownloadTask(DownloadManager.DownloadTask downloadTask);
}
