package com.kwad.components.core.offline.init.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.an;

/* JADX INFO: loaded from: classes3.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView KR;

    public b(Context context) {
        super(context);
    }

    public final b a(@NonNull DetailVideoView detailVideoView) {
        an.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.KR = detailVideoView;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i2, int i3) {
        this.KR.adaptVideoSize(i2, i3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z2) {
        this.KR.fixWidth(z2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.KR.getTextureViewGravity();
    }

    public final DetailVideoView ol() {
        return this.KR;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z2) {
        this.KR.setAd(z2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.KR.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.a() { // from class: com.kwad.components.core.offline.init.b.b.1
            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickRootView() {
                videoViewClickListener.onClickRootView();
            }

            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickVideoView() {
                videoViewClickListener.onClickVideoView();
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z2) {
        this.KR.setForce(z2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z2) {
        this.KR.setHorizontalVideo(z2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (!(iKsMediaPlayer instanceof a)) {
            throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
        }
        this.KR.setMediaPlayer(((a) iKsMediaPlayer).oj());
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f2) {
        this.KR.setRadius(f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i2) {
        this.KR.updateTextureViewGravity(i2);
    }
}
