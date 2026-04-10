package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum AiEvent implements Const {
    EVENT_UNKNOWN(0),
    EVENT_START(1),
    EVENT_TIMEOUT(3),
    EVENT_END(2),
    EVENT_PROGRESS(4);

    private final int value;

    AiEvent(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static AiEvent valueOf(int i) {
        if (i == 0) {
            return EVENT_UNKNOWN;
        }
        if (i == 1) {
            return EVENT_START;
        }
        if (i == 2) {
            return EVENT_END;
        }
        if (i == 3) {
            return EVENT_TIMEOUT;
        }
        if (i == 4) {
            return EVENT_PROGRESS;
        }
        return null;
    }
}
