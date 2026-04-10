package com.bytedance.sdk.openadsdk.core.kb.dl;

import android.content.Context;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e extends gc {
    private Map<String, Object> sy;

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public boolean dl(JSONObject jSONObject, boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public boolean pf() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
    }

    public e(Context context, na naVar, String str, boolean z) {
        super(context, naVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public void gz(boolean z) {
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.m, this.gc, (JSONObject) null, e());
        com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.gc, e(), z);
        this.sy = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.openadsdk.core.kb.g.dl
    public boolean dl() {
        return this.iq != null && com.bytedance.sdk.openadsdk.core.kb.dl.g.g.z(this.iq, e()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public synchronized void ls() {
        p();
        this.uy.set(true);
        if (this.iq != null) {
            this.iq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(5).z(Void.class).z(0, new lq().z("hashCode", Integer.valueOf(e())).z("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.ls.dl.a.z(this.uf))).g());
        }
    }

    private void p() {
        com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = this.gc.c();
        if (gcVarC != null) {
            this.sy.put("download_url", gcVarC.g());
        }
        this.sy.put("download_status_listener", this.uf);
        this.sy.put("event_tag", this.m);
        this.sy.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.fo.z.z.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.e.1
            @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
            public boolean z(Map<String, Object> map) {
                e eVar = e.this;
                return eVar.z(eVar.getContext(), e.this.gc, e.this.m);
            }
        });
        this.sy.put("download_popup_manager", gz());
        this.sy.put("download_manager_hash_code", Integer.valueOf(hashCode()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(na naVar, boolean z) {
        if (getContext() == null) {
            return;
        }
        z(eo.js(naVar), z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(int i) {
        this.sy.put("need_check_compliance", Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.openadsdk.core.kb.g.dl
    public Map<String, Object> gc() {
        return this.sy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void dl(boolean z) {
        this.sy.put("is_open_oppo_market_auto_download", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    public void m(boolean z) {
        this.sy.put("convert_from_landing_page", Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc
    protected synchronized void kb() {
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

    @Override // com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void z(JSONObject jSONObject, boolean z) {
        eo.hh();
        HashMap map = new HashMap();
        map.put("material_meta", this.gc);
        map.put(d.R, zw.getContext());
        map.put("is_market_covert", Boolean.valueOf(dl()));
        com.bytedance.sdk.openadsdk.core.iq.gc gcVarC = this.gc.c();
        if (gcVarC != null) {
            map.put("download_url", gcVarC.g());
        }
        Map<String, Object> map2 = this.sy;
        if (map2 != null) {
            map.putAll(map2);
        }
        map.put("download_status_listener", this.uf);
        map.put("event_tag", this.m);
        map.put("source", Integer.valueOf(eo.g(this.m)));
        map.put("dialog_to_landing_page_convert", new com.bytedance.sdk.openadsdk.core.fo.z.z.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.e.2
            @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
            public boolean z(Map<String, Object> map3) {
                e eVar = e.this;
                return eVar.z(eVar.getContext(), e.this.gc, e.this.m);
            }
        });
        map.put("download_popup_manager", gz());
        map.putAll(com.bytedance.sdk.component.kb.gc.z.z().z(this.gc.hashCode() + this.gc.aq()));
        map.put("convert_from_downloader", Boolean.TRUE);
        map.put("download_manager_hash_code", Integer.valueOf(e()));
        map.put("is_feed_register_direct_download", Boolean.valueOf(z));
        HashMap map3 = new HashMap();
        map.put("download_manager_hash_code", Integer.valueOf(e()));
        com.bytedance.sdk.openadsdk.core.fo.z.a.z.z(this.gc, map3, "clickEvent", map, this.m, new HashMap());
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

    @Override // com.bytedance.sdk.openadsdk.core.kb.dl.gc, com.bytedance.sdk.openadsdk.core.kb.g.dl
    public void a(boolean z) {
        this.io = z;
        this.sy.put("is_click_button", Boolean.valueOf(z));
    }
}
