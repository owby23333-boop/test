package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);

    private final int e;

    YogaLogLevel(int i) {
        this.e = i;
    }

    public static YogaLogLevel fromInt(int i) {
        if (i == 0) {
            return ERROR;
        }
        if (i == 1) {
            return WARN;
        }
        if (i == 2) {
            return INFO;
        }
        if (i == 3) {
            return DEBUG;
        }
        if (i == 4) {
            return VERBOSE;
        }
        if (i == 5) {
            return FATAL;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
