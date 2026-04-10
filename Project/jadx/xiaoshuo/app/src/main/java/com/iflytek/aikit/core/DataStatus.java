package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public enum DataStatus implements Const {
    BEGIN(0),
    CONTINUE(1),
    END(2),
    ONCE(3);

    private final int value;

    DataStatus(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public AiStatus next() {
        return AiStatus.valueOf(this.value);
    }

    public static DataStatus valueOf(int i) {
        if (i == 0) {
            return BEGIN;
        }
        if (i == 1) {
            return CONTINUE;
        }
        if (i == 2) {
            return END;
        }
        if (i == 3) {
            return ONCE;
        }
        throw new IllegalArgumentException("type not supported");
    }
}
