package com.baidu.tts.state.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public class InitializedState extends ATtsState {
    public InitializedState(Tts tts) {
        super(tts);
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
        this.mTts.machineDestroy();
        changeState((ATtsState) this.mTts.getUninitialState());
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mTts.machineFreeCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mTts.machineLoadCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mTts.machineLoadEnglishModel(englishModelParams);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(ModelParams modelParams) {
        return this.mTts.machineLoadModel(modelParams);
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
        this.mTts.machinePause();
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
        this.mTts.machineResume();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioAttributes(int i2, int i3) {
        return this.mTts.machineSetAudioAttributes(i2, i3);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioSampleRate(int i2) {
        return this.mTts.machineSetAudioSampleRate(i2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i2) {
        return this.mTts.machineSetAudioStreamType(i2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f2, float f3) {
        return this.mTts.machineSetStereoVolume(f2, f3);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(TextParams textParams) {
        this.mTts.machineSpeak(textParams);
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
        this.mTts.machineStart();
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
        this.mTts.machineStop();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(TextParams textParams) {
        this.mTts.machineSynthesize(textParams);
    }
}
