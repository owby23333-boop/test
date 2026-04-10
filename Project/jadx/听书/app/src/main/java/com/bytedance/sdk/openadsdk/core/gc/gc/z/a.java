package com.bytedance.sdk.openadsdk.core.gc.gc.z;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.core.gc.gc.gc;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g implements Runnable {
    private final AtomicBoolean z = new AtomicBoolean(false);
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f1102a = new AtomicBoolean(false);
    private final AtomicBoolean wp = new AtomicBoolean(false);

    public a(gz.g gVar) {
        this.gc = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void z(gc gcVar, int i, String str) {
        this.gz = gcVar;
        this.fo = i;
        this.uy = str;
        this.dl.set(true);
        this.wp.set(true);
        g();
    }

    public void z() {
        com.bytedance.sdk.component.utils.gz.g().postDelayed(this, a());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.z.set(true);
        g();
    }

    public void g() {
        if (this.wp.get()) {
            com.bytedance.sdk.component.utils.gz.g().removeCallbacks(this);
            if (this.m != null) {
                z(this.m, 1);
                return;
            } else {
                if (this.f1102a.get()) {
                    if (this.e != null) {
                        z(this.e, 2);
                        return;
                    } else {
                        z(null, 3);
                        return;
                    }
                }
                return;
            }
        }
        if (this.z.get() && this.f1102a.get()) {
            z(this.e, this.e != null ? 2 : 3);
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar, int i) {
        if (this.g.compareAndSet(false, true)) {
            this.kb = i;
            if (i == 3) {
                if (this.gz != null) {
                    this.gz.z(this.fo, this.uy);
                }
            } else if (dlVar != null) {
                dlVar.z();
            }
            if (i == 1 && this.e != null) {
                this.e.dl();
            }
            if (i != 2 || this.m == null) {
                return;
            }
            this.m.dl();
            return;
        }
        if (i == this.kb || dlVar == null) {
            return;
        }
        dlVar.dl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void z(boolean z) {
        this.f1102a.set(true);
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.z.g
    public void dl() {
        this.wp.set(true);
        g();
    }

    private long a() {
        return (this.gc == null || this.gc.m() <= 0) ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : this.gc.m();
    }
}
