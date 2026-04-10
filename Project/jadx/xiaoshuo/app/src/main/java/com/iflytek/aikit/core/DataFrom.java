package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum DataFrom implements Const {
    MEM(0),
    FILE(1),
    UNKNOWN(-1);

    private final int value;

    DataFrom(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static DataFrom valueOf(int i) {
        if (i == 0) {
            return MEM;
        }
        if (i == 1) {
            return FILE;
        }
        if (i == -1) {
            return UNKNOWN;
        }
        throw new IllegalArgumentException("type not supported");
    }
}
