package com.bytedance.sdk.component.d.e;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zk extends dt {
    private dt e;

    public zk(dt dtVar) {
        if (dtVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.e = dtVar;
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public long b_() {
        return this.e.b_();
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public long c_() {
        return this.e.c_();
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public boolean d() {
        return this.e.d();
    }

    public final dt e() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public dt ga() {
        return this.e.ga();
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public void p() throws IOException {
        this.e.p();
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public dt vn() {
        return this.e.vn();
    }

    public final zk e(dt dtVar) {
        if (dtVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.e = dtVar;
        return this;
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public dt e(long j, TimeUnit timeUnit) {
        return this.e.e(j, timeUnit);
    }

    @Override // com.bytedance.sdk.component.d.e.dt
    public dt e(long j) {
        return this.e.e(j);
    }
}
