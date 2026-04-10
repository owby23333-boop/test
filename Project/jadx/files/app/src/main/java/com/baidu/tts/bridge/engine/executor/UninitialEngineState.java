package com.baidu.tts.bridge.engine.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public class UninitialEngineState extends AEngineState {
    public UninitialEngineState(EngineExecutor engineExecutor) {
        super(engineExecutor);
    }

    private void notifyUninitializedError(ResponseBag responseBag) {
        responseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_ENGINE_UNINITIALIZED));
        this.mEngineExecutor.synthesizeError(responseBag);
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.life.ILife
    public TtsError create() {
        TtsError ttsErrorMachineCreate = this.mEngineExecutor.machineCreate();
        changeState((AEngineState) this.mEngineExecutor.getInitializedEngineState());
        return ttsErrorMachineCreate;
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        notifyUninitializedError(new ResponseBag());
        return -1;
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        notifyUninitializedError(new ResponseBag());
        return -1;
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        notifyUninitializedError(new ResponseBag());
        return -1;
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadModel(ModelParams modelParams) {
        notifyUninitializedError(new ResponseBag());
        return -1;
    }

    @Override // com.baidu.tts.bridge.engine.executor.AEngineState, com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void synthesize(TextParams textParams) {
        notifyUninitializedError(ResponseBag.newResponseBag(textParams));
    }
}
