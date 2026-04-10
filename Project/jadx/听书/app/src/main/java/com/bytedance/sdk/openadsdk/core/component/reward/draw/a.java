package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.bytedance.sdk.openadsdk.core.component.reward.m.g {
    private boolean mc;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.m.g, com.bytedance.sdk.openadsdk.core.video.g.z
    protected int zw() {
        return 4;
    }

    public a(Context context, ViewGroup viewGroup, na naVar) {
        super(context, viewGroup, naVar, null);
        z(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.g.z
    protected void m(boolean z) {
        super.m(z);
    }

    public boolean io() {
        return p() != null && p().v();
    }

    public boolean uf() {
        return this.mc;
    }

    public void e(boolean z) {
        this.mc = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.m.g, com.bytedance.sdk.openadsdk.core.video.g.z, com.bykv.vk.openvk.component.video.api.a.dl
    public void gz() {
        if (this.mc) {
            return;
        }
        super.gz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.g.z, com.bykv.vk.openvk.component.video.api.a.dl
    public void uy() {
        this.mc = false;
        super.uy();
    }
}
