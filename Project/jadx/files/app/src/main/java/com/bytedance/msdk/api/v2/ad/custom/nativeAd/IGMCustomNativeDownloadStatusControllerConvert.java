package com.bytedance.msdk.api.v2.ad.custom.nativeAd;

/* JADX INFO: loaded from: classes2.dex */
public interface IGMCustomNativeDownloadStatusControllerConvert {
    void cancelDownload();

    int getDownloadStatus();

    void pauseAppDownload();

    void resumeAppDownload();
}
