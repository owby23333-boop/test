package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.gz.g.z;
import com.bytedance.sdk.component.gz.z.dl;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.gz.a;
import com.bytedance.sdk.openadsdk.core.hh;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.x;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private String bm;
    private String me;
    private String nh;
    private String r;
    private dl tf;
    private int yz;
    private final int qd = 10111;
    private final int zx = 10112;
    private final int b = 10113;
    private final int lw = 10114;
    private final int rv = 10115;
    private final int tc = 10116;
    private final AtomicBoolean sd = new AtomicBoolean();

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean sy() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (gb.p(this.gc)) {
            this.wj.dl(a.g);
            a.dl = false;
            a.g = 0;
            a.z = this.wj.oq();
            dl(0);
        }
        if (gb.js(this.gc) && a.f1113a) {
            bm();
            a(4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String z() {
        return this.bm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void a() {
        dl dlVar = new dl() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.component.gz.z.dl
            public void z(String str, String str2) {
                if (TTRewardVideoActivity.this.gc != null) {
                    String strAq = TTRewardVideoActivity.this.gc.aq();
                    if (TextUtils.equals("show", str) && TextUtils.equals(str2, strAq)) {
                        TTRewardVideoActivity.this.sd.set(true);
                    }
                }
            }
        };
        this.tf = dlVar;
        z.z(dlVar);
        super.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void z(Intent intent) {
        super.z(intent);
        if (intent == null) {
            return;
        }
        this.me = intent.getStringExtra("media_extra");
        this.nh = intent.getStringExtra("user_id");
        this.r = intent.getStringExtra(MediationConstant.REWARD_NAME);
        this.bm = intent.getStringExtra("userData");
        this.yz = intent.getIntExtra(MediationConstant.REWARD_AMOUNT, 0);
        this.yx.z(intent.getBooleanExtra("is_play_again", false));
        this.yx.z(intent.getIntExtra("play_again_count", 0));
        this.yx.g(intent.getBooleanExtra("custom_play_again", false));
        this.yx.g(intent.getIntExtra("source_rit_id", 0));
        this.yx.z(intent.getStringExtra("reward_again_name"));
        this.yx.g(intent.getStringExtra("reward_again_amount"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected boolean z(Bundle bundle) {
        com.bytedance.sdk.component.a.g.dl dlVarZ = g.z();
        dlVarZ.put("is_reward_deep_link_to_live", false);
        dlVarZ.put("click_to_live_duration", System.currentTimeMillis());
        return super.z(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void tb() {
        super.tb();
        tc();
    }

    public void tc() {
        if (x.g(sy(), this.gc, true)) {
            if (this.f.z() > this.wj.ti()) {
                this.f.z(false);
            }
            int iMax = Math.max(this.wj.m(true) - this.f.z(), 0);
            int iM = this.wj.m(false) - this.f.z();
            if (this.f930a.containsKey(0)) {
                iMax = 999;
                iM = 999;
            }
            uy(iM);
            kb(iMax);
            if (this.f930a.containsKey(0)) {
                dl(0, true);
            }
            rv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public int h() {
        if (this.yz != 0 && !TextUtils.isEmpty(this.r)) {
            return this.yz;
        }
        if (gb.g(this.gc) == 0 || TextUtils.isEmpty(gb.z(this.gc))) {
            return 0;
        }
        return gb.g(this.gc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String gk() {
        if (this.yz == 0 || TextUtils.isEmpty(this.r)) {
            return (gb.g(this.gc) == 0 || TextUtils.isEmpty(gb.z(this.gc))) ? "" : gb.z(this.gc);
        }
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String x() {
        if (this.yx.z() && !TextUtils.isEmpty(this.yx.e()) && !TextUtils.isEmpty(this.yx.m())) {
            return this.yx.e();
        }
        return new StringBuilder().append(h()).toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String lq() {
        if (this.yx.z() && !TextUtils.isEmpty(this.yx.e()) && !TextUtils.isEmpty(this.yx.m())) {
            return this.yx.m();
        }
        return gk();
    }

    private void nh() {
        if (gb.e(this.gc) && this.ti.q() >= gb.uy(this.gc)) {
            if (this.wj.e() && this.gk != null && this.gk.fo() == 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("toast_text", gb.fo(this.gc));
                    this.gk.z("showToast", jSONObject);
                    return;
                } catch (JSONException e) {
                    wp.z(e);
                    return;
                }
            }
            oq.z(this.na, gb.fo(this.gc), 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void t() {
        super.t();
        if (gb.p(this.gc) || this.mc.h() || js.a(this.gc)) {
            return;
        }
        if (this.ti.mc()) {
            this.lq.z(false, null, null, true, true);
            return;
        }
        int iM = this.wj.m(true);
        int iM2 = this.wj.m(x.g(sy(), this.gc, true));
        if (me() || this.wj.p()) {
            this.lq.z(false, iM2 > 0 ? iM2 + "s" : "已领取奖励", "跳过", false, true);
        } else {
            this.lq.z(false, iM2 > 0 ? iM2 + "s" : "已领取奖励", null, false, false);
        }
        this.wj.g(iM);
    }

    public boolean me() {
        return Math.round(((float) (this.ti.gk() + (((long) this.wj.t()) * 1000))) / 1000.0f) >= this.wj.vm();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void dl(int i) {
        if (i != 0) {
            a(i);
            return;
        }
        if (this.wj.ti() > 0) {
            return;
        }
        if ((!gb.sy(this.gc) || this.e.get()) && this.wj.x()) {
            a(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    @HungeonFlag
    @DungeonFlag
    public void a(final int i) {
        if (!this.p.getAndSet(true)) {
            this.yx.a();
        }
        if (this.f930a.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.f930a.put(Integer.valueOf(i), Boolean.TRUE);
        this.oq.dl();
        boolean z = !gb.uf(this.gc);
        final int iH = h();
        final String strGk = gk();
        int iYz = yz();
        boolean z2 = iYz == 0;
        if (!z2 || z) {
            dl(z(i, z2, iYz, "reward failed", iH, strGk, false));
            dl(i, z2);
        } else {
            dl(i, true);
            zw.z().z(g(i, true), new sy.gc() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // com.bytedance.sdk.openadsdk.core.sy.gc
                public void z(int i2, String str) {
                    TTRewardVideoActivity.this.dl(TTRewardVideoActivity.this.z(i, false, i2, str, iH, strGk, false));
                }

                @Override // com.bytedance.sdk.openadsdk.core.sy.gc
                public void z(hh.a aVar) {
                    int iZ = aVar.dl.z();
                    String strG = aVar.dl.g();
                    TTRewardVideoActivity.this.dl(aVar.g ? TTRewardVideoActivity.this.z(i, true, 10111, "reward failed", iZ, strG, true) : TTRewardVideoActivity.this.z(i, false, 10112, "server refuse", iZ, strG, true));
                }
            });
        }
    }

    @DungeonFlag
    private JSONObject g(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put(MediationConstant.REWARD_NAME, gk());
            jSONObject.put(MediationConstant.REWARD_AMOUNT, h());
            jSONObject.put("network", v.dl(zw.getContext()));
            jSONObject.put("sdk_version", gk.f1105a);
            jSONObject.put("user_agent", uy.i());
            jSONObject.put("extra", this.gc.en());
            jSONObject.put("media_extra", this.me);
            jSONObject.put("video_duration", this.ti.l());
            jSONObject.put("play_start_ts", this.y);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put("duration", this.ti.q());
            jSONObject.put("user_id", this.nh);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put("reward_type", i);
            if (gb.a(this.gc)) {
                jSONObject.put("show_result", z ? 1 : 0);
            }
            com.bytedance.sdk.openadsdk.pf.g.z(this.na, jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public Bundle z(int i, boolean z, int i2, String str, int i3, String str2, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z);
        bundle.putInt("callback_extra_key_reward_type", i);
        bundle.putInt("callback_extra_key_reward_amount", i3);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", gb.z(this.gc, i));
        bundle.putBoolean("callback_extra_key_is_server_verify", z2);
        if (!z) {
            bundle.putInt("callback_extra_key_error_code", i2);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i == 0 && gb.e(this.gc) && this.ti.q() >= gb.uy(this.gc)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void gz(int i) {
        if (!this.f930a.containsKey(0)) {
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.hh.z(TTRewardVideoActivity.this.na, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (y.z(this.gc)) {
            this.g.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.hh.z(TTRewardVideoActivity.this.na, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.yx.dl(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void g() {
        if (!this.f.gc() && this.f930a.containsKey(0) && this.yx.dl(2)) {
            return;
        }
        super.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void hh() {
        if (this.dl.getAndSet(true) || this.yx.z() || x.g(sy(), this.gc, true)) {
            return;
        }
        a("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        dl dlVar;
        super.onDestroy();
        this.yx.dl();
        List<dl> listZ = z.z();
        if (listZ == null || listZ.size() == 0 || (dlVar = this.tf) == null) {
            return;
        }
        listZ.remove(dlVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void dl(boolean r4) {
        /*
            r3 = this;
            boolean r0 = r3.io
            r1 = 1
            r2 = -1
            if (r0 != 0) goto La
            if (r4 == 0) goto L17
            r4 = 0
            goto L18
        La:
            com.bytedance.sdk.openadsdk.core.gk.uy r4 = com.bytedance.sdk.openadsdk.core.zw.g()
            int r4 = r4.tp()
            if (r4 != r1) goto L17
            r4 = 2000(0x7d0, float:2.803E-42)
            goto L18
        L17:
            r4 = r2
        L18:
            com.bytedance.sdk.openadsdk.core.component.reward.business.g.z r0 = r3.yx
            boolean r0 = r0.z()
            if (r0 == 0) goto L21
            goto L22
        L21:
            r2 = r4
        L22:
            if (r2 < 0) goto L4f
            java.util.concurrent.atomic.AtomicBoolean r4 = r3.q
            boolean r4 = r4.get()
            if (r4 != 0) goto L4f
            if (r2 != 0) goto L44
            java.util.concurrent.atomic.AtomicBoolean r4 = r3.q
            boolean r4 = r4.getAndSet(r1)
            if (r4 != 0) goto L4f
            com.bytedance.sdk.openadsdk.core.component.reward.z.gz r4 = com.bytedance.sdk.openadsdk.core.component.reward.z.gz.z()
            int r0 = r3.j
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.z(r0)
            return
        L44:
            com.bytedance.sdk.component.utils.l r4 = r3.g
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity$5 r0 = new com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity$5
            r0.<init>()
            long r1 = (long) r2
            r4.postDelayed(r0, r1)
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.dl(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        if (i == 0) {
            z("onRewardVerify", bundle);
        }
        z("onRewardArrived", bundle);
        this.oq.z(bundle);
        this.wj.z(i);
    }

    private void z(String str, Bundle bundle) {
        com.bytedance.sdk.openadsdk.core.component.reward.z.z(0, this.yx.z() ? gp.z(this.gp) : this.gp, str, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void a(String str) {
        z(str, (Bundle) null);
    }

    private boolean r() {
        if (TextUtils.isEmpty(this.gc.aq())) {
            return false;
        }
        return this.sd.get();
    }

    @DungeonFlag
    private int yz() {
        final int i = 0;
        if (gb.a(this.gc)) {
            if (this.pf.get()) {
                i = 10116;
            } else if (!r()) {
                i = 10111;
            }
        }
        if (zw.g().lz() == 0) {
            return i;
        }
        boolean zGz = io.gz();
        int iZ = io.z(this.gc.mz() + "_" + this.gc.st());
        if (zGz) {
            i = 10115;
        } else if (iZ == io.g) {
            i = 10114;
        } else if (iZ == io.dl) {
            i = 10113;
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g<com.bytedance.sdk.openadsdk.core.q.z.g> gVarG = com.bytedance.sdk.openadsdk.core.q.z.g.g();
                gVarG.z("armor_reward");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MediationConstant.KEY_ERROR_CODE, i);
                gVarG.g(jSONObject.toString());
                return gVarG;
            }
        }, "armor_reward");
        return i;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mc.mc()) {
            return;
        }
        this.wj.z(i, i2, intent);
    }

    private void dl(int i, boolean z) {
        if (i == 0) {
            this.gk.i();
            this.eo.g(z);
            nh();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected boolean io() {
        return super.io() || this.yx.gc();
    }

    private void bm() {
        this.gk.z("cancelClickLandingRewardTip", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean l() {
        return this.yx.z() || this.f.a();
    }
}
