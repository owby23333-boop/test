package com.bytedance.sdk.openadsdk.core.component.reward.gc;

import com.bytedance.sdk.openadsdk.core.component.reward.g.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f960a;
    private final com.bytedance.sdk.openadsdk.core.component.reward.a.z e;
    private int gc;
    private final m m;
    protected int z = 0;
    protected int g = 0;
    protected int dl = 1000;

    public dl(boolean z, na naVar, m mVar, com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar) {
        int iM;
        this.m = mVar;
        this.e = zVar;
        if (z) {
            iM = zw.g().gc(eo.fo(naVar));
        } else {
            iM = zw.g().m(eo.fo(naVar));
        }
        this.f960a = iM;
    }

    public long z() {
        return this.m.gk();
    }

    public int g() {
        return this.gc;
    }

    public void z(int i) {
        this.gc += i;
    }

    public int dl() {
        return this.f960a;
    }

    public int a() {
        return this.e.ti();
    }

    public int gc() {
        return this.z;
    }

    public int m() {
        return this.g;
    }

    public void e() {
        this.z++;
    }

    public void gz() {
        this.g++;
    }

    public void g(int i) {
        this.g = i;
    }

    public void dl(int i) {
        this.dl = i;
    }

    public int fo() {
        return this.dl;
    }
}
