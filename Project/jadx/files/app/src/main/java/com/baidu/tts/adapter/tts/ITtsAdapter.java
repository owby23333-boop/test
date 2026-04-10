package com.baidu.tts.adapter.tts;

import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.bridge.play.executor.IPlayExecutor;
import com.baidu.tts.life.ILife;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public interface ITtsAdapter extends ILife {
    int freeCustomResource(CustomResourceParams customResourceParams);

    IPlayExecutor getPlayExecutor();

    int loadCustomResource(CustomResourceParams customResourceParams);

    int loadEnglishModel(EnglishModelParams englishModelParams);

    int loadModel(ModelParams modelParams);

    int setStereoVolume(float f2, float f3);

    void setTtsListener(TtsListener ttsListener);

    void speak(TextParams textParams);

    void synthesize(TextParams textParams);
}
