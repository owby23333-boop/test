package com.baidu.tts.bridge.play.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.state.IState;

/* JADX INFO: loaded from: classes2.dex */
public abstract class APlayExecutorState implements IState<APlayExecutorState>, IPlayExecutor {
    protected PlayExecutor mMachine;

    public APlayExecutorState(PlayExecutor playExecutor) {
        this.mMachine = playExecutor;
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void play() {
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void put(ResponseBag responseBag) {
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setAudioAttributes(int i2, int i3) {
        return this.mMachine.machinesetAudioAttributes(i2, i3);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setAudioSampleRate(int i2) {
        return this.mMachine.machineSetAudioSampleRate(i2);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setAudioStreamType(int i2) {
        return this.mMachine.machineSetAudioStreamType(i2);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void setPlayListener(PlayListener playListener) {
        this.mMachine.machineSetPlayerListener(playListener);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public <T> void setPlayerParams(T t2) {
        this.mMachine.machineSetPlayerParams(t2);
    }

    @Override // com.baidu.tts.bridge.play.executor.IPlayExecutor
    public int setStereoVolume(float f2, float f3) {
        return this.mMachine.machineSetStereoVolume(f2, f3);
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
    }

    @Override // com.baidu.tts.state.IState
    public void changeState(APlayExecutorState aPlayExecutorState) {
        this.mMachine.setState(aPlayExecutorState);
    }
}
