package com.kwad.components.offline.api.core.video;

/* JADX INFO: loaded from: classes3.dex */
public interface IKsMediaPlayerView {

    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i2, int i3);

    void fixWidth(boolean z2);

    int getTextureViewGravity();

    void setAd(boolean z2);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z2);

    void setHorizontalVideo(boolean z2);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f2);

    void updateTextureViewGravity(int i2);
}
