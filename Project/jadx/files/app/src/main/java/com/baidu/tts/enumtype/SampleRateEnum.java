package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum SampleRateEnum {
    HZ8K(8000, "8k"),
    HZ16K(16000, "16k"),
    HZ24K(24000, "24k"),
    HZ48K(48000, "48k");

    private final String mExpression;
    private final int mHz;

    SampleRateEnum(int i2, String str) {
        this.mHz = i2;
        this.mExpression = str;
    }

    public String getExpression() {
        return this.mExpression;
    }

    public int getHz() {
        return this.mHz;
    }
}
