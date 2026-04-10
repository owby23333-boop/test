package com.bytedance.sdk.openadsdk.core.tb;

/* JADX INFO: loaded from: classes2.dex */
public enum z {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);

    private long gc;
    private long m;

    z(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.gc = 1 << i;
        this.m = i;
    }

    public long z() {
        return this.gc;
    }
}
