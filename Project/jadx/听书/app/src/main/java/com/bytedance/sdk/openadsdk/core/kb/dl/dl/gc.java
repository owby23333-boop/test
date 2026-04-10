package com.bytedance.sdk.openadsdk.core.kb.dl.dl;

import com.bytedance.sdk.openadsdk.core.iq.tb;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {
    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.dl.z
    protected boolean dl() {
        this.dl = 2;
        int i = tb.i(this.g);
        if (i == 2) {
            return false;
        }
        if (i == 0) {
            return a();
        }
        return true;
    }
}
