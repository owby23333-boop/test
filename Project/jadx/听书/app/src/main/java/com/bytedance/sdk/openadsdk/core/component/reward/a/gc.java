package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {
    public static int g(na naVar) {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected boolean qd() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected boolean zx() {
        return true;
    }

    public gc(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        if (this.dl == 2) {
            int iOu = this.g.ou();
            if (iOu == 3) {
                return com.bytedance.sdk.openadsdk.res.gc.p(this.z);
            }
            if (iOu == 33) {
                return com.bytedance.sdk.openadsdk.res.gc.fv(this.z);
            }
            return com.bytedance.sdk.openadsdk.res.gc.js(this.z);
        }
        int iOu2 = this.g.ou();
        if (iOu2 == 3) {
            return com.bytedance.sdk.openadsdk.res.gc.tb(this.z);
        }
        if (iOu2 == 33) {
            return com.bytedance.sdk.openadsdk.res.gc.q(this.z);
        }
        return com.bytedance.sdk.openadsdk.res.gc.iq(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z) {
        this.fo = new com.bytedance.sdk.openadsdk.core.component.reward.layout.m(this.z, this.g, z);
        return this.fo;
    }

    public static boolean z(na naVar) {
        return (naVar == null || na.g(naVar)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
        if (this.uy.m()) {
            return this.uy.uy();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fo.gc(8);
        this.fo.m(8);
        this.fv.gc(com.bytedance.sdk.openadsdk.hh.uy.z(this.g));
        this.fv.g(this.g.sz());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void b() {
        super.b();
        if (gb.p(this.g)) {
            this.z.dl(0);
            int iUf = uf();
            if (iUf > na() || this.pf) {
                com.bytedance.sdk.openadsdk.core.gz.a.z = 0;
                this.fv.z(this.v, this.v ? "领取成功" : "", null, true, true);
                this.z.vm();
                if (this.uy == null || zw() != 7) {
                    return;
                }
                this.uy.z("0", iUf, 0, false);
                return;
            }
            int iM = m(true);
            int iM2 = m(false);
            com.bytedance.sdk.openadsdk.core.gz.a.z = iM;
            boolean z = iUf > this.h.dl() || this.z.y();
            this.fv.z(this.v, iM2 + "s" + (this.v ? "后可领取奖励" : ""), null, z, z);
            g(iM);
            if (this.uy == null || zw() != 7) {
                return;
            }
            this.uy.z(String.valueOf(iM2), iUf, 0, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }
}
