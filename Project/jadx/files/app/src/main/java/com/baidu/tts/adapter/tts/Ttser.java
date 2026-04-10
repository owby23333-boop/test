package com.baidu.tts.adapter.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public class Ttser {
    private ITtsAdapter mTtsAdapter;

    public TtsError create() {
        return this.mTtsAdapter.create();
    }

    public void destroy() {
        this.mTtsAdapter.destroy();
    }

    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mTtsAdapter.freeCustomResource(customResourceParams);
    }

    public ITtsAdapter getTtsAdapter() {
        return this.mTtsAdapter;
    }

    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mTtsAdapter.loadCustomResource(customResourceParams);
    }

    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mTtsAdapter.loadEnglishModel(englishModelParams);
    }

    public int loadModel(ModelParams modelParams) {
        return this.mTtsAdapter.loadModel(modelParams);
    }

    public void pause() {
        this.mTtsAdapter.pause();
    }

    public void resume() {
        this.mTtsAdapter.resume();
    }

    public int setStereoVolume(float f2, float f3) {
        return this.mTtsAdapter.setStereoVolume(f2, f3);
    }

    public void setTtsAdapter(ITtsAdapter iTtsAdapter) {
        this.mTtsAdapter = iTtsAdapter;
    }

    public void setTtsListener(TtsListener ttsListener) {
        this.mTtsAdapter.setTtsListener(ttsListener);
    }

    public void speak(TextParams textParams) {
        this.mTtsAdapter.speak(textParams);
    }

    public void start() {
        this.mTtsAdapter.start();
    }

    public void stop() {
        this.mTtsAdapter.stop();
    }

    public void synthesize(TextParams textParams) {
        this.mTtsAdapter.synthesize(textParams);
    }
}
