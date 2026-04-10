package com.baidu.tts.state.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.play.player.AudioTrackPlayer;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public class UninitialState extends ATtsState {
    public UninitialState(Tts tts) {
        super(tts);
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        TtsError ttsErrorMachineCreate = this.mTts.machineCreate();
        if (ttsErrorMachineCreate != null) {
            TtsErrorEnum errorEnum = ttsErrorMachineCreate.getErrorEnum();
            if (errorEnum != null) {
                if (TtsErrorEnum.ErrorType.MIX_ERROR.equals(errorEnum.getType())) {
                    changeState((ATtsState) this.mTts.getInitializedState());
                }
            }
        } else {
            changeState((ATtsState) this.mTts.getInitializedState());
        }
        return ttsErrorMachineCreate;
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(ModelParams modelParams) {
        return this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
        this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
        this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioAttributes(int i2, int i3) {
        AudioTrackPlayer.AudioTrackPlayerParams audioTrackPlayerParams = this.mTts.getTtsParams().getAudioTrackPlayerParams();
        audioTrackPlayerParams.setUsage(i2);
        audioTrackPlayerParams.setContentType(i3);
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioSampleRate(int i2) {
        this.mTts.getTtsParams().getAudioTrackPlayerParams().setSampleRate(i2);
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i2) {
        this.mTts.getTtsParams().getAudioTrackPlayerParams().setStreamType(i2);
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f2, float f3) {
        AudioTrackPlayer.AudioTrackPlayerParams audioTrackPlayerParams = this.mTts.getTtsParams().getAudioTrackPlayerParams();
        audioTrackPlayerParams.setLeftVolume(f2);
        audioTrackPlayerParams.setRightVolume(f3);
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(TextParams textParams) {
        this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
        this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
        this.mTts.errorUninitial();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(TextParams textParams) {
        this.mTts.errorUninitial();
    }
}
