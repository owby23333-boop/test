package com.iflytek.aikit.core.media.player;

import com.iflytek.aikit.media.player.AudioParam;
import com.iflytek.aikit.media.player.SimplePlayer;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class AudioPlayer extends SimplePlayer {
    public AudioPlayer(SimplePlayer.PlayerListener playerListener) {
        super(playerListener);
    }

    public AudioPlayer(SimplePlayer.PlayerListener playerListener, AudioParam audioParam) {
        super(playerListener, audioParam);
    }
}
