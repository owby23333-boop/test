package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.a.fo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class m extends dl {
    public m(TTBaseVideoActivity tTBaseVideoActivity, na naVar, com.bytedance.sdk.openadsdk.core.component.reward.g.g gVar, com.bytedance.sdk.openadsdk.core.component.reward.g.gc gcVar, boolean z) {
        super(tTBaseVideoActivity, naVar, gVar, gcVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void dl(View view) {
        super.dl(view);
        this.m.dl("video_player");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void g(View view) {
        super.g(view);
        if (this.m.gb() instanceof fo) {
            this.m.ti();
        }
        this.m.un();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void z(View view) {
        super.z(view);
        if (z()) {
            return;
        }
        this.m.bv().z();
        if (this.m.gb().bv()) {
            g();
        } else {
            dl();
        }
    }

    private void g() {
        uy uyVar = new uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.m.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                m.this.m.v();
                m.this.m.eo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.m.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.m.g();
                    }
                }, 100L);
            }
        };
        int i = 2;
        int iGc = this.m.gc(2);
        if (this.g.d() == 7) {
            if (zw.g().e(String.valueOf(eo.fo(this.g))) && !this.m.jq()) {
                i = 1;
            }
            iGc = i;
        }
        if (iGc == 1) {
            if (z(uyVar)) {
                return;
            }
            uyVar.g();
            return;
        }
        this.m.dl();
    }

    private void dl() {
        uy uyVar = new uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.m.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                m.this.m.dl();
            }
        };
        if (z(uyVar)) {
            return;
        }
        uyVar.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void m(View view) {
        super.m(view);
        z(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.dl, com.bytedance.sdk.openadsdk.core.component.reward.top.g
    public void e(View view) {
        super.e(view);
        this.m.lw();
    }
}
