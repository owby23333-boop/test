package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.t;
import com.bytedance.sdk.openadsdk.core.un.iq;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends z {
    int gk;
    boolean lq;
    int x;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return true;
    }

    public gz(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
        this.gk = 0;
        this.x = 0;
        this.lq = false;
    }

    public static boolean z(na naVar) {
        return iq.dl(naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        return com.bytedance.sdk.openadsdk.res.gc.z(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View uy() {
        if (js.a(this.g)) {
            this.kb = new RewardJointEndCardFrameLayout(this.z, this.g);
        }
        return super.uy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z, com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void dl() {
        this.fv.z(4);
        this.tb.z();
        this.z.js();
        if (js.kb(this.g)) {
            this.fv.g(true);
        }
        this.gk = iq.gc(this.g);
        this.x = iq.m(this.g);
        if (js.a(this.g)) {
            this.z.m();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
        return js.a(this.g) && na.g(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int e(boolean z) {
        int i;
        if (js.kb(this.g) || (i = this.gk) == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min(i, 27.0f)) - uf());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int eo() {
        if (js.kb(this.g) || this.gk == 0) {
            return 0;
        }
        return Math.max(0, ((int) Math.min((this.gk * this.g.kg()) / 100.0f, 27.0f)) - uf());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fv.z(true);
        this.fo.m(8);
        if (js.z(this.g)) {
            me();
        } else {
            this.fv.gc(true);
            this.fv.g(this.g.sz());
        }
    }

    public void me() {
        int iDa = this.g.da();
        if (iDa == 0) {
            this.fo.gc(0);
            this.fv.gc(true);
            this.fv.g(this.g.sz());
        } else {
            if (iDa != 1) {
                if (iDa != 3) {
                    return;
                }
                this.fv.gc(false);
                this.fv.g(false);
                this.fv.z(false, null, null, true, true);
                return;
            }
            this.fo.gc(0);
            this.fv.g(this.g.sz());
            if (js.a(this.g)) {
                this.fv.gc(na.g(this.g));
            } else {
                this.fv.gc(com.bytedance.sdk.openadsdk.hh.uy.z(this.g));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gz() {
        super.gz();
        com.bytedance.sdk.openadsdk.core.playable.g.z().z(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void g(boolean z) {
        super.g(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void v() {
        super.v();
        this.z.wj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void dl(boolean z) {
        super.dl(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void pf() {
        super.pf();
        com.bytedance.sdk.openadsdk.core.playable.g.z().g(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean x() {
        if (ti() > 0) {
            return false;
        }
        if (!js.a(this.g) && t.z(this.g) == 0) {
            return this.tb.tb();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void b() {
        if (js.kb(this.g)) {
            return;
        }
        int iUf = uf();
        int i = this.gk;
        int i2 = i - iUf;
        if (iUf >= i) {
            this.fv.z(false, null, null, true, true);
            if (!js.kb(this.g)) {
                this.z.wp();
            }
        } else {
            int i3 = this.x;
            if (i3 >= i) {
                this.fv.z(false, String.valueOf(i2), null, false, false);
            } else if (iUf >= i3) {
                this.fv.z(false, String.valueOf(i2), "跳过", false, true);
            } else {
                this.fv.z(false, String.valueOf(i2), (this.x - iUf) + "s后可跳过", false, false);
            }
        }
        this.z.dl(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected boolean zx() {
        return js.a(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public g.z z(na naVar, final com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        if (this.q.gc()) {
            return new g.z(false, 0, "");
        }
        this.z.na();
        this.z.wj();
        com.bytedance.sdk.openadsdk.core.component.reward.dl.gz gzVar = new com.bytedance.sdk.openadsdk.core.component.reward.dl.gz(this.z, naVar);
        gzVar.z(this.tb.tb());
        gzVar.z(oq());
        return gzVar.g(new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.gz.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z();
                }
                gz.this.z.xl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.g();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }

    public static int g(na naVar) {
        return js.z(naVar) ? 6 : 0;
    }
}
