package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum TtsEnum {
    ONLINE(0, "just online"),
    OFFLINE(1, "just offline"),
    MIX(2, "if online cannot use switch from online to offline");

    private final String mDescription;
    private final int mMode;

    TtsEnum(int i2, String str) {
        this.mMode = i2;
        this.mDescription = str;
    }

    public static TtsEnum getTtsEnum(int i2) {
        for (TtsEnum ttsEnum : values()) {
            if (ttsEnum.getMode() == i2) {
                return ttsEnum;
            }
        }
        return null;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getMode() {
        return this.mMode;
    }
}
