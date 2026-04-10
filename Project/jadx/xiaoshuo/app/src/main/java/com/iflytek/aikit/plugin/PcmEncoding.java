package com.iflytek.aikit.plugin;

/* JADX INFO: loaded from: classes7.dex */
public enum PcmEncoding {
    ENCODING_DEFAULT(1),
    ENCODING_PCM_16BIT(2),
    ENCODING_PCM_8BIT(3);

    private final int value;

    PcmEncoding(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
