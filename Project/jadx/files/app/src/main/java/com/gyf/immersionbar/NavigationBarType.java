package com.gyf.immersionbar;

/* JADX INFO: loaded from: classes2.dex */
public enum NavigationBarType {
    CLASSIC(0),
    GESTURES(1),
    GESTURES_THREE_STAGE(2),
    DOUBLE(3),
    UNKNOWN(-1);


    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f16376s;

    NavigationBarType(int i2) {
        this.f16376s = i2;
    }

    public int getType() {
        return this.f16376s;
    }
}
