package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.z.gc;
import com.bytedance.sdk.openadsdk.core.e.a;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.kb.g.z;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.h;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.pf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationRewardManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.m;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends pf {
    private final com.bytedance.sdk.openadsdk.ls.dl.dl.g dl;
    private com.bytedance.sdk.openadsdk.sy.z.g.z.z fo;
    private boolean fv;
    private final na g;
    private String gc;
    private com.bytedance.sdk.openadsdk.sy.z.g.z.z gz;
    private int i;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl io;
    private com.bytedance.sdk.openadsdk.core.kb.g.z kb;
    private String ls;
    private long m;
    private String p;
    private com.bytedance.sdk.openadsdk.sy.z.g.z.g uy;
    private boolean v;
    private String wp;
    private final Context z;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private int pf = 1;
    private int js = -1;
    private Double tb = null;
    private boolean q = false;
    private boolean iq = false;
    private long zw = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f939a = false;

    public dl(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.z = context;
        this.g = naVar;
        this.dl = gVar;
        this.wp = naVar.hashCode() + naVar.aq() + hashCode();
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl dlVar) {
        this.io = dlVar;
    }

    public void m() {
        if (this.e.get()) {
            return;
        }
        this.f939a = true;
    }

    public void z(int i) {
        this.i = i;
    }

    public void g(int i) {
        this.pf = i;
    }

    public void z(String str) {
        this.ls = str;
    }

    public void g(String str) {
        this.p = str;
    }

    public void dl(int i) {
        this.js = i;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar) {
        if (this.e.get()) {
            z.z(this.wp, zVar);
        } else {
            this.gz = zVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void g(com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar) {
        if (this.e.get()) {
            z.z(gp.z(this.wp), zVar);
        } else {
            this.fo = zVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(com.bytedance.sdk.openadsdk.sy.z.g.z.g gVar) {
        if (this.e.get()) {
            g(true);
            z.z(gp.g(this.wp), gVar);
        } else {
            this.uy = gVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.kb = z.C0184z.z(dlVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public int z() {
        na naVar = this.g;
        if (naVar == null) {
            return -1;
        }
        return naVar.lt();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public int dl() {
        na naVar = this.g;
        if (naVar == null) {
            return -1;
        }
        if (iq.dl(naVar)) {
            return 2;
        }
        if (iq.a(this.g)) {
            return 1;
        }
        return com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.g) ? 3 : 0;
    }

    public void z(long j) {
        this.m = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public long a() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public m gc() {
        return new MediationRewardManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(Activity activity) {
        Intent intent;
        na naVar = this.g;
        String strVk = naVar != null ? naVar.vk() : "";
        na naVar2 = this.g;
        new z.C0178z().gc(naVar2 != null ? naVar2.mj() : "0").z("rewarded_video").g("show_start").a(strVk).z((com.bytedance.sdk.openadsdk.m.z.z) null);
        if (activity != null && activity.isFinishing()) {
            wp.a("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.e.get()) {
            return;
        }
        this.e.set(true);
        na naVar3 = this.g;
        if (naVar3 == null || tf.v(naVar3) == null) {
            return;
        }
        if (z() == 4) {
            e.z(new fo("reward_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    gz.z(dl.this.z, dl.this.g, "rewarded_video", false).z(dl.this.kb);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.g.z().put("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.z : activity;
        if (context == null) {
            context = zw.getContext();
        }
        fo();
        if (this.g.zr() == 2) {
            intent = new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(268435456);
        }
        if (this.v) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.pf);
        } else {
            this.i = eo.fo(this.g);
        }
        intent.putExtra("source_rit_id", this.i);
        intent.putExtra("custom_play_again", this.fv);
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar = this.dl;
        if (gVar != null) {
            intent.putExtra("media_extra", gVar.i());
            intent.putExtra("userData", this.dl.iq());
            intent.putExtra("user_id", this.dl.v());
            intent.putExtra(MediationConstant.REWARD_NAME, this.dl.io());
            intent.putExtra(MediationConstant.REWARD_AMOUNT, this.dl.uf());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.dl.q()));
        }
        if (this.v && !TextUtils.isEmpty(this.ls) && !TextUtils.isEmpty(this.p)) {
            intent.putExtra("reward_again_name", this.ls);
            intent.putExtra("reward_again_amount", this.p);
        }
        intent.putExtra("is_preload", this.f939a);
        intent.putExtra("object_create_ts", this.zw);
        Double d = this.tb;
        intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
        if (!TextUtils.isEmpty(this.gc)) {
            intent.putExtra("rit_scene", this.gc);
        }
        int i = this.js;
        if (i != -1) {
            intent.putExtra("key_video_cache_callback", i);
        }
        eo.z(intent, this.g);
        intent.putExtra("multi_process_key", this.wp);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl dlVar = this.io;
        if (dlVar != null) {
            intent.putExtra("insert_ad_bundle", dlVar.fo().toString());
        }
        z(context, intent);
        a.z().z(this.g).z(7);
    }

    private void fo() {
        com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar = this.gz;
        if (zVar != null) {
            z.z(this.wp, zVar);
        }
        if (this.fo != null) {
            z.z(gp.z(this.wp), this.fo);
        }
        if (this.uy != null) {
            g(true);
            z.z(gp.g(this.wp), this.uy);
        }
    }

    private void z(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.g.z(context, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.2
            @Override // com.bytedance.sdk.component.utils.g.z
            public void z() {
            }

            @Override // com.bytedance.sdk.component.utils.g.z
            public void z(Throwable th) {
                wp.dl("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.dl == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.z.z.z zVarZ = com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z();
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar = this.dl;
        zVarZ.z(gVar, gVar.a());
        if (gp.z(this.g)) {
            com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z().g(this.dl, gp.a(this.g));
        }
        gc.z(true, this.v).z(this.g);
        e();
    }

    public void e() {
        if (this.g == null || this.dl == null || this.v || zw.g().tp() != 0) {
            return;
        }
        try {
            if (this.f939a) {
                com.bytedance.sdk.openadsdk.core.component.reward.z.gz.z().z(this.dl);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public Map<String, Object> g() {
        na naVar = this.g;
        if (naVar == null) {
            return null;
        }
        Map<String, Object> mapFq = naVar.fq();
        mapFq.put("expireTimestamp", Long.valueOf(a()));
        mapFq.put("adSceneType", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.a.a.z(this.g)));
        return mapFq;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.pf
    public void z(Activity activity, Object obj, String str) {
        if (obj == null) {
            wp.a("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strZ = com.bytedance.sdk.openadsdk.core.ti.z.gc.z(obj);
        if ("customize_scenes".equalsIgnoreCase(strZ)) {
            this.gc = str;
        } else {
            this.gc = strZ;
        }
        z(activity);
    }

    public void z(boolean z) {
        this.v = z;
    }

    public void dl(String str) {
        this.wp = str;
    }

    public void g(boolean z) {
        this.fv = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
        if (this.q) {
            return;
        }
        h.z(this.g, d);
        this.q = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
        if (this.iq) {
            return;
        }
        h.z(this.g, d, str, str2);
        this.iq = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
        this.tb = d;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        na naVar = this.g;
        if (naVar != null) {
            io.z(naVar.dc(), gVar, com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
        }
    }
}
