package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum DataType implements Const {
    TEXT(0),
    AUDIO(1),
    IMAGE(2),
    VIDEO(3),
    PER(4),
    OTHER(-1);

    private final int value;

    DataType(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static DataType valueOf(int i) {
        DataType dataType = TEXT;
        if (i == dataType.value) {
            return dataType;
        }
        DataType dataType2 = AUDIO;
        if (i == dataType2.value) {
            return dataType2;
        }
        DataType dataType3 = IMAGE;
        if (i == dataType3.value) {
            return dataType3;
        }
        DataType dataType4 = VIDEO;
        if (i == dataType4.value) {
            return dataType4;
        }
        DataType dataType5 = PER;
        if (i == dataType5.value) {
            return dataType5;
        }
        DataType dataType6 = OTHER;
        if (i == dataType6.value) {
            return dataType6;
        }
        throw new IllegalArgumentException("type not supported");
    }
}
