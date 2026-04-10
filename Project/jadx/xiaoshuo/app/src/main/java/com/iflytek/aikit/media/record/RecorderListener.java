package com.iflytek.aikit.media.record;

import com.iflytek.aikit.media.speech.SpeechError;

/* JADX INFO: loaded from: classes7.dex */
public interface RecorderListener {
    void onBuffer(byte[] bArr, int i, int i2);

    void onDecibel(int i);

    void onError(SpeechError speechError);

    void onRelease();

    void onStart(boolean z);
}
