package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public enum AeeEvent implements Const {
    AEE_EVENT_UNKNOWN(0),
    AEE_EVENT_START(1),
    AEE_EVENT_END(2),
    AEE_EVENT_TIMEOUT(3),
    AEE_EVENT_PROGRESS(4);

    private final int value;

    AeeEvent(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static AeeEvent valueOf(int i) {
        if (i == 0) {
            return AEE_EVENT_UNKNOWN;
        }
        if (i == 1) {
            return AEE_EVENT_START;
        }
        if (i == 2) {
            return AEE_EVENT_END;
        }
        if (i == 3) {
            return AEE_EVENT_TIMEOUT;
        }
        if (i == 4) {
            return AEE_EVENT_PROGRESS;
        }
        return null;
    }
}
