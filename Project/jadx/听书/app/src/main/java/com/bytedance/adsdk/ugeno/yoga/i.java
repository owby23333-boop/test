package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f263a;

    i(int i) {
        this.f263a = i;
    }

    public int z() {
        return this.f263a;
    }

    public static i z(int i) {
        if (i == 0) {
            return STATIC;
        }
        if (i == 1) {
            return RELATIVE;
        }
        if (i == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static i z(String str) {
        str.hashCode();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
