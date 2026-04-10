package com.bytedance.sdk.openadsdk.core.ugeno;

import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.sdk.component.kb.z.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends com.bytedance.adsdk.ugeno.dl.z.g {
    private volatile z m;

    public fo(fv fvVar) {
        super(fvVar);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.z.g
    public void dl(ls lsVar, fv.g gVar, fv.z zVar) {
        if (this.m == null) {
            this.m = g();
        }
        this.m.z(lsVar);
        this.m.z(gVar);
        this.m.z(zVar);
        JSONObject jSONObjectDl = lsVar.dl();
        if (jSONObjectDl == null) {
            return;
        }
        new g.z(jSONObjectDl.optString("type")).g(this.f234a).z(new com.bytedance.sdk.component.kb.a.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fo.1
            @Override // com.bytedance.sdk.component.kb.a.dl
            public void z(com.bytedance.sdk.component.kb.z.z zVar2) {
                fo.this.z(zVar2);
            }
        }).z().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.component.kb.z.z zVar) {
        if (this.gc) {
            return;
        }
        z zVarG = g();
        zVarG.z(z(zVarG.dl, zVar));
        zVar.z(zVarG);
    }

    protected ls z(ls lsVar, com.bytedance.sdk.component.kb.z.z zVar) {
        com.bytedance.sdk.component.kb.dl.z zVar2;
        if (lsVar == null || zVar == null) {
            return lsVar;
        }
        ls lsVar2 = new ls();
        com.bytedance.adsdk.ugeno.g.dl dlVarZ = lsVar.z();
        if (dlVarZ == null) {
            return lsVar;
        }
        lsVar2.z(lsVar.g());
        com.bytedance.sdk.component.kb.dl.z zVarE = zVar.e();
        JSONObject jSONObjectZ = z(dlVarZ, lsVar2, zVarE);
        com.bytedance.sdk.component.kb.dl.dl dlVarZ2 = com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(zVar.a());
        List<com.bytedance.sdk.component.kb.dl.z> listZ = dlVarZ2.z(zVarE, dlVarZ.uy(), new HashMap());
        lsVar2.z(jSONObjectZ);
        if (!listZ.isEmpty()) {
            com.bytedance.sdk.component.kb.dl.z zVar3 = listZ.get(0);
            if (zVar3 == null) {
                return lsVar2;
            }
            ls lsVar3 = new ls();
            lsVar3.z(z(dlVarZ, lsVar3, zVar3));
            lsVar3.z(dlVarZ);
            lsVar2.z(lsVar3);
        }
        List<com.bytedance.sdk.component.kb.dl.z> listG = dlVarZ2.g(zVarE, dlVarZ.uy(), new HashMap());
        if (listG.isEmpty() || (zVar2 = listG.get(0)) == null) {
            return lsVar2;
        }
        ls lsVar4 = new ls();
        lsVar4.z(z(dlVarZ, lsVar4, zVar2));
        lsVar4.z(dlVarZ);
        lsVar2.g(lsVar4);
        return lsVar2;
    }

    private JSONObject z(com.bytedance.adsdk.ugeno.g.dl dlVar, ls lsVar, com.bytedance.sdk.component.kb.dl.z zVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (zVar == null) {
                return jSONObject;
            }
            Map<String, String> mapDl = zVar.dl();
            String strZ = zVar.z();
            lsVar.z(dlVar);
            jSONObject.put("type", strZ);
            if (mapDl != null && !mapDl.isEmpty()) {
                for (Map.Entry<String, String> entry : mapDl.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    private z g() {
        if (this.m != null) {
            return this.m;
        }
        synchronized (z.class) {
            if (this.m != null) {
                return this.m;
            }
            this.m = new z();
            return this.m;
        }
    }

    class z implements com.bytedance.sdk.component.kb.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private fv.g f1358a;
        private ls dl;
        fv.z z;

        z() {
        }

        public void z(ls lsVar) {
            this.dl = lsVar;
        }

        public void z(fv.g gVar) {
            this.f1358a = gVar;
        }

        public void z(fv.z zVar) {
            this.z = zVar;
        }

        @Override // com.bytedance.sdk.component.kb.a.g
        public void z() {
            fo.this.g(this.dl, this.f1358a, this.z);
        }
    }
}
