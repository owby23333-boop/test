package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public enum v {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f265a;

    v(int i) {
        this.f265a = i;
    }

    public int z() {
        return this.f265a;
    }

    public static v z(int i) {
        if (i == 0) {
            return NO_WRAP;
        }
        if (i == 1) {
            return WRAP;
        }
        if (i == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static v z(String str) {
        str.hashCode();
        switch (str) {
            case "nowrap":
                return NO_WRAP;
            case "wrap":
                return WRAP;
            case "wrap_reverse":
                return WRAP_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
