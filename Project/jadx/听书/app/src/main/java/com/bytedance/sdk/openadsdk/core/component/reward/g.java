package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.z.gc;
import com.bytedance.sdk.openadsdk.core.e.a;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.kb.g.z;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.h;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.kb;
import com.bytedance.sdk.openadsdk.mediation.MediationFullScreenManagerDefault;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g extends kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f953a;
    private final String e;
    private final na g;
    private long gc;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g i;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl ls;
    private com.bytedance.sdk.openadsdk.core.kb.g.z pf;
    private com.bytedance.sdk.openadsdk.zw.z.g.z.z v;
    private final Context z;
    private final AtomicBoolean m = new AtomicBoolean(false);
    private int gz = -1;
    private Double fo = null;
    private boolean uy = false;
    private boolean kb = false;
    private long wp = System.currentTimeMillis();
    private boolean dl = false;

    public g(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.z = context;
        this.g = naVar;
        this.i = gVar;
        this.e = naVar.hashCode() + naVar.aq() + hashCode();
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl dlVar) {
        this.ls = dlVar;
    }

    public void m() {
        if (this.m.get()) {
            return;
        }
        this.dl = true;
    }

    public void z(int i) {
        this.gz = i;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar) {
        if (this.m.get()) {
            z.z(this.e, zVar);
        }
        this.v = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.pf = z.C0184z.z(dlVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public int z() {
        na naVar = this.g;
        if (naVar == null) {
            return -1;
        }
        return naVar.lt();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(Activity activity) {
        Intent intent;
        na naVar = this.g;
        String strVk = naVar != null ? naVar.vk() : "";
        na naVar2 = this.g;
        new z.C0178z().gc(naVar2 != null ? naVar2.mj() : "0").z("fullscreen_interstitial_ad").g("show_start").a(strVk).z((com.bytedance.sdk.openadsdk.m.z.z) null);
        if (activity != null && activity.isFinishing()) {
            wp.a("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.m.get()) {
            return;
        }
        this.m.set(true);
        na naVar3 = this.g;
        if (naVar3 != null) {
            if (tf.v(naVar3) == null && this.g.jz() == null) {
                return;
            }
            if (z() == 4) {
                e.z(new fo("full_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        gz.z(g.this.z, g.this.g, "fullscreen_interstitial_ad", false).z(g.this.pf);
                    }
                });
            }
            com.bytedance.sdk.openadsdk.core.g.z().get("full_video_show_time", System.currentTimeMillis());
            Context context = activity == null ? this.z : activity;
            if (context == null) {
                context = zw.getContext();
            }
            fo();
            if (this.g.zr() == 2) {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(268435456);
            }
            if (this.i != null) {
                intent.putExtra("is_adm", !TextUtils.isEmpty(r7.q()));
            }
            intent.putExtra("is_preload", this.dl);
            intent.putExtra("object_create_ts", this.wp);
            Double d = this.fo;
            intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
            if (!TextUtils.isEmpty(this.f953a)) {
                intent.putExtra("rit_scene", this.f953a);
            }
            int i = this.gz;
            if (i != -1) {
                intent.putExtra("key_video_cache_callback", i);
            }
            eo.z(intent, this.g);
            intent.putExtra("multi_process_key", this.e);
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.dl dlVar = this.ls;
            if (dlVar != null) {
                intent.putExtra("insert_ad_bundle", dlVar.fo().toString());
            }
            z(context, intent);
            a.z().z(this.g).z(8);
        }
    }

    private void fo() {
        com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar = this.v;
        if (zVar != null) {
            z.z(this.e, zVar);
        }
    }

    private void z(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.g.z(context, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.2
            @Override // com.bytedance.sdk.component.utils.g.z
            public void z() {
            }

            @Override // com.bytedance.sdk.component.utils.g.z
            public void z(Throwable th) {
                wp.dl("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        if (this.i == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.z.z.z zVarZ = com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z();
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar = this.i;
        zVarZ.z(gVar, gVar.a());
        gc.z(false, false).z(this.g);
        e();
    }

    public void e() {
        if (this.g == null || this.i == null || zw.g().tp() != 0) {
            return;
        }
        try {
            boolean z = this.dl;
            if (this.i == null || !z) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.component.reward.z.g.z().z(this.i);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public void z(Activity activity, Object obj, String str) {
        if (obj == null) {
            wp.a("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strZ = com.bytedance.sdk.openadsdk.core.ti.z.gc.z(obj);
        if ("customize_scenes".equalsIgnoreCase(strZ)) {
            this.f953a = str;
        } else {
            this.f953a = strZ;
        }
        z(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
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

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
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
        this.gc = j;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public long a() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.kb
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.a gc() {
        return new MediationFullScreenManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
        if (this.uy) {
            return;
        }
        h.z(this.g, d);
        this.uy = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
        if (this.kb) {
            return;
        }
        h.z(this.g, d, str, str2);
        this.kb = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
        this.fo = d;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        na naVar = this.g;
        if (naVar != null) {
            io.z(naVar.dc(), gVar, com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
        }
    }
}
