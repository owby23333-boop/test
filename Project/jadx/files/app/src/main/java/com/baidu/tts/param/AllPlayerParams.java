package com.baidu.tts.param;

import com.baidu.tts.bridge.play.player.AudioTrackPlayer;
import com.baidu.tts.prototype.APrototype;

/* JADX INFO: loaded from: classes2.dex */
public class AllPlayerParams extends APrototype<AllPlayerParams> {
    private static final long serialVersionUID = 4733338498876964880L;
    private AudioTrackPlayer.AudioTrackPlayerParams mAudioTrackPlayerParams = new AudioTrackPlayer.AudioTrackPlayerParams();

    public AudioTrackPlayer.AudioTrackPlayerParams getAudioTrackPlayerParams() {
        return this.mAudioTrackPlayerParams;
    }

    public void setAudioTrackPlayerParams(AudioTrackPlayer.AudioTrackPlayerParams audioTrackPlayerParams) {
        this.mAudioTrackPlayerParams = audioTrackPlayerParams;
    }

    public void setStreamType(int i2) {
        this.mAudioTrackPlayerParams.setStreamType(i2);
    }
}
