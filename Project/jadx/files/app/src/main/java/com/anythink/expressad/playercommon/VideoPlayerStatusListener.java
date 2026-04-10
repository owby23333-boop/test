package com.anythink.expressad.playercommon;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoPlayerStatusListener {
    void onBufferingEnd();

    void onBufferingStart(String str);

    void onPlayCompleted();

    void onPlayError(String str);

    void onPlayProgress(int i2, int i3);

    void onPlayProgressMS(int i2, int i3);

    void onPlaySetDataSourceError(String str);

    void onPlayStarted(int i2);

    void onVideoDownloadResume();
}
