package com.bytedance.sdk.component.dl.z;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends tb {
    private tb z;

    public fo(tb tbVar) {
        if (tbVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.z = tbVar;
    }

    public final tb z() {
        return this.z;
    }

    public final fo z(tb tbVar) {
        if (tbVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.z = tbVar;
        return this;
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public tb z(long j, TimeUnit timeUnit) {
        return this.z.z(j, timeUnit);
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public long n_() {
        return this.z.n_();
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public boolean dl() {
        return this.z.dl();
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public long o_() {
        return this.z.o_();
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public tb z(long j) {
        return this.z.z(j);
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public tb gc() {
        return this.z.gc();
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public tb m() {
        return this.z.m();
    }

    @Override // com.bytedance.sdk.component.dl.z.tb
    public void e() throws IOException {
        this.z.e();
    }
}
