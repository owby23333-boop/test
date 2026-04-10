package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum AiStatus implements Const {
    BEGIN(0),
    CONTINUE(1),
    END(2),
    ONCE(3);

    private final int value;

    AiStatus(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static AiStatus valueOf(int i) {
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
