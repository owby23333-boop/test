package com.baidu.tts.bridge.play.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public class UninitialPlayState extends APlayExecutorState {
    public UninitialPlayState(PlayExecutor playExecutor) {
        super(playExecutor);
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.life.ILife
    public TtsError create() {
        TtsError ttsErrorMachineCreate = this.mMachine.machineCreate();
        changeState((APlayExecutorState) this.mMachine.getInitializedState());
        return ttsErrorMachineCreate;
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void play() {
        create();
        if (this.mMachine.getState() != this) {
            this.mMachine.play();
        }
    }

    @Override // com.baidu.tts.bridge.play.executor.APlayExecutorState, com.baidu.tts.bridge.play.executor.IPlayExecutor
    public void put(ResponseBag responseBag) {
        create();
        if (this.mMachine.getState() != this) {
            this.mMachine.put(responseBag);
        }
    }
}
