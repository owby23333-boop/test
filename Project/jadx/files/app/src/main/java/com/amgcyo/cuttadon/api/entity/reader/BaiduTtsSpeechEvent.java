package com.amgcyo.cuttadon.api.entity.reader;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BaiduTtsSpeechEvent implements Serializable {
    private boolean isStopSpeech;

    public BaiduTtsSpeechEvent() {
    }

    public boolean isStopSpeech() {
        return this.isStopSpeech;
    }

    public void setStopSpeech(boolean z2) {
        this.isStopSpeech = z2;
    }

    public BaiduTtsSpeechEvent(boolean z2) {
        this.isStopSpeech = z2;
    }
}
