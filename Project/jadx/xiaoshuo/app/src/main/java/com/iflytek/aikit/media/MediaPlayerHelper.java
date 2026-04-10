package com.iflytek.aikit.media;

import android.content.Context;
import com.iflytek.aikit.media.player.PlayerListener;

/* JADX INFO: loaded from: classes7.dex */
public interface MediaPlayerHelper {
    void init(Context context, PlayerListener playerListener);

    boolean isPlaying();

    void pause();

    void play();

    void release();

    void resume();

    void stop();
}
