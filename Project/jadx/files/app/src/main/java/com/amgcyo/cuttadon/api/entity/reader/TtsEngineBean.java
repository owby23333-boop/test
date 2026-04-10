package com.amgcyo.cuttadon.api.entity.reader;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class TtsEngineBean implements Serializable {
    private String title;
    private int tts_type;

    public TtsEngineBean(String str, int i2) {
        this.title = str;
        this.tts_type = i2;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTts_type() {
        return this.tts_type;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTts_type(int i2) {
        this.tts_type = i2;
    }
}
