package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends dl {
    public gc(TTBaseVideoActivity tTBaseVideoActivity, na naVar, com.bytedance.sdk.openadsdk.core.component.reward.g.g gVar, com.bytedance.sdk.openadsdk.core.component.reward.g.gc gcVar, boolean z) {
        super(tTBaseVideoActivity, naVar, gVar, gcVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void dl(View view) {
        super.dl(view);
        this.m.dl("playable");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void g(View view) {
        super.g(view);
        if (js.a(this.g)) {
            this.m.un();
        } else {
            this.m.ti();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void z(View view) {
        super.z(view);
        if (z()) {
            return;
        }
        this.m.bv().z();
        if (js.kb(this.g) || uy.gc(this.g) || uy.a(this.g)) {
            this.m.uy();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar = new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                gc.this.m.v();
                gc.this.m.g();
            }
        };
        if (z(uyVar)) {
            this.e--;
        } else {
            uyVar.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void m(View view) {
        super.m(view);
        if (uy.gc(this.g) || uy.a(this.g)) {
            this.m.uy();
        } else {
            z();
        }
    }
}
