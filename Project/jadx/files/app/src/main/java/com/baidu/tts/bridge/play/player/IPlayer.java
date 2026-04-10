package com.baidu.tts.bridge.play.player;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public interface IPlayer {
    TtsError initial();

    void pause();

    void play();

    TtsError put(ResponseBag responseBag);

    TtsError release();

    void resume();

    int setAudioAttributes(int i2, int i3);

    int setAudioSampleRate(int i2);

    int setAudioStreamType(int i2);

    <T> void setParam(T t2);

    void setPlayListener(PlayListener playListener);

    int setStereoVolume(float f2, float f3);

    void stop();
}
