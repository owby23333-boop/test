package com.baidu.tts.flyweight.error;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.enumtype.TtsErrorEnum;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ATtsError extends Throwable {
    private static final long serialVersionUID = -717142028074771327L;
    protected TtsErrorEnum mTtsErrorEnum;

    public ATtsError(TtsErrorEnum ttsErrorEnum) {
        this.mTtsErrorEnum = ttsErrorEnum;
    }

    public abstract int getDetailCode(TtsError ttsError);

    public abstract String getDetailMessage(TtsError ttsError);

    public TtsErrorEnum getTtsErrorEnum() {
        return this.mTtsErrorEnum;
    }
}
