package com.baidu.tts.bridge.engine.synthesizer;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public interface ISynthesizer {
    int freeCustomResource(CustomResourceParams customResourceParams);

    TtsError initial();

    int loadCustomResource(CustomResourceParams customResourceParams);

    int loadEnglishModel(EnglishModelParams englishModelParams);

    int loadModel(ModelParams modelParams);

    TtsError release();

    <T> void setParam(T t2);

    void setSynthesizeListener(SynthesizeListener synthesizeListener);

    TtsError synthesize(TextParams textParams) throws InterruptedException;
}
