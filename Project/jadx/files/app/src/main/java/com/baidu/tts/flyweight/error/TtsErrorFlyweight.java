package com.baidu.tts.flyweight.error;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.umeng.message.proguard.ad;

/* JADX INFO: loaded from: classes2.dex */
public class TtsErrorFlyweight extends ATtsError {
    private static final long serialVersionUID = -8910898441870026746L;

    public TtsErrorFlyweight(TtsErrorEnum ttsErrorEnum) {
        super(ttsErrorEnum);
    }

    @Override // com.baidu.tts.flyweight.error.ATtsError
    public int getDetailCode(TtsError ttsError) {
        return this.mTtsErrorEnum.getId();
    }

    @Override // com.baidu.tts.flyweight.error.ATtsError
    public String getDetailMessage(TtsError ttsError) {
        int code = ttsError.getCode();
        String message = ttsError.getMessage();
        Throwable throwable = ttsError.getThrowable();
        String str = ad.f20405r + this.mTtsErrorEnum.getId() + ad.f20406s + this.mTtsErrorEnum.getMessage();
        if (message != null) {
            str = str + "[(" + code + ad.f20406s + message + "]";
        } else if (code != 0) {
            str = str + "[(" + code + ")]";
        }
        if (throwable == null) {
            return str;
        }
        return str + "[(cause)" + throwable.toString() + "]";
    }
}
