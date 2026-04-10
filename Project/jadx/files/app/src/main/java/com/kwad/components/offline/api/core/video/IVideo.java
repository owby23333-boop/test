package com.kwad.components.offline.api.core.video;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IVideo {
    IKsMediaPlayer createMediaPlayer(IKsMediaPlayerView iKsMediaPlayerView);

    BaseKsMediaPlayerView createMediaPlayerView(Context context);
}
