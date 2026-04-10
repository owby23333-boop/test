package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.g;
import com.bytedance.sdk.openadsdk.core.hh;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.ti;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e extends z {
    protected boolean gk;
    private boolean lq;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.g mc;
    private com.bytedance.sdk.openadsdk.core.g.z un;
    protected final AtomicBoolean x;

    public static int g(na naVar) {
        return 2;
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

    public e(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
        this.gk = false;
        this.x = new AtomicBoolean(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return sv() && vm.z(this.g) == 1;
    }

    public static boolean z(na naVar) {
        return com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        if (m()) {
            this.fv.g(false);
            this.fv.gc(false);
            this.fo.m(8);
            this.fo.gc(8);
            this.fo.dl(8);
            return;
        }
        this.fv.g(this.g.sz());
        this.fv.gc(true);
        this.fo.m(0);
        this.fo.gc(0);
        this.fo.dl(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        if (this.dl == 2) {
            return com.bytedance.sdk.openadsdk.res.gc.pf(this.z);
        }
        return com.bytedance.sdk.openadsdk.res.gc.ls(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z) {
        this.fo = new com.bytedance.sdk.openadsdk.core.component.reward.layout.gz(this.z, this.g, z);
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void ls() {
        super.ls();
        this.fv.g(this.g.sz());
        this.fv.gc(true);
        this.fo.m(0);
        this.fo.gc(0);
        this.fo.dl(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean p() {
        if (this.lq) {
            return true;
        }
        return (com.bytedance.sdk.openadsdk.core.live.g.z().g(this.g) || ec.dl(this.g)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(int i, int i2, Intent intent) {
        super.z(i, i2, intent);
        if (ec.dl(this.g) || i != 1 || intent == null || intent.getExtras() == null || this.lq) {
            return;
        }
        long j = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int iTi = (int) (((long) ti()) - j);
        this.z.z(iTi, false);
        if (j <= 0) {
            gz(true);
            a(0);
            this.lq = true;
            return;
        }
        z(iTi);
    }

    private void z(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j);
            if (this.uy == null || !this.uy.m()) {
                return;
            }
            this.uy.z("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void g(boolean z) {
        super.g(z);
        if (!com.bytedance.sdk.openadsdk.core.g.z().get("is_reward_deep_link_to_live", false) || ec.dl(this.g) || z) {
            return;
        }
        zw.z().z(nh(), new sy.a() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.e.1
            @Override // com.bytedance.sdk.openadsdk.core.sy.a
            public void z(int i, String str) {
                e.this.gz(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.sy.a
            public void z(hh.dl dlVar) {
                if (dlVar.dl == null) {
                    return;
                }
                boolean z2 = dlVar.dl.z();
                e.this.gz(z2);
                if (z2) {
                    e.this.z.a(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z);
            if (this.uy != null) {
                this.uy.z("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private JSONObject nh() {
        JSONObject jSONObject = new JSONObject();
        ti tiVarIa = this.g.ia();
        if (tiVarIa == null) {
            return jSONObject;
        }
        String strA = tiVarIa.a();
        if (TextUtils.isEmpty(strA)) {
            return jSONObject;
        }
        try {
            String strOptString = new JSONObject(strA).optString("token");
            jSONObject.put("req_id", tiVarIa.m());
            jSONObject.put("token", strOptString);
            jSONObject.put("action", "query_box");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void tb() {
        super.tb();
        me();
        if (this.uy.m()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.live.g.z().g(this.g)) {
            r();
            return;
        }
        if (ec.z(this.g) && this.mc == null && !com.bytedance.sdk.openadsdk.core.g.z().get("is_reward_deep_link_to_live", false) && ec.gc(this.g) != 1 && this.js.gk() >= ((long) ec.e(this.g)) * 1000) {
            this.x.set(true);
            if (this.js != null && this.js.g()) {
                this.z.na();
            }
            this.mc = new com.bytedance.sdk.openadsdk.core.component.reward.view.g(this.z, this.g, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.e.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.g.z
                public void z(Dialog dialog) {
                    e.this.mc.dismiss();
                    e.this.z.xl();
                    e.this.x.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.g.z
                public void g(Dialog dialog) {
                    if (e.this.un != null) {
                        HashMap map = new HashMap();
                        map.put("is_auto_click", Boolean.TRUE);
                        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) e.this.un.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(map);
                        e.this.un.z(null, new com.bytedance.sdk.openadsdk.core.iq.uy());
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.z, this.g, this.wp, 7) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.e.3
                @Override // com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
                public void z(View view, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
                    super.z(view, uyVar);
                    e.this.mc.dismiss();
                }
            };
            this.un = zVar;
            this.z.z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
            this.mc.z(this.un);
            if (this.z.isFinishing()) {
                return;
            }
            this.mc.show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean gk() {
        return this.x.get();
    }

    private void r() {
        if (this.gk || this.gz == null) {
            return;
        }
        if (((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).g().kb()) {
            this.gk = true;
            g(8, 0);
            return;
        }
        if (ec.z(this.g)) {
            int iGc = ec.gc(this.g);
            if (this.g.zr() == 2) {
                g(0, -1);
            }
            if (iGc != 3) {
                return;
            }
            long jE = ((long) ec.e(this.g)) * 1000;
            if (this.js.gk() >= jE) {
                g(8, 0);
                yz();
                this.gk = true;
                return;
            }
            g(0, (int) ((jE - this.js.gk()) / 1000));
        }
    }

    private void g(int i, int i2) {
        if (this.fo != null && (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.gz)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.gz) this.fo).z(i, i2);
        }
    }

    private void yz() {
        if (this.gz == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_auto_click", Boolean.TRUE);
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(map);
        this.gz.z(null, new com.bytedance.sdk.openadsdk.core.iq.uy());
    }

    public void me() {
        if (ec.z(this.g)) {
            ti tiVarIa = this.g.ia();
            if (tiVarIa != null || com.bytedance.sdk.openadsdk.core.live.g.z().g(this.g)) {
                int iTi = ti();
                if (tiVarIa != null) {
                    tiVarIa.z(iTi);
                }
                a(iTi);
            }
        }
    }

    private void a(int i) {
        if (this.gz != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(i);
        }
        if (this.zw != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(i);
        }
        if (this.iq != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.iq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }
}
