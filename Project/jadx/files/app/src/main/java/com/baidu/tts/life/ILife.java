package com.baidu.tts.life;

import com.baidu.tts.aop.tts.TtsError;

/* JADX INFO: loaded from: classes2.dex */
public interface ILife {
    TtsError create();

    void destroy();

    void pause();

    void resume();

    void start();

    void stop();
}
