package com.baidu.tts.flyweight.error;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.enumtype.TtsErrorEnum;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class TtsErrorPool {
    private static volatile TtsErrorPool mInstance;
    private Hashtable<TtsErrorEnum, TtsErrorFlyweight> mPool = new Hashtable<>();

    private TtsErrorPool() {
    }

    public static TtsErrorPool getInstance() {
        if (mInstance == null) {
            synchronized (TtsErrorPool.class) {
                if (mInstance == null) {
                    mInstance = new TtsErrorPool();
                }
            }
        }
        return mInstance;
    }

    public TtsError getTtsError(TtsErrorEnum ttsErrorEnum) {
        TtsErrorFlyweight ttsErrorFlyweight = getTtsErrorFlyweight(ttsErrorEnum);
        TtsError ttsError = new TtsError();
        ttsError.setTtsErrorFlyweight(ttsErrorFlyweight);
        return ttsError;
    }

    public TtsErrorFlyweight getTtsErrorFlyweight(TtsErrorEnum ttsErrorEnum) {
        TtsErrorFlyweight ttsErrorFlyweight = this.mPool.get(ttsErrorEnum);
        if (ttsErrorFlyweight != null) {
            return ttsErrorFlyweight;
        }
        TtsErrorFlyweight ttsErrorFlyweight2 = new TtsErrorFlyweight(ttsErrorEnum);
        this.mPool.put(ttsErrorEnum, ttsErrorFlyweight2);
        return ttsErrorFlyweight2;
    }

    public TtsError getTtsError(TtsErrorEnum ttsErrorEnum, Throwable th) {
        TtsError ttsError = getTtsError(ttsErrorEnum);
        ttsError.setThrowable(th);
        return ttsError;
    }

    public TtsError getTtsError(TtsErrorEnum ttsErrorEnum, int i2) {
        return getTtsError(ttsErrorEnum, i2, null);
    }

    public TtsError getTtsError(TtsErrorEnum ttsErrorEnum, String str) {
        return getTtsError(ttsErrorEnum, 0, str);
    }

    public TtsError getTtsError(TtsErrorEnum ttsErrorEnum, int i2, String str) {
        return getTtsError(ttsErrorEnum, i2, str, null);
    }

    public TtsError getTtsError(TtsErrorEnum ttsErrorEnum, int i2, String str, Throwable th) {
        TtsError ttsError = getTtsError(ttsErrorEnum);
        ttsError.setCode(i2);
        ttsError.setMessage(str);
        ttsError.setThrowable(th);
        return ttsError;
    }
}
