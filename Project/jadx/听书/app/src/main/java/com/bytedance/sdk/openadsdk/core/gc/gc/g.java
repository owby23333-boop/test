package com.bytedance.sdk.openadsdk.core.gc.gc;

import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.gc.z.z f1101a;
    protected com.bytedance.sdk.openadsdk.core.gc.dl.z dl;
    protected int g;
    private com.bytedance.sdk.openadsdk.core.gc.z.z gc;
    protected gz.g z;

    public g(int i) {
        this.g = i;
        this.z = gz.z(i);
        dl();
        a();
    }

    private int g() {
        gz.g gVar = this.z;
        if (gVar == null) {
            return -2;
        }
        if (gVar.e() && zw.g().cn()) {
            return this.z.a();
        }
        return -1;
    }

    private void dl() {
        int iG = g();
        if (iG == -1) {
            this.dl = new com.bytedance.sdk.openadsdk.core.gc.dl.dl(this.g);
            return;
        }
        if (iG == 0) {
            this.dl = new com.bytedance.sdk.openadsdk.core.gc.dl.g(this.g);
            return;
        }
        if (iG == 1) {
            this.dl = new com.bytedance.sdk.openadsdk.core.gc.dl.gc(this.g);
        } else if (iG == 3) {
            this.dl = new com.bytedance.sdk.openadsdk.core.gc.dl.a(this.g);
        } else {
            this.dl = z.g(this.g);
        }
    }

    private void a() {
        int i = this.g;
        if (i == 1) {
            this.gc = new com.bytedance.sdk.openadsdk.core.gc.dl(this, this.g);
            this.f1101a = new com.bytedance.sdk.openadsdk.core.component.z.g(this);
            return;
        }
        switch (i) {
            case 5:
                this.gc = new com.bytedance.sdk.openadsdk.core.gc.dl(this, this.g);
                this.f1101a = new com.bytedance.sdk.openadsdk.core.component.dl.g(this);
                break;
            case 6:
                this.f1101a = new com.bytedance.sdk.openadsdk.core.component.a.g(this);
                break;
            case 7:
                this.f1101a = new com.bytedance.sdk.openadsdk.core.component.reward.z.e(this);
                break;
            case 8:
                this.f1101a = new com.bytedance.sdk.openadsdk.core.component.reward.z.z(this);
                break;
            case 9:
                this.gc = new com.bytedance.sdk.openadsdk.core.gc.dl(this, this.g);
                this.f1101a = new com.bytedance.sdk.openadsdk.core.component.g.g(this);
                break;
        }
    }

    protected boolean z(na naVar) {
        return com.bytedance.sdk.openadsdk.core.live.g.z().dl(naVar) != 3;
    }

    public com.bytedance.sdk.openadsdk.core.gc.dl.z z() {
        return this.dl;
    }

    protected com.bytedance.sdk.openadsdk.core.gc.z.z z(boolean z) {
        com.bytedance.sdk.openadsdk.core.gc.z.z zVar;
        return (!z || (zVar = this.gc) == null) ? this.f1101a : zVar;
    }
}
