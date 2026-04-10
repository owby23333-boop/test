package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public enum gz {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f262a;

    gz(int i) {
        this.f262a = i;
    }

    public static gz z(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
