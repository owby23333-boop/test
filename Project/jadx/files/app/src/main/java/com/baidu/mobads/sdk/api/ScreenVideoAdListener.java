package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: classes2.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f2);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f2);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
