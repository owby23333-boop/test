package com.baidu.tts.bridge.engine.executor;

import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public class InitializedEngineState extends AEngineState {
    public InitializedEngineState(EngineExecutor engineExecutor) {
        super(engineExecutor);
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.life.ILife
    public void destroy() {
        this.mEngineExecutor.machineDestroy();
        changeState((AEngineState) this.mEngineExecutor.getUninitialEngineState());
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.life.ILife
    public void start() {
        this.mEngineExecutor.machineStart();
        changeState((AEngineState) this.mEngineExecutor.getSynthesizeEngineState());
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void synthesize(TextParams textParams) {
        start();
        if (this.mEngineExecutor.getState() != this) {
            this.mEngineExecutor.synthesize(textParams);
        }
    }
}
