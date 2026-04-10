package com.bytedance.sdk.openadsdk.core.gc.gc.z;

import com.bytedance.sdk.openadsdk.core.gc.gc.gc;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends g {
    private final AtomicBoolean z = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f1103a = new AtomicBoolean(false);
    private final AtomicBoolean wp = new AtomicBoolean(false);

    public dl(gz.g gVar) {
        this.gc = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void z(gc gcVar, int i, String str) {
        this.gz = gcVar;
        this.fo = i;
        this.uy = str;
        this.g.set(true);
        this.wp.set(true);
        z();
    }

    public void z() {
        if (this.f1103a.get() && this.kb != 2 && this.e != null) {
            z(this.e, 2);
            return;
        }
        if (this.wp.get()) {
            if (this.m != null) {
                z(this.m, 1);
            } else if (this.dl.get()) {
                z(null, 3);
            }
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar, int i) {
        if (!this.z.compareAndSet(false, true)) {
            if (dlVar != null) {
                dlVar.dl();
                return;
            }
            return;
        }
        this.kb = i;
        if (i == 3) {
            if (this.gz != null) {
                this.gz.z(this.fo, this.uy);
            }
        } else if (dlVar != null) {
            dlVar.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void z(boolean z) {
        if (z) {
            this.f1103a.set(true);
            z();
        } else {
            this.dl.set(true);
            z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void dl() {
        this.wp.set(true);
        z();
    }
}
