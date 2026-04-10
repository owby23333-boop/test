package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum AudioDataFormat {
    PCM(1),
    MP3(3);

    private final int mDataType;

    AudioDataFormat(int i2) {
        this.mDataType = i2;
    }

    public int getDataType() {
        return this.mDataType;
    }
}
