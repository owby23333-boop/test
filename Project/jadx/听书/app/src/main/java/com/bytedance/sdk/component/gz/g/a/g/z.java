package com.bytedance.sdk.component.gz.g.a.g;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private int g;
    private int z;

    public int z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    z(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.z = i;
        this.g = i2;
    }

    public static z z(int i, int i2) {
        return new z(i, i2, 172800000L);
    }

    public static z z(int i, int i2, long j) {
        return new z(i, i2, j);
    }

    public static z dl() {
        return new z(1, 100, 172800000L);
    }
}
