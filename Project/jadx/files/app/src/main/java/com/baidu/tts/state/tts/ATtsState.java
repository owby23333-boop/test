package com.baidu.tts.state.tts;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.TtsEnum;
import com.baidu.tts.param.TtsParams;
import com.baidu.tts.state.IState;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ATtsState implements IState<ATtsState>, ITts {
    protected Tts mTts;

    public ATtsState(Tts tts) {
        this.mTts = tts;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public AuthInfo auth(TtsEnum ttsEnum) {
        return this.mTts.machineAuth(ttsEnum);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsEnum getMode() {
        return this.mTts.machineGetMode();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsListener getTtsListener() {
        return this.mTts.machineGetTtsListener();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsParams getTtsParams() {
        return this.mTts.machineGetTtsParams();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setContext(Context context) {
        this.mTts.machineSetContext(context);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setMode(TtsEnum ttsEnum) {
        this.mTts.machineSetMode(ttsEnum);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setParam(KeyEnum keyEnum, String str) {
        return this.mTts.machineSetParam(keyEnum, str);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setTtsListener(TtsListener ttsListener) {
        this.mTts.machineSetTtsListener(ttsListener);
    }

    @Override // com.baidu.tts.state.IState
    public void changeState(ATtsState aTtsState) {
        this.mTts.setState(aTtsState);
    }
}
