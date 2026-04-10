package com.bytedance.sdk.component.p.e.tg.bf;

/* JADX INFO: loaded from: classes.dex */
public class e {
    final int bf;
    final int e;

    public e(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.e = i;
        this.bf = i2;
    }

    public static e d() {
        return new e(1, 100, 172800000L);
    }

    public int bf() {
        return this.bf;
    }

    public int e() {
        return this.e;
    }

    public static e e(int i, int i2) {
        return new e(i, i2, 172800000L);
    }
}
