package com.baidu.tts.bridge.play;

import com.baidu.tts.bridge.play.player.AudioTrackPlayer;
import com.baidu.tts.bridge.play.player.IPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class PlayerFactory {
    private static volatile PlayerFactory mInstance;

    private PlayerFactory() {
    }

    private AudioTrackPlayer createAudioTrackPlayer() {
        return new AudioTrackPlayer();
    }

    public static PlayerFactory getInstance() {
        if (mInstance == null) {
            synchronized (PlayerFactory.class) {
                if (mInstance == null) {
                    mInstance = new PlayerFactory();
                }
            }
        }
        return mInstance;
    }

    public IPlayer createPlayer() {
        return createAudioTrackPlayer();
    }
}
