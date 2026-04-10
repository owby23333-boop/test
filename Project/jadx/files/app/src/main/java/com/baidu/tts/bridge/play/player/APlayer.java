package com.baidu.tts.bridge.play.player;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public abstract class APlayer implements IPlayer {
    protected PlayListener mPlayListener;

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public TtsError initial() {
        return null;
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public void pause() {
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public void play() {
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public TtsError put(ResponseBag responseBag) {
        return null;
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public TtsError release() {
        return null;
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public void resume() {
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public <T> void setParam(T t2) {
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public void setPlayListener(PlayListener playListener) {
        this.mPlayListener = playListener;
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public void stop() {
    }
}
