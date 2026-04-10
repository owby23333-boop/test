package com.baidu.tts.bridge.play.executor;

import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public class InitializedPlayState extends APlayExecutorState {
    public InitializedPlayState(PlayExecutor playExecutor) {
        super(playExecutor);
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.life.ILife
    public void destroy() {
        this.mMachine.machineDestroy();
        changeState((APlayExecutorState) this.mMachine.getUninitialState());
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void play() {
        this.mMachine.machineStart();
        this.mMachine.machinePlay();
        changeState((APlayExecutorState) this.mMachine.getRunningState());
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void put(ResponseBag responseBag) {
        play();
        if (this.mMachine.getState() != this) {
            this.mMachine.put(responseBag);
        }
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.life.ILife
    public void start() {
        this.mMachine.machineStart();
        changeState((APlayExecutorState) this.mMachine.getRunningState());
    }
}
