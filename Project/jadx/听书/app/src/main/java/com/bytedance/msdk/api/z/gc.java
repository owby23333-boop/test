package com.bytedance.msdk.api.z;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f368a;
    private Map<String, Object> dl;
    private com.bytedance.sdk.openadsdk.mediation.g.g.g g;
    private PluginValueSet gc;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z z;
    private int m = -1;
    private String e = "";

    public gc(int i, PluginValueSet pluginValueSet) {
        if (pluginValueSet != null) {
            this.gc = pluginValueSet;
            this.f368a = i;
            com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = new com.bytedance.sdk.openadsdk.mediation.g.g.z(pluginValueSet.sparseArray());
            this.z = zVar;
            this.g = zVar.l();
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("AdLinkInfo", "valueset is null");
    }

    @Override // com.bytedance.msdk.api.z.a
    public com.bytedance.sdk.openadsdk.mediation.g.g.z q() {
        return this.z;
    }

    @Override // com.bytedance.msdk.api.z.a
    public float v() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.gz();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.z.a
    public float pf() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.fo();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean ls() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.kb();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public void gz(int i) {
        this.m = i;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int p() {
        return this.m;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int iq() {
        return this.f368a;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String zw() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        return zVar != null ? zVar.a() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public void a(String str) {
        this.e = str;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int uf() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.m();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int sy() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.e();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int hh() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.wp();
        }
        return 1;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean l() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.uy();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String x() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        return zVar != null ? zVar.i() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public String lq() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        return zVar != null ? zVar.v() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public int mc() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.pf();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String h() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar;
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        String strIo = zVar != null ? zVar.io() : "";
        return (!TextUtils.isEmpty(strIo) || (gVar = this.g) == null) ? strIo : gVar.v();
    }

    @Override // com.bytedance.msdk.api.z.a
    public int gk() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar;
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        int iUf = zVar != null ? zVar.uf() : 0;
        return (iUf != 0 || (gVar = this.g) == null) ? iUf : gVar.pf();
    }

    @Override // com.bytedance.msdk.api.z.a
    public String io() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar = this.g;
        return gVar != null ? gVar.gz() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean un() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar = this.g;
        if (gVar != null) {
            return gVar.dl();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String ti() {
        Map<String, Object> mapM;
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar = this.g;
        if (gVar == null || (mapM = gVar.m()) == null) {
            return "";
        }
        Object obj = mapM.get("testToolSlotId");
        return obj instanceof String ? (String) obj : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean eo() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar = this.g;
        if (gVar != null) {
            return gVar.e();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public Map<String, Object> oq() {
        Map<String, Object> map = this.dl;
        if (map != null) {
            return map;
        }
        if (this.g != null) {
            this.dl = new ConcurrentHashMap();
            Map<String, Object> mapM = this.g.m();
            if (mapM != null && mapM.size() > 0) {
                for (Map.Entry<String, Object> entry : mapM.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.dl.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        if (this.dl == null) {
            this.dl = new ConcurrentHashMap();
        }
        return this.dl;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean fv() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar = this.g;
        if (gVar != null) {
            return gVar.fo();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public void fo(int i) {
        this.f368a = i;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean js() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar = this.g;
        if (gVar != null) {
            return gVar.z();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean tb() {
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVar = this.g;
        if (gVar != null) {
            return gVar.g();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String xl() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.h();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean j() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.z;
        if (zVar != null) {
            return zVar.hh();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public SparseArray<Object> wj() {
        PluginValueSet pluginValueSet = this.gc;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        return null;
    }
}
