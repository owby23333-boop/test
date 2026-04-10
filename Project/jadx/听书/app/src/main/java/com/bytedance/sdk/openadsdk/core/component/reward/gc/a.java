package com.bytedance.sdk.openadsdk.core.component.reward.gc;

import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a implements z.g {
    private long dl;
    private long g;
    long z;

    public a() {
        uy.ls().z(this);
    }

    public void dl() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.g;
        if (j != 0) {
            this.z += jCurrentTimeMillis - j;
        }
        this.g = jCurrentTimeMillis;
    }

    public void a() {
        if (this.g == 0) {
            return;
        }
        this.z += System.currentTimeMillis() - this.g;
        this.g = 0L;
        this.dl = 0L;
    }

    public long z(TimeUnit timeUnit) {
        if (timeUnit != null) {
            return timeUnit.convert(this.z, TimeUnit.MILLISECONDS);
        }
        return this.z;
    }

    public void gc() {
        this.g = 0L;
        this.dl = 0L;
        this.z = 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void g() {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void z() {
        dl();
    }
}
