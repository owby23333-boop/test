package com.baidu.tts.bridge.play.executor;

import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.life.ILife;
import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public interface IPlayExecutor extends ILife {
    void play();

    void put(ResponseBag responseBag);

    int setAudioAttributes(int i2, int i3);

    int setAudioSampleRate(int i2);

    int setAudioStreamType(int i2);

    void setPlayListener(PlayListener playListener);

    <T> void setPlayerParams(T t2);

    int setStereoVolume(float f2, float f3);
}
