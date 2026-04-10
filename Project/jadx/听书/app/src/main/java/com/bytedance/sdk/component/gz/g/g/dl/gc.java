package com.bytedance.sdk.component.gz.g.g.dl;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    protected final com.bytedance.sdk.component.gz.g.g.g dl;
    protected final com.bytedance.sdk.component.gz.z.gc g;
    private volatile a z;

    public void dl() {
    }

    public gc(com.bytedance.sdk.component.gz.z.gc gcVar, com.bytedance.sdk.component.gz.g.g.g gVar) {
        this.g = gcVar;
        this.dl = gVar;
    }

    public a gc() {
        if (this.z == null) {
            synchronized (this) {
                if (this.z == null) {
                    this.z = new a();
                }
            }
        }
        return this.z;
    }

    public void m() {
        com.bytedance.sdk.component.gz.z.a aVarA = this.g.a();
        if (aVarA == null || aVarA.pf() == null) {
            a aVarGc = gc();
            aVarGc.z(this);
            aVarGc.start();
            return;
        }
        dl();
    }

    public Looper e() {
        com.bytedance.sdk.component.gz.z.a aVarA = this.g.a();
        if (aVarA == null || aVarA.pf() == null) {
            return gc().getLooper();
        }
        return aVarA.pf();
    }
}
