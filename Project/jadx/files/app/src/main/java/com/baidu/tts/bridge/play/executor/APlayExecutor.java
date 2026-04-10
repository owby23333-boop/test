package com.baidu.tts.bridge.play.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.life.ASafeLife;
import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public abstract class APlayExecutor extends ASafeLife implements IPlayExecutor {
    protected PlayListener mPlayListener;
    protected volatile APlayExecutorState mState;

    public APlayExecutorState getState() {
        return this.mState;
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void play() {
        this.mState.play();
    }

    protected void playError(ResponseBag responseBag) {
        PlayListener playListener = this.mPlayListener;
        if (playListener != null) {
            playListener.onError(responseBag);
        }
    }

    protected void playFinished(ResponseBag responseBag) {
        PlayListener playListener;
        if (!isNeedToNotify() || (playListener = this.mPlayListener) == null) {
            return;
        }
        playListener.onPlayFinished(responseBag);
    }

    protected void playProgressUpdate(ResponseBag responseBag) {
        PlayListener playListener;
        if (!isNeedToNotify() || (playListener = this.mPlayListener) == null) {
            return;
        }
        playListener.onPlayProgressUpdate(responseBag);
    }

    protected void playStart(ResponseBag responseBag) {
        PlayListener playListener;
        if (!isNeedToNotify() || (playListener = this.mPlayListener) == null) {
            return;
        }
        playListener.onPlayStart(responseBag);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void put(ResponseBag responseBag) {
        this.mState.put(responseBag);
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected TtsError safeCreate() {
        return this.mState.create();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeDestroy() {
        this.mState.destroy();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safePause() {
        this.mState.pause();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeResume() {
        this.mState.resume();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeStart() {
        this.mState.start();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeStop() {
        this.mState.stop();
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setAudioAttributes(int i2, int i3) {
        return this.mState.setAudioAttributes(i2, i3);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setAudioSampleRate(int i2) {
        return this.mState.setAudioSampleRate(i2);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setAudioStreamType(int i2) {
        return this.mState.setAudioStreamType(i2);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void setPlayListener(PlayListener playListener) {
        this.mState.setPlayListener(playListener);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public <T> void setPlayerParams(T t2) {
        this.mState.setPlayerParams(t2);
    }

    public void setState(APlayExecutorState aPlayExecutorState) {
        this.mState = aPlayExecutorState;
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setStereoVolume(float f2, float f3) {
        return this.mState.setStereoVolume(f2, f3);
    }
}
