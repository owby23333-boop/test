package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum ErrType implements Const {
    AUTH(0),
    HTTP(1),
    UNKNOWN(-1);

    private final int value;

    ErrType(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static ErrType valueOf(int i) {
        return i == 0 ? AUTH : i == 1 ? HTTP : UNKNOWN;
    }
}
