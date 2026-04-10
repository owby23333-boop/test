package com.kwad.components.offline.api.core.adlive.listener;

/* JADX INFO: loaded from: classes3.dex */
public interface AdLivePlayStateListener {
    void onLiveAudioEnableChange(boolean z2);

    void onLivePlayCompleted();

    void onLivePlayEnd();

    void onLivePlayPause();

    void onLivePlayProgress(long j2);

    void onLivePlayResume();

    void onLivePlayStart();

    void onLivePrepared();
}
