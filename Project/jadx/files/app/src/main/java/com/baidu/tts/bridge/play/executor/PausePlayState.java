package com.baidu.tts.bridge.play.executor;

import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public class PausePlayState extends APlayExecutorState {
    public PausePlayState(PlayExecutor playExecutor) {
        super(playExecutor);
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.life.ILife
    public void destroy() {
        this.mMachine.machineStop();
        this.mMachine.machineDestroy();
        changeState((APlayExecutorState) this.mMachine.getUninitialState());
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void play() {
        stop();
        if (this.mMachine.getState() != this) {
            this.mMachine.play();
        }
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void put(ResponseBag responseBag) {
        this.mMachine.machinePut(responseBag);
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.life.ILife
    public void resume() {
        changeState((APlayExecutorState) this.mMachine.getRunningState());
        this.mMachine.machineResume();
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.life.ILife
    public void stop() {
        this.mMachine.machineStop();
        changeState((APlayExecutorState) this.mMachine.getInitializedState());
    }
}
