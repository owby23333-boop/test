package com.dangdang.zframework.network.download;

import com.dangdang.zframework.network.download.DownloadManagerFactory;

/* JADX INFO: loaded from: classes10.dex */
public interface IDownloadHandle {
    void pauseDownload(DownloadManagerFactory.DownloadModule downloadModule, Download download, Object... objArr);

    void resumeDownload(DownloadManagerFactory.DownloadModule downloadModule, Download download, Object... objArr);

    void startDownload(DownloadManagerFactory.DownloadModule downloadModule, Download download, Object... objArr);
}
