package com.bytedance.sdk.openadsdk.core.f;

/* JADX INFO: loaded from: classes10.dex */
public enum e {
    USE_KWS(0),
    USE_ALOG(1),
    USE_PITAYA(2),
    USE_OTHER(3);

    private long ga;
    private long vn;

    e(int i) {
        if (i < 0 || i > 63) {
            throw new IllegalArgumentException("bit argument illegal exception,range [0,63]");
        }
        this.ga = 1 << i;
        this.vn = i;
    }

    public long e() {
        return this.ga;
    }
}
