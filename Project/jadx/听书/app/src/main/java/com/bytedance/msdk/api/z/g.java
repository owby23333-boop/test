package com.bytedance.msdk.api.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements a, dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f367a;
    private dl dl;
    private com.bytedance.msdk.core.uy.g g;
    private a z;

    public dl i() {
        return this.dl;
    }

    public g() {
    }

    public g(int i, PluginValueSet pluginValueSet) {
        z(i, pluginValueSet, null);
    }

    public g(g gVar) {
        if (gVar != null) {
            z(gVar.iq(), com.bykv.z.z.z.z.z.z(gVar.wj()).g(), gVar.i());
        }
    }

    private void z(int i, PluginValueSet pluginValueSet, dl dlVar) {
        this.z = new gc(i, pluginValueSet);
        z zVar = new z();
        this.dl = zVar;
        if (dlVar != null) {
            zVar.gc(dlVar.gz());
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void m(int i) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.m(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int fo() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.fo();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void z(JSONObject jSONObject) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.z(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public JSONObject uy() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.uy();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int kb() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.kb();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void e(int i) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.e(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void dl(String str) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.dl(str);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public String wp() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.wp();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.z.a
    public float v() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.v();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.z.a
    public float pf() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.pf();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean ls() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.ls();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public void gz(int i) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.gz(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.a
    public int p() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.p();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean fv() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.fv();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public void fo(int i) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.fo(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean js() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.js();
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean tb() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.tb();
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public com.bytedance.sdk.openadsdk.mediation.g.g.z q() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.q();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int iq() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.iq();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String zw() {
        a aVar = this.z;
        return aVar != null ? aVar.zw() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public void a(String str) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.bytedance.msdk.api.z.a
    public String io() {
        a aVar = this.z;
        return aVar != null ? aVar.io() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public int uf() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.uf();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int sy() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.sy();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public int hh() {
        a aVar;
        if (5 != iq() && 9 != iq()) {
            return 1;
        }
        com.bytedance.msdk.core.uy.g gVar = this.g;
        int iFv = gVar != null ? gVar.fv() : 0;
        if (iFv == 0 && (aVar = this.z) != null) {
            iFv = aVar.hh();
        }
        if (iFv <= 0) {
            return 1;
        }
        if (iFv >= 3) {
            return 3;
        }
        return iFv;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean l() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.l();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String h() {
        a aVar = this.z;
        return aVar != null ? aVar.h() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public int gk() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.gk();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String x() {
        a aVar = this.z;
        return aVar != null ? aVar.x() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public String lq() {
        a aVar = this.z;
        return aVar != null ? aVar.lq() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public int mc() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.mc();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean un() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.un();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String ti() {
        a aVar = this.z;
        return aVar != null ? aVar.ti() : "";
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean eo() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.eo();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.a
    public Map<String, Object> oq() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.oq();
        }
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.msdk.api.z.a
    public SparseArray<Object> wj() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.wj();
        }
        return com.bykv.z.z.z.z.z.z.sparseArray();
    }

    public void z(com.bytedance.msdk.core.uy.g gVar) {
        this.g = gVar;
    }

    public com.bytedance.msdk.core.uy.g na() {
        return this.g;
    }

    @Override // com.bytedance.msdk.api.z.a
    public String xl() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.xl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.z.a
    public boolean j() {
        a aVar = this.z;
        if (aVar != null) {
            return aVar.j();
        }
        return false;
    }

    public long gp() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        if (gVar != null) {
            return gVar.hh();
        }
        return 0L;
    }

    public String t() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        return gVar != null ? gVar.lq() : "";
    }

    public double vm() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        if (gVar != null) {
            return gVar.js();
        }
        return 0.0d;
    }

    public int y() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        if (gVar != null) {
            return gVar.y();
        }
        return 0;
    }

    public int ec() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        if (gVar != null) {
            return gVar.ec();
        }
        return 0;
    }

    public String bv() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        return gVar != null ? gVar.vm() : "";
    }

    public int gb() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        if (gVar != null) {
            return gVar.l();
        }
        return 0;
    }

    public String jq() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        return gVar != null ? gVar.h() : "";
    }

    public String sv() {
        com.bytedance.msdk.core.uy.g gVar = this.g;
        return gVar != null ? gVar.tb() : "";
    }

    @Override // com.bytedance.msdk.api.z.dl
    public String z() {
        dl dlVar = this.dl;
        return dlVar != null ? dlVar.z() : "";
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void z(String str) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.z(str);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void z(int i) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.z(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int g() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.g();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int dl() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.dl();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void g(int i) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.g(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void dl(int i) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.dl(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int a() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.a();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int gc() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.gc();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void a(int i) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.a(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public String m() {
        dl dlVar = this.dl;
        return dlVar != null ? dlVar.m() : "";
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void g(String str) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.g(str);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public boolean e() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.e();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void gc(int i) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.gc(i);
        }
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int gz() {
        dl dlVar = this.dl;
        if (dlVar != null) {
            return dlVar.gz();
        }
        return 0;
    }

    public boolean f() {
        int iIq = iq();
        Map<String, Object> mapOq = oq();
        if (mapOq == null) {
            return false;
        }
        Object obj = mapOq.get("use_share_cache");
        return (obj instanceof Boolean) && (iIq == 1 || iIq == 5 || iIq == 10 || iIq == 7) && ((Boolean) obj).booleanValue();
    }

    public void z(PluginValueSet pluginValueSet) {
        if (this.z == null || pluginValueSet == null) {
            return;
        }
        this.z = new gc(iq(), pluginValueSet);
    }

    public boolean yx() {
        return this.f367a;
    }

    public void z(boolean z) {
        this.f367a = z;
    }
}
