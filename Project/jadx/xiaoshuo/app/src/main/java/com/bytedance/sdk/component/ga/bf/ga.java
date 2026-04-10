package com.bytedance.sdk.component.ga.bf;

import com.bytedance.sdk.component.ga.p;

/* JADX INFO: loaded from: classes.dex */
public class ga implements p {
    private long bf;
    private long d;
    private long e;

    public void bf(long j) {
        this.bf = j;
    }

    public void d(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.e = j;
    }

    @Override // com.bytedance.sdk.component.ga.p
    public long e() {
        return this.bf;
    }
}
