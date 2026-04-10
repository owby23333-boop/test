package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.hh.uy;

/* JADX INFO: loaded from: classes3.dex */
class dl extends com.bytedance.sdk.openadsdk.core.video.g.z {
    private boolean mc;

    @Override // com.bytedance.sdk.openadsdk.core.video.g.z
    protected boolean v_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.g.z
    protected int zw() {
        return 5;
    }

    protected dl(Context context, ViewGroup viewGroup, na naVar, com.bytedance.sdk.openadsdk.core.g.z zVar) {
        super(context, viewGroup, naVar, zVar);
        this.mc = true;
        z(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.g.z
    protected void m(boolean z) {
        super.m(z);
        if (this.mc) {
            if (!uy.z(this.m) || gc()) {
                g();
            }
        }
    }

    public void io() {
        ec();
    }

    public void e(boolean z) {
        this.mc = z;
    }
}
