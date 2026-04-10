package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.eo;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class m extends gc {
    public m(Context context, na naVar, String str, boolean z) {
        super(context, naVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public void gz(boolean z) {
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.m, this.gc, (JSONObject) null, e());
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.gc, e(), z);
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.m, e());
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public synchronized void kb() {
        if (this.f1224a == null) {
            return;
        }
        if (this.iq != null && gk.dl >= 6400 && !gk.e()) {
            com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z((com.bytedance.sdk.openadsdk.core.kb.z.a) null, e());
        }
        if (this.uy != null && this.uy.get()) {
            this.uy.set(false);
            if (this.iq != null) {
                this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(4).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(e()))).g());
            }
        }
        uy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public synchronized void ls() {
        if (this.f1224a == null) {
            return;
        }
        this.uy.set(true);
        if (this.iq != null) {
            this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(5).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(e())).z("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(this.uf))).g());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(JSONObject jSONObject, boolean z) {
        m(jSONObject, z);
    }

    private void m(JSONObject jSONObject, final boolean z) {
        p();
        if (getContext() == null || this.f1224a == null || !i()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.m, this.m, jSONObject, e());
        final lq<String, Object> lqVarZ = new lq().z(DefaultUpdateParser.APIKeyLower.DOWNLOAD_URL, this.f1224a.g()).z("hashCode", Integer.valueOf(e())).z("action_type_button", 2);
        if (this.gc != null && !TextUtils.isEmpty(this.gc.mj())) {
            lqVarZ.z("id", Long.valueOf(Double.valueOf(this.gc.mj()).longValue()));
        }
        if (dl()) {
            com.bytedance.sdk.openadsdk.core.kb.z.g gVar = new com.bytedance.sdk.openadsdk.core.kb.z.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.1
                @Override // com.ss.android.z.z.g.p
                public void z(boolean z2) {
                }

                @Override // com.ss.android.z.z.g.p
                public void z() {
                    if (lqVarZ == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(0, m.this.e());
                    m.this.gz().z(m.this.v());
                    lqVarZ.remove("downloadButtonClickListener");
                    if (m.this.z((com.bytedance.sdk.openadsdk.core.iq.a) null, (com.bytedance.sdk.openadsdk.core.kb.z.g) null, lqVarZ, z)) {
                        return;
                    }
                    m.this.g(lqVarZ);
                }
            };
            com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(lqVarZ, gVar);
            if (z((com.bytedance.sdk.openadsdk.core.iq.a) null, gVar, lqVarZ, z)) {
                return;
            }
            dl(true);
            z(lqVarZ, gVar);
            return;
        }
        z(lqVarZ, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.kb.z.g gVar) {
        com.bytedance.sdk.openadsdk.core.kb.fo.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.2
            @Override // java.lang.Runnable
            public void run() {
                m.this.z(gVar, (Map<String, Object>) map);
            }
        }, this.gc);
        this.zw = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.kb.z.g gVar, Map<String, Object> map) {
        try {
            if (gVar == null) {
                z(map);
                this.zw = false;
            } else {
                g(gVar, map);
                this.zw = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void g(com.bytedance.sdk.openadsdk.core.kb.z.g gVar, Map<String, Object> map) {
        if (this.iq == null) {
            return;
        }
        final lq<String, Object> lqVarZ = new lq().z("itemClickListener", null).z("downloadButtonClickListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(gVar)).z("hashCode", Integer.valueOf(e())).z(map);
        lqVarZ.put("itemClickListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(new com.bytedance.sdk.openadsdk.core.kb.z.gc() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.3
            @Override // com.bytedance.sdk.openadsdk.core.kb.z.gc
            public void onItemClick() {
                if (!m.this.p && !m.this.gc.fs()) {
                    eo.z(m.this.getContext(), m.this.gc.fp(), m.this.gc, m.this.m);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.kb.dl.g.g.g(1, m.this.e());
                lqVarZ.remove("itemClickListener");
                m.this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(17).z(Void.class).z(0, lqVarZ).g());
            }
        }));
        this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(17).z(Void.class).z(0, lqVarZ).g());
    }

    private void z(final Map<String, Object> map, final boolean z) {
        int i = this.q;
        if (i == 1) {
            uy.z(zw.getContext());
        } else if (i == 2) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.iq.a aVarZ = zw.z().z(m.this.gc, m.this.f1224a.g());
                    if (aVarZ != null && aVarZ.gc()) {
                        m.this.z(aVarZ, (Map<String, Object>) map, z);
                    } else {
                        uy.z(zw.getContext());
                    }
                }
            });
        } else {
            z((com.bytedance.sdk.openadsdk.core.iq.a) null, map, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final Map<String, Object> map) {
        if (this.q == 1) {
            return;
        }
        if (this.q == 2) {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.iq.a aVarZ = zw.z().z(m.this.gc, m.this.f1224a.g());
                    if (aVarZ == null || !aVarZ.gc()) {
                        return;
                    }
                    q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            m.this.z((com.bytedance.sdk.openadsdk.core.kb.z.g) null, (Map<String, Object>) map);
                        }
                    });
                }
            });
        } else {
            z((com.bytedance.sdk.openadsdk.core.kb.z.g) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.bytedance.sdk.openadsdk.core.iq.a aVar, final Map<String, Object> map, final boolean z) {
        z(new com.bytedance.sdk.openadsdk.core.kb.z.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.6
            @Override // com.ss.android.z.z.g.p
            public void z() {
            }

            @Override // com.ss.android.z.z.g.p
            public void z(boolean z2) {
                if (z2 && m.this.z(aVar, (com.bytedance.sdk.openadsdk.core.kb.z.g) null, (Map<String, Object>) map, z)) {
                    return;
                }
                m.this.z((com.bytedance.sdk.openadsdk.core.kb.z.g) null, (Map<String, Object>) map);
            }
        }, map);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.openadsdk.core.kb.g.dl
    public boolean dl() {
        return this.iq != null && com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.iq, e()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void a() {
        if (this.f1224a == null) {
            return;
        }
        this.uy.set(false);
        if (this.iq != null) {
            this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8).z(Void.class).z(0, new lq().z("force", Boolean.TRUE).z("hashCode", Integer.valueOf(e()))).g());
        }
        ls();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(com.bytedance.sdk.openadsdk.core.iq.a aVar, final com.bytedance.sdk.openadsdk.core.kb.z.g gVar, final Map<String, Object> map, boolean z) {
        com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl dlVarGz = gz();
        if (!dlVarGz.a(z)) {
            return false;
        }
        if (z(getContext(), this.gc, this.m)) {
            return true;
        }
        dlVarGz.z(aVar, this.m, this.f1224a.g(), new com.bytedance.sdk.openadsdk.core.kb.dl.z.g() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.m.7
            @Override // com.bytedance.sdk.openadsdk.core.kb.dl.z.g
            public void z() {
                if (!m.this.dl()) {
                    m.this.z(gVar, (Map<String, Object>) map);
                } else {
                    m.this.dl(true);
                    m.this.z((Map<String, Object>) map, gVar);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void dl(boolean z) {
        if (gk.dl >= 5400 && z) {
            this.zw = true;
            if (dl()) {
                try {
                    com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(true, com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.gc, this.io), e());
                } catch (Throwable th) {
                    wp.dl("xgcdl", "throwable", th);
                }
            }
        }
    }

    private void p() {
        if (gk.dl >= 5400 && dl() && !this.zw) {
            com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(false, (com.bytedance.sdk.openadsdk.core.kb.z.a) null, e());
        }
    }
}
