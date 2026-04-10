package com.xuexiang.xupdate.proxy;

import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.service.OnFileDownloadListener;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdateDownloader {
    void backgroundDownload();

    void cancelDownload();

    void startDownload(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener);
}
