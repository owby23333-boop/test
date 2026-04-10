package com.bytedance.embedapplog;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class un extends mc {
    @Override // com.bytedance.embedapplog.mc
    String a() {
        return "c";
    }

    un(ti tiVar) {
        super(tiVar);
    }

    @Override // com.bytedance.embedapplog.mc
    long z() {
        return this.z.a().gz() + 21600000;
    }

    @Override // com.bytedance.embedapplog.mc
    long[] g() {
        return oq.dl;
    }

    @Override // com.bytedance.embedapplog.mc
    public boolean dl() throws JSONException {
        JSONObject jSONObjectZ = this.z.gc().z();
        if (this.z.gc().wp() == 0 || jSONObjectZ == null || this.z.a().gz() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", jSONObjectZ);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject jSONObjectG = r.g(r.z(yz.z(this.z.g(), this.z.gc().z(), this.z.gz().dl(), true, z.a()), r.dl), jSONObject);
        z.wp().z(!o.z(jSONObjectG, this.z.a().e()), jSONObjectG);
        if (jSONObjectG == null) {
            return false;
        }
        this.z.a().z(jSONObjectG);
        return true;
    }
}
