package com.iflytek.aikit.media.player;

/* JADX INFO: loaded from: classes7.dex */
public interface MediaPlayer {
    boolean pause();

    boolean resume();

    void setListener(PlayerListener playerListener);

    boolean stop();
}
