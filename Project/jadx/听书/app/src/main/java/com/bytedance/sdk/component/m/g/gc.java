package com.bytedance.sdk.component.m.g;

import com.bytedance.sdk.component.m.gz;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements gz {
    private long dl;
    private long g;
    private long z;

    @Override // com.bytedance.sdk.component.m.gz
    public long getStartRequestTime() {
        return this.z;
    }

    public void z(long j) {
        this.z = j;
    }

    @Override // com.bytedance.sdk.component.m.gz
    public long getFirstFrameTime() {
        return this.g;
    }

    public void g(long j) {
        this.g = j;
    }

    @Override // com.bytedance.sdk.component.m.gz
    public long getEndRequestTime() {
        return this.dl;
    }

    public void dl(long j) {
        this.dl = j;
    }
}
