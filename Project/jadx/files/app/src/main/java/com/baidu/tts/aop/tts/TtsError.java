package com.baidu.tts.aop.tts;

import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorFlyweight;

/* JADX INFO: loaded from: classes2.dex */
public class TtsError {
    private int mCode;
    private String mMessage;
    private Throwable mThrowable;
    private TtsErrorFlyweight mTtsErrorFlyweight;

    public int getCode() {
        return this.mCode;
    }

    public int getDetailCode() {
        TtsErrorFlyweight ttsErrorFlyweight = this.mTtsErrorFlyweight;
        return ttsErrorFlyweight != null ? ttsErrorFlyweight.getDetailCode(this) : this.mCode;
    }

    public String getDetailMessage() {
        TtsErrorFlyweight ttsErrorFlyweight = this.mTtsErrorFlyweight;
        if (ttsErrorFlyweight != null) {
            return ttsErrorFlyweight.getDetailMessage(this);
        }
        String str = this.mMessage;
        return str != null ? str : "TtsErrorFlyweight is null";
    }

    public TtsErrorEnum getErrorEnum() {
        TtsErrorFlyweight ttsErrorFlyweight = this.mTtsErrorFlyweight;
        if (ttsErrorFlyweight == null) {
            return null;
        }
        return ttsErrorFlyweight.getTtsErrorEnum();
    }

    public String getMessage() {
        return this.mMessage;
    }

    public Throwable getThrowable() {
        return this.mThrowable;
    }

    public TtsErrorFlyweight getTtsErrorFlyweight() {
        return this.mTtsErrorFlyweight;
    }

    public void setCode(int i2) {
        this.mCode = i2;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setThrowable(Throwable th) {
        this.mThrowable = th;
    }

    public void setTtsErrorFlyweight(TtsErrorFlyweight ttsErrorFlyweight) {
        this.mTtsErrorFlyweight = ttsErrorFlyweight;
    }
}
