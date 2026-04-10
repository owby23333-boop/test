package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public enum LogLvl implements Const {
    VERBOSE(0),
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5),
    OFF(100);

    private final int value;

    LogLvl(int i) {
        this.value = i;
    }

    @Override // com.iflytek.aikit.core.Const
    public int getValue() {
        return this.value;
    }

    public static LogLvl valueOf(int i) {
        if (i == 100) {
            return OFF;
        }
        if (i == 0) {
            return VERBOSE;
        }
        if (i == 1) {
            return DEBUG;
        }
        if (i == 2) {
            return INFO;
        }
        if (i == 3) {
            return WARN;
        }
        if (i == 4) {
            return ERROR;
        }
        if (i == 5) {
            return FATAL;
        }
        return null;
    }
}
