package com.baidu.tts.aop.tts;

import android.content.Context;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.TtsEnum;
import com.baidu.tts.life.ILife;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.param.TtsParams;

/* JADX INFO: loaded from: classes2.dex */
public interface ITts extends ILife {
    AuthInfo auth(TtsEnum ttsEnum);

    int freeCustomResource(CustomResourceParams customResourceParams);

    TtsEnum getMode();

    TtsListener getTtsListener();

    TtsParams getTtsParams();

    int loadCustomResource(CustomResourceParams customResourceParams);

    int loadEnglishModel(EnglishModelParams englishModelParams);

    int loadModel(ModelParams modelParams);

    int setAudioAttributes(int i2, int i3);

    int setAudioSampleRate(int i2);

    int setAudioStreamType(int i2);

    void setContext(Context context);

    void setMode(TtsEnum ttsEnum);

    int setParam(KeyEnum keyEnum, String str);

    int setStereoVolume(float f2, float f3);

    void setTtsListener(TtsListener ttsListener);

    void speak(TextParams textParams);

    void synthesize(TextParams textParams);
}
