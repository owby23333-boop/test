package com.baidu.tts.bridge.engine.synthesizer;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ASynthesizer implements ISynthesizer {
    protected SynthesizeListener mSynthesizeListener;

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return 0;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError initial() {
        return null;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return 0;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadModel(ModelParams modelParams) {
        return 0;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError release() {
        return null;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public <T> void setParam(T t2) {
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public void setSynthesizeListener(SynthesizeListener synthesizeListener) {
        this.mSynthesizeListener = synthesizeListener;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError synthesize(TextParams textParams) throws InterruptedException {
        return null;
    }

    protected void synthesizeDataArrived(ResponseBag responseBag) {
        SynthesizeListener synthesizeListener = this.mSynthesizeListener;
        if (synthesizeListener != null) {
            synthesizeListener.onSynthesizeDataArrived(responseBag);
        }
    }
}
