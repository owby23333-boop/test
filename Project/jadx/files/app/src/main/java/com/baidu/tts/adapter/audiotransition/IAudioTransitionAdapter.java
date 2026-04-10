package com.baidu.tts.adapter.audiotransition;

import com.baidu.tts.adapter.IAdapter;

/* JADX INFO: loaded from: classes2.dex */
public interface IAudioTransitionAdapter<S, T> extends IAdapter {
    S getAdaptedData(T t2);

    void initial();

    void release();

    void start();

    void stop();
}
