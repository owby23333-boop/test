package com.iflytek.aikit.media.player;

import com.iflytek.aikit.media.speech.SpeechError;

/* JADX INFO: loaded from: classes7.dex */
public interface PlayerListener {
    void onError(SpeechError speechError);

    void onFinish();

    void onPause();

    void onPercent(int i, int i2, int i3);

    void onResume();

    void onStart();

    void onStop();
}
