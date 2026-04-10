package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes2.dex */
public class a extends dl {
    public a(TTBaseVideoActivity tTBaseVideoActivity, na naVar, com.bytedance.sdk.openadsdk.core.component.reward.g.g gVar, com.bytedance.sdk.openadsdk.core.component.reward.g.gc gcVar, boolean z) {
        super(tTBaseVideoActivity, naVar, gVar, gcVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void dl(View view) {
        super.dl(view);
        this.m.dl(this.f969a.ti());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void g(View view) {
        super.g(view);
        this.m.ti();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void z(View view) {
        super.z(view);
        if (z()) {
            return;
        }
        this.m.bv().g();
        if (this.f969a.oq()) {
            this.m.g();
        } else if (this.m.gb().bv()) {
            g();
        } else {
            dl();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void m(View view) {
        super.m(view);
        z(view);
    }

    private void g() {
        uy uyVar = new uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.a.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                a.this.m.g();
            }
        };
        if (z(uyVar)) {
            this.e--;
        } else {
            uyVar.g();
        }
    }

    private void dl() {
        this.m.g();
    }
}
