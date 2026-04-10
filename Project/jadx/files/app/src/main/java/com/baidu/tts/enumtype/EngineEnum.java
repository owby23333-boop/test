package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum EngineEnum {
    ONLINE(0, "online engine"),
    OFFLINE(1, "offline engine"),
    MIX(2, "online and offline mix engine");

    private final String mName;
    private final int mType;

    EngineEnum(int i2, String str) {
        this.mType = i2;
        this.mName = str;
    }

    public static EngineEnum getEngineEnum(int i2) {
        for (EngineEnum engineEnum : values()) {
            if (engineEnum.getType() == i2) {
                return engineEnum;
            }
        }
        return null;
    }

    public String getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }
}
