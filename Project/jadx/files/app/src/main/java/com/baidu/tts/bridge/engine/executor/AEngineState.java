package com.baidu.tts.bridge.engine.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.bridge.engine.synthesizer.ISynthesizer;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.state.IState;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AEngineState implements IState<AEngineState>, IEngineExecutor {
    protected EngineExecutor mEngineExecutor;

    public AEngineState(EngineExecutor engineExecutor) {
        this.mEngineExecutor = engineExecutor;
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mEngineExecutor.machineFreeCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mEngineExecutor.machineLoadCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mEngineExecutor.machineLoadEnglishModel(englishModelParams);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadModel(ModelParams modelParams) {
        return this.mEngineExecutor.machineLoadModel(modelParams);
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void registerSynthesizeListener(SynthesizeListener synthesizeListener) {
        this.mEngineExecutor.machineRegisteSynthesizeListener(synthesizeListener);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void removeSynthesizeListener(SynthesizeListener synthesizeListener) {
        this.mEngineExecutor.machineRemoveSynthesizeListener(synthesizeListener);
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public <T> void setParam(T t2) {
        this.mEngineExecutor.machineSetParam(t2);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void setSynthesizer(ISynthesizer iSynthesizer) {
        this.mEngineExecutor.machineSetSynthesizer(iSynthesizer);
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void synthesize(TextParams textParams) {
    }

    @Override // com.baidu.tts.state.IState
    public void changeState(AEngineState aEngineState) {
        this.mEngineExecutor.setState(aEngineState);
    }
}
