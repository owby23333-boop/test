package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum VarType implements Const {
    STRING(0),
    INT(1),
    DOUBLE(2),
    BOOL(3),
    UNKNOWN(-1);

    private final int value;

    VarType(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static VarType valueOf(int i) {
        if (i == 0) {
            return STRING;
        }
        if (i == 1) {
            return INT;
        }
        if (i == 2) {
            return DOUBLE;
        }
        if (i == 3) {
            return BOOL;
        }
        if (i == -1) {
            return UNKNOWN;
        }
        throw new IllegalArgumentException("type not supported");
    }
}
