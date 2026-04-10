package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum CodeType implements Const {
    CODEC_ENCODE(0),
    CODEC_DECODE(1);

    private final int value;

    CodeType(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static CodeType valueOf(int i) {
        if (i == 0) {
            return CODEC_ENCODE;
        }
        if (i == 1) {
            return CODEC_DECODE;
        }
        return null;
    }
}
