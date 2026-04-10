package com.kwad.components.core.o.b.c;

import android.content.Context;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.sdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
final class b extends BaseKsMediaPlayerView {
    private DetailVideoView SB;

    public b(Context context) {
        super(context);
    }

    public final b b(DetailVideoView detailVideoView) {
        ax.checkNotNull(detailVideoView);
        addView(detailVideoView);
        this.SB = detailVideoView;
        return this;
    }

    public final DetailVideoView qI() {
        return this.SB;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer) {
        if (!(iKsMediaPlayer instanceof a)) {
            throw new IllegalArgumentException("mediaPlayer not instanceof KsMediaPlayer");
        }
        this.SB.setMediaPlayer(((a) iKsMediaPlayer).qG());
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void adaptVideoSize(int i, int i2) {
        this.SB.adaptVideoSize(i, i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setAd(boolean z) {
        this.SB.setAd(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setHorizontalVideo(boolean z) {
        this.SB.setHorizontalVideo(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void fixWidth(boolean z) {
        this.SB.fixWidth(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setForce(boolean z) {
        this.SB.setForce(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setClickListener(final IKsMediaPlayerView.VideoViewClickListener videoViewClickListener) {
        this.SB.setClickListener(videoViewClickListener == null ? null : new DetailVideoView.a() { // from class: com.kwad.components.core.o.b.c.b.1
            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickVideoView() {
                videoViewClickListener.onClickVideoView();
            }

            @Override // com.kwad.components.core.video.DetailVideoView.a
            public final void onClickRootView() {
                videoViewClickListener.onClickRootView();
            }
        });
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void updateTextureViewGravity(int i) {
        this.SB.updateTextureViewGravity(i);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final int getTextureViewGravity() {
        return this.SB.getTextureViewGravity();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayerView
    public final void setRadius(float f) {
        this.SB.setRadius(f);
    }
}
