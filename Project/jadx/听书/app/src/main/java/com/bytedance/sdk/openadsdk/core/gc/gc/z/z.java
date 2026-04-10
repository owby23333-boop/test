package com.bytedance.sdk.openadsdk.core.gc.gc.z;

import com.bytedance.sdk.openadsdk.core.gc.gc.gc;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends g {
    private final AtomicBoolean z = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f1104a = new AtomicBoolean(false);

    public abstract void z();

    public z(gz.g gVar) {
        this.gc = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void z(gc gcVar, int i, String str) {
        this.gz = gcVar;
        this.fo = i;
        this.uy = str;
        this.f1104a.set(true);
        g();
    }

    public void g() {
        if (this.dl.get() && this.e != null) {
            z(this.e, 2);
        } else if (this.f1104a.get()) {
            if (this.m != null) {
                z(this.m, 1);
            } else {
                z(null, 3);
            }
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar, int i) {
        if (this.z.compareAndSet(false, true)) {
            if (i == 3) {
                if (this.gz != null) {
                    this.gz.z(this.fo, this.uy);
                }
            } else if (dlVar != null) {
                dlVar.z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void z(boolean z) {
        if (z) {
            this.dl.set(true);
            g();
        } else {
            this.g.set(true);
            z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void dl() {
        this.f1104a.set(true);
        g();
    }
}
