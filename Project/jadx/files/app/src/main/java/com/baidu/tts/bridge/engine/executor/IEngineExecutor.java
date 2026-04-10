package com.baidu.tts.bridge.engine.executor;

import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.bridge.engine.synthesizer.ISynthesizer;
import com.baidu.tts.life.ILife;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public interface IEngineExecutor extends ILife {
    int freeCustomResource(CustomResourceParams customResourceParams);

    int loadCustomResource(CustomResourceParams customResourceParams);

    int loadEnglishModel(EnglishModelParams englishModelParams);

    int loadModel(ModelParams modelParams);

    void registerSynthesizeListener(SynthesizeListener synthesizeListener);

    void removeSynthesizeListener(SynthesizeListener synthesizeListener);

    <T> void setParam(T t2);

    void setSynthesizer(ISynthesizer iSynthesizer);

    void synthesize(TextParams textParams);
}
