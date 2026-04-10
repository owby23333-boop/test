package com.bytedance.sdk.openadsdk.core.kb.dl.dl;

import com.bytedance.sdk.openadsdk.core.iq.tb;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private boolean gc = false;
    private int m = 0;
    private boolean e = false;

    public void g(boolean z) {
        this.gc = z;
    }

    public void z(int i) {
        this.m = i;
    }

    public void dl(boolean z) {
        this.e = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.dl.z
    protected boolean dl() {
        this.dl = 1;
        boolean z = m.f1219a;
        int iWp = tb.wp(this.g);
        if (z) {
            iWp = 0;
            m.f1219a = false;
        }
        if (this.e) {
            return a();
        }
        if (this.gc) {
            int i = this.m;
            if (i == 2) {
                return a();
            }
            if (iWp == 2 && i == 1) {
                return a();
            }
        }
        if (iWp == 0) {
            return a();
        }
        return true;
    }
}
