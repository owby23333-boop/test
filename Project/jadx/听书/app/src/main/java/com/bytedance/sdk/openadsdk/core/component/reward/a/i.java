package com.bytedance.sdk.openadsdk.core.component.reward.a;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;

/* JADX INFO: loaded from: classes2.dex */
public class i extends z {
    public static int g(na naVar) {
        return 1;
    }

    public static boolean z(na naVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
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

    public i(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return sv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fv.g(this.g.sz());
        if (m()) {
            this.fo.gc(8);
            this.fo.m(8);
            this.fv.z(false);
        } else {
            this.fo.gc(0);
            this.fo.m(0);
            this.fv.gc(true);
            this.z.t();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void ls() {
        super.ls();
        this.fv.g(this.g.sz());
        this.fv.gc(true);
        this.fo.m(0);
        this.fo.gc(0);
        this.z.t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void b() {
        if (gb.p(this.g)) {
            boolean z = !gb.dl();
            boolean zDl = gb.dl();
            this.z.dl(0);
            if (uf() > na() || this.pf) {
                com.bytedance.sdk.openadsdk.core.gz.a.z = 0;
                this.fv.z(this.v, this.v ? "领取成功" : "", z ? "跳过" : "", zDl, true);
                this.z.vm();
                return;
            }
            int iM = m(true);
            int iM2 = m(false);
            com.bytedance.sdk.openadsdk.core.gz.a.z = iM;
            boolean z2 = uf() > this.h.dl() || this.z.y();
            this.fv.z(this.v, iM2 + "s" + (this.v ? "后可领取奖励" : ""), z && z2 ? "跳过" : "", zDl && z2, z2);
            g(iM);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected boolean zx() {
        if (!this.v) {
            return false;
        }
        if (vm.z(this.g) == 2 && vm.g(this.g) == 3) {
            return false;
        }
        return (vm.z(this.g) == 2 && vm.g(this.g) == 7) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }
}
