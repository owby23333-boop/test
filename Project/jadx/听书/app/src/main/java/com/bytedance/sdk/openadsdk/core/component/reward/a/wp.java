package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.iq;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends z {
    int gk;
    private com.bytedance.sdk.openadsdk.core.i.m lq;
    int x;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return false;
    }

    public wp(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
        this.gk = 0;
        this.x = 0;
        com.bytedance.sdk.openadsdk.core.i.m mVar = new com.bytedance.sdk.openadsdk.core.i.m(naVar);
        this.lq = mVar;
        mVar.z(true);
    }

    public static boolean z(na naVar) {
        return naVar.sy() == 1 && js.z(naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void g(boolean z) {
        super.g(z);
        this.lq.dl();
        if (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.z) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).fo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void dl(boolean z) {
        super.dl(z);
        if (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.z) {
            if (((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).m()) {
                this.lq.z(((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).gc().get());
            }
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).gz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void pf() {
        super.pf();
        if ((this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.z) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).m()) {
            this.lq.a();
        }
        this.fo.uy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void v() {
        super.v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fo.gc(0);
        this.fv.z(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
            this.fv.gc(true);
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
            this.fv.g(false);
        } else {
            this.fv.g(this.g.sz());
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.dl(this.g)) {
            this.fv.dl(true);
            this.fv.gc(true);
            this.fv.z(this.v, ti() + "s" + (this.v ? "后可领取奖励" : ""), null, true, true);
        } else {
            this.fv.gc(false);
            this.fv.z(false, null, null, true, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gc(boolean z) {
        super.gc(z);
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).g(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean x() {
        if (ti() > 0) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g)) {
            return true;
        }
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).z(0);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int e(boolean z) {
        if ((this.tb.mc() && js.z(this.g)) || this.gk == 0) {
            return 0;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
            return Math.max(this.gk - uf(), 0);
        }
        return Math.max(Math.min(this.gk, 27) - uf(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int eo() {
        if ((this.tb.mc() && js.z(this.g)) || this.gk == 0) {
            return 0;
        }
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
            return Math.max(this.gk - uf(), 0);
        }
        return Math.max(((int) Math.min((this.gk * this.g.kg()) / 100.0f, 27.0f)) - uf(), 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gz() {
        JSONObject jSONObjectDl;
        super.gz();
        com.bytedance.sdk.openadsdk.core.playable.g.z().z(this.g);
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
            com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVarL = this.g.l();
            this.gk = 30;
            if (zVarL != null && (jSONObjectDl = zVarL.dl()) != null) {
                this.gk = jSONObjectDl.optInt("reward_time", 30);
            }
        } else {
            this.gk = iq.gc(this.g);
        }
        this.x = iq.m(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        FrameLayout frameLayout = new FrameLayout(this.z);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z, com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void dl() {
        this.fv.z(4);
        this.fo.dl(true);
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).z(Math.max(0, this.gk - uf()));
        }
        this.z.g(true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z) {
        this.fo = new com.bytedance.sdk.openadsdk.core.component.reward.layout.z(this.z, this.g, z, this.lq, this.fv);
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public g.z z(final na naVar, final com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        this.z.na();
        this.z.wj();
        com.bytedance.sdk.openadsdk.core.component.reward.dl.gz gzVar = new com.bytedance.sdk.openadsdk.core.component.reward.dl.gz(this.z, naVar);
        gzVar.z(this.tb.tb());
        gzVar.z(oq());
        return gzVar.g(new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.wp.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z();
                }
                if (com.bytedance.sdk.openadsdk.core.ugeno.uy.a(naVar) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) wp.this.fo).a()) {
                    return;
                }
                wp.this.z.xl();
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
    public void iq() {
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g) && ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).dl()) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).z(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void b() {
        int iUf = uf();
        int iMax = Math.max(0, this.gk - iUf);
        if (!this.tb.mc()) {
            int i = this.gk;
            if (iUf >= i) {
                if (com.bytedance.sdk.openadsdk.core.ugeno.uy.dl(this.g)) {
                    this.fv.z(this.v, this.v ? "领取成功" : "", null, true, true);
                } else {
                    this.fv.z(false, null, null, true, true);
                }
                this.z.wp();
            } else if (this.x >= i) {
                this.fv.z(false, String.valueOf(iMax), null, false, false);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.uy.dl(this.g)) {
                this.fv.z(this.v, iMax + "s" + (this.v ? "后可领取奖励" : ""), null, this.x <= iUf, true);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g) || com.bytedance.sdk.openadsdk.core.ugeno.uy.a(this.g)) {
                if (iUf >= this.x) {
                    this.fv.z(false, null, null, true, true);
                }
            } else if (iUf >= this.x) {
                this.fv.z(false, String.valueOf(iMax), "跳过", false, true);
            } else {
                this.fv.z(false, String.valueOf(iMax), (this.x - iUf) + "s后可跳过", false, false);
            }
        }
        this.z.dl(0);
        if (com.bytedance.sdk.openadsdk.core.ugeno.uy.gc(this.g)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).z(iMax);
        }
        if (iMax == 0 && (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.z)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.z) this.fo).e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }

    public static int g(na naVar) {
        return com.bytedance.sdk.openadsdk.core.ugeno.uy.dl(naVar) ? 6 : 7;
    }
}
