package com.baidu.tts.client;

/* JADX INFO: loaded from: classes2.dex */
public interface SpeechSynthesizerListener {
    void onError(String str, SpeechError speechError);

    void onSpeechFinish(String str);

    void onSpeechProgressChanged(String str, int i2);

    void onSpeechStart(String str);

    void onSynthesizeDataArrived(String str, byte[] bArr, int i2, int i3);

    void onSynthesizeFinish(String str);

    void onSynthesizeStart(String str);
}
