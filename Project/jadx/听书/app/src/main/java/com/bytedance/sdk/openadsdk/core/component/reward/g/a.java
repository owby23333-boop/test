package com.bytedance.sdk.openadsdk.core.component.reward.g;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.iq;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f954a;
    private na dl;
    private final TTBaseVideoActivity g;
    private gc gc;
    private boolean m = false;
    protected boolean z;

    public a(TTBaseVideoActivity tTBaseVideoActivity) {
        this.g = tTBaseVideoActivity;
    }

    public void z(g gVar, na naVar, String str, gc gcVar) {
        if (this.m) {
            return;
        }
        this.m = true;
        this.f954a = gVar;
        this.dl = naVar;
        this.gc = gcVar;
    }

    public void z() {
        if (iq.g(this.dl) && !this.f954a.mc()) {
            a();
        }
    }

    public void z(boolean z) {
        g gVar = this.f954a;
        if (gVar != null && gVar.l()) {
            this.z = z;
            this.gc.a(z);
            this.f954a.z(this.z);
        }
    }

    public void g() {
        if (iq.g(this.dl)) {
            if (this.f954a.mc() || a()) {
                boolean z = !this.z;
                this.z = z;
                this.f954a.z(z);
            }
        }
    }

    public void z(boolean z, boolean z2) {
        this.f954a.io();
        z(z);
        g(z2);
    }

    public void dl() {
        this.f954a.hh();
        this.gc.z(this.g.gb().yx());
    }

    public boolean a() {
        g gVar = this.f954a;
        if (gVar != null) {
            return gVar.h();
        }
        return false;
    }

    public boolean gc() {
        if (iq.dl(this.dl)) {
            return this.f954a.lq();
        }
        return false;
    }

    public void g(boolean z) {
        this.f954a.m(z);
    }

    public void z(int i, int i2) {
        this.f954a.g(i, i2);
    }

    public void z(na naVar) {
        this.dl = naVar;
    }

    public boolean m() {
        return this.z;
    }
}
