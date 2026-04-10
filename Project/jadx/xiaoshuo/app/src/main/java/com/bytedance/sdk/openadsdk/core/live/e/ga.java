package com.bytedance.sdk.openadsdk.core.live.e;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class ga implements Serializable {
    private volatile boolean e = true;
    private volatile boolean bf = false;
    private volatile long d = 0;

    public boolean bf() {
        return this.bf;
    }

    public long d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public void bf(boolean z) {
        this.bf = z;
    }

    public void e(boolean z) {
        this.e = z;
    }

    public void e(long j) {
        this.d = j;
    }
}
