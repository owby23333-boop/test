package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BaiduTtsModel implements Serializable {
    private int ttsModel;
    private int tts_type;

    public BaiduTtsModel(int i2, int i3) {
        this.ttsModel = i2;
        this.tts_type = i3;
    }

    public int getTtsModel() {
        return this.ttsModel;
    }

    public int getTts_type() {
        return this.tts_type;
    }

    public void setTtsModel(int i2) {
        this.ttsModel = i2;
    }

    public void setTts_type(int i2) {
        this.tts_type = i2;
    }

    public BaiduTtsModel() {
    }
}
