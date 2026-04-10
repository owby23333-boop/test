package com.bytedance.sdk.openadsdk.core.component.reward.z;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.fo;
import com.bytedance.sdk.openadsdk.core.gc.g;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m<T> extends com.bytedance.sdk.openadsdk.core.gc.g<T> {
    protected com.bytedance.sdk.openadsdk.core.gc.gc.g g;

    protected abstract void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, T t);

    @Override // com.bytedance.sdk.openadsdk.core.gc.g, com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(int i, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar) {
    }

    protected abstract void z(T t);

    protected abstract boolean z();

    protected abstract boolean z(com.bytedance.sdk.openadsdk.core.iq.z zVar);

    public m(com.bytedance.sdk.openadsdk.core.gc.gc.g gVar) {
        super(gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g, com.bytedance.sdk.openadsdk.core.gc.z.z
    public boolean z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list) {
        na naVar = list.get(0);
        if (!com.bytedance.sdk.openadsdk.core.gc.a.z(gVar, naVar, z())) {
            return false;
        }
        new z.C0178z().gc(naVar.mj()).z(z() ? "rewarded_video" : "fullscreen_interstitial_ad").a(naVar.vk()).g("get_preload_ad").z(new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.m.1
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (gVar.zw() != null) {
                    int iZ = com.bytedance.sdk.openadsdk.core.ti.z.m.z(gVar.zw());
                    if (iZ == 1) {
                        jSONObject2.put("req_type", 1);
                    } else if (iZ == 3) {
                        jSONObject2.put("req_type", 3);
                    } else {
                        jSONObject2.put("req_type", -1);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g, com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(int i, final List<na> list, final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.core.gc.gc.gc<T> gcVar, Bundle bundle, final com.bytedance.sdk.openadsdk.core.gc.gc.e eVar) {
        final boolean z = bundle.getBoolean("is_cache", false);
        final boolean z2 = bundle.getBoolean("is_playAgain", false);
        final long j = bundle.getLong(d.p);
        final na naVar = list.get(0);
        z(gVar, list, (g.z) new g.z<T>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.m.2
            @Override // com.bytedance.sdk.openadsdk.core.gc.g.z
            public void z(final T t) {
                for (na naVar2 : list) {
                    naVar2.ac().g();
                    naVar2.gz(z);
                    naVar2.oq(z ? 101 : 102);
                }
                m.this.g(gVar, list, t);
                com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar = new com.bytedance.sdk.openadsdk.core.gc.gc.dl() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.m.2.1
                    private final AtomicBoolean dl = new AtomicBoolean(false);

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.dl
                    public void z() {
                        m.this.z(gVar, (List<na>) list, t);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_play_again", z2);
                            jSONObject.put("is_from_cache", z);
                            jSONObject.put("is_adm", !TextUtils.isEmpty(gVar.q()));
                            jSONObject.put("cache_strategy", gc.z(m.this.z()));
                            jSONObject.put("src_req_id", naVar.ux());
                            jSONObject.put("is_map", naVar.gd());
                            jSONObject.put("load_duration", System.currentTimeMillis() - j);
                        } catch (JSONException unused) {
                        }
                        v.z().z(naVar, "stats_reward_full_ad_loaded", jSONObject);
                        if (gcVar != null) {
                            gcVar.z(t);
                        }
                        m.this.z(gVar, naVar, this);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.dl
                    public void g() {
                        if (j != 0) {
                            com.bytedance.sdk.openadsdk.core.i.a.g(naVar, eo.g(m.this.z() ? 7 : 8), j);
                        }
                        m.this.z(t);
                        if (gcVar != null) {
                            gcVar.g(t);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.gc.gc.dl
                    public void dl() {
                        if (this.dl.compareAndSet(false, true)) {
                            m.this.z(z, gVar, (List<na>) list);
                        }
                    }
                };
                com.bytedance.sdk.openadsdk.core.gc.gc.e eVar2 = eVar;
                if (eVar2 != null) {
                    eVar2.z(dlVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g, com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
        if (gVar != null) {
            z(gVar.a(), i, str, gVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g, com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(int i, com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar, j jVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar2, com.bytedance.sdk.openadsdk.core.gc.gc.gc gcVar, com.bytedance.sdk.openadsdk.core.gc.gc.e eVar) {
        if (zVar.g() == null || zVar.g().isEmpty()) {
            if (eVar != null) {
                eVar.z(-3);
                return;
            }
            return;
        }
        Bundle bundle = jVar == null ? null : jVar.pf;
        boolean z = bundle != null && bundle.getBoolean("is_preload", false);
        boolean z2 = bundle != null && bundle.getBoolean("is_playAgain", false);
        long j = bundle != null ? bundle.getLong(d.p, 0L) : 0L;
        zVar.g().size();
        na naVar = zVar.g().get(0);
        if (z(gVar2.a(), naVar)) {
            return;
        }
        if (!naVar.ts() || z(zVar)) {
            if (eVar != null) {
                eVar.z(-4);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (zVar.g().size() > 1 && com.bytedance.sdk.openadsdk.core.iq.gz.z(i).z("mix_ad", gVar2, zVar.g().get(0))) {
            com.bytedance.sdk.openadsdk.core.z.z(zVar.g());
            arrayList.add(zVar.g().get(0));
        } else {
            arrayList.addAll(zVar.g());
        }
        if (z) {
            com.bytedance.sdk.openadsdk.core.gc.gc.g gVar3 = this.g;
            if (gVar3 != null) {
                gVar3.z().z(gVar2, naVar);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cache_strategy", gc.z(z()));
                jSONObject.put("src_req_id", naVar.ux());
                jSONObject.put("is_map", naVar.gd());
            } catch (Exception unused) {
            }
            v.z().z(naVar, "stats_reward_full_preload", jSONObject);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(d.p, j);
        bundle2.putBoolean("is_playAgain", z2);
        bundle2.putBoolean("is_cache", false);
        z(i, arrayList, gVar2, gcVar, bundle2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, int i, String str2, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
        gVar.z(i);
        gVar.g(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cache_strategy", gc.z(z()));
            jSONObject.put(PluginConstants.KEY_APP_ID, uy.ls().q());
            jSONObject.put("rit", str);
        } catch (Exception unused) {
        }
        gVar.z(jSONObject);
        com.bytedance.sdk.openadsdk.core.iq.g.z(gVar);
    }

    protected void z(na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        gVar.a();
        try {
            gk gkVarKp = naVar.kp();
            if (gkVarKp != null && !TextUtils.isEmpty(gkVarKp.z())) {
                com.bytedance.sdk.openadsdk.core.io.dl dlVar = new com.bytedance.sdk.openadsdk.core.io.dl(true);
                dlVar.z(gVar.a());
                dlVar.z(8);
                dlVar.dl(naVar.mj());
                dlVar.a(naVar.vk());
                dlVar.g(eo.i(naVar));
                com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(dlVar);
            }
        } catch (Throwable unused) {
        }
        if (vm.uy(naVar) && vm.m(naVar) != null) {
            com.bytedance.sdk.openadsdk.core.ugeno.uy.z(vm.m(naVar).fo(), vm.m(naVar).uy(), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
        }
        if (z()) {
            for (bm bmVar : gb.tb(naVar)) {
                com.bytedance.sdk.openadsdk.core.ugeno.uy.z(bmVar.a(), bmVar.gc(), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
            }
            for (bm bmVar2 : gp.gc(naVar)) {
                com.bytedance.sdk.openadsdk.core.ugeno.uy.z(bmVar2.a(), bmVar2.gc(), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
            }
        }
        if (TextUtils.isEmpty(y.kb(naVar))) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z(y.kb(naVar), y.wp(naVar), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
    }

    private void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final na naVar, final com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar) {
        if (tf.v(naVar) == null) {
            return;
        }
        com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(1, naVar);
        aVarZ.z("material_meta", naVar);
        aVarZ.z("ad_slot", gVar);
        com.bytedance.sdk.openadsdk.core.video.a.g.z(aVarZ, new com.bykv.vk.openvk.component.video.api.gc.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.m.3
            @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
            public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i) {
                wp.z("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadSuccess");
                com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    dlVar2.g();
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.gc.z.InterfaceC0028z
            public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar, int i, String str) {
                wp.z("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadFail");
                if (!tf.wp(naVar)) {
                    wp.z("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadFail and block onCached");
                    return;
                }
                com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar2 = dlVar;
                if (dlVar2 != null) {
                    dlVar2.g();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.g
    protected void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, List<na> list, T t) {
        na naVar = list.get(0);
        com.bytedance.sdk.openadsdk.core.gc.gc.g gVar2 = this.g;
        if (gVar2 != null) {
            gVar2.z().z(gVar, naVar, t, naVar.xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, na naVar, com.bytedance.sdk.openadsdk.core.gc.gc.dl dlVar) {
        z(naVar, gVar);
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            com.bytedance.sdk.openadsdk.core.video.dl.z.g(naVar);
            dlVar.g();
        } else {
            if (iq.dl(naVar)) {
                if (js.z(naVar) && com.bytedance.sdk.openadsdk.hh.uy.z(naVar)) {
                    g(gVar, naVar, dlVar);
                }
                dlVar.g();
                return;
            }
            g(gVar, naVar, dlVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(String str, na naVar) {
        if (!zw.g().g(str) || naVar == null) {
            return false;
        }
        int i = z() ? 7 : 8;
        na naVarG = com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z().g(z(), str);
        if (naVarG == null) {
            return false;
        }
        if (naVarG.ti() + naVarG.zw() < System.currentTimeMillis()) {
            com.bytedance.sdk.openadsdk.core.gc.a.gc.z(i).z(str);
            return true;
        }
        if (!TextUtils.equals(naVarG.lq(), naVar.lq())) {
            if (com.bytedance.sdk.openadsdk.core.z.z(naVar, z() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(naVar.x());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.get(next);
                naVarG.en().put(next, jSONObject.get(next));
            }
            naVarG.iq(naVarG.en().toString());
        } catch (Exception e) {
            wp.z(e);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.gc.z.z
    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (zw.g().g(gVar.a())) {
            j jVar = new j();
            jVar.z = 2;
            if (zw.g().uy(gVar.a()) || gVar.gz() > 0.0f) {
                jVar.m = 2;
            }
            zw.z().g(gVar, jVar, z() ? 7 : 8, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.m.4
                @Override // com.bytedance.sdk.openadsdk.core.sy.g
                public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                    gVar2.z(i);
                    gVar2.g(str);
                    com.bytedance.sdk.openadsdk.core.iq.g.z(gVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.sy.g
                public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                    if (zVar.g() == null || zVar.g().isEmpty()) {
                        m.this.z(gVar.a(), -3, fo.z(-3), gVar2);
                        return;
                    }
                    na naVar = zVar.g().get(0);
                    if (m.this.z(gVar.a(), naVar)) {
                        return;
                    }
                    if (!naVar.ts() || m.this.z(zVar)) {
                        m.this.z(gVar.a(), -4, fo.z(-4), gVar2);
                        return;
                    }
                    if (zVar.g().size() > 1) {
                        if (com.bytedance.sdk.openadsdk.core.iq.gz.z(m.this.z() ? 7 : 8).z("mix_ad", gVar, naVar)) {
                            com.bytedance.sdk.openadsdk.core.z.z(zVar.g());
                        }
                    }
                    if (m.this.g != null) {
                        m.this.g.z().z(gVar, naVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cache_strategy", gc.z(m.this.z()));
                        jSONObject.put("src_req_id", naVar.ux());
                        jSONObject.put("is_map", naVar.gd());
                    } catch (Exception unused) {
                    }
                    v.z().z(naVar, "stats_reward_full_preload", jSONObject);
                }
            });
        }
    }
}
