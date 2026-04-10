package com.baidu.tts.bridge.engine.executor;

import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public class SynthesizeEngineState extends AEngineState {
    public SynthesizeEngineState(EngineExecutor engineExecutor) {
        super(engineExecutor);
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.life.ILife
    public void destroy() {
        this.mEngineExecutor.machineStop();
        this.mEngineExecutor.machineDestroy();
        changeState((AEngineState) this.mEngineExecutor.getUninitialEngineState());
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.life.ILife
    public void pause() {
        this.mEngineExecutor.machinePause();
        changeState((AEngineState) this.mEngineExecutor.getPauseEngineState());
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.life.ILife
    public void stop() {
        this.mEngineExecutor.machineStop();
        changeState((AEngineState) this.mEngineExecutor.getInitializedEngineState());
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void synthesize(TextParams textParams) {
        this.mEngineExecutor.machineSynthesize(textParams);
    }
}
