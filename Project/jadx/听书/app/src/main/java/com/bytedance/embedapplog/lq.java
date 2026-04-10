package com.bytedance.embedapplog;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class lq extends mc {
    private long g;

    @Override // com.bytedance.embedapplog.mc
    String a() {
        return "ab";
    }

    lq(ti tiVar) {
        super(tiVar);
    }

    @Override // com.bytedance.embedapplog.mc
    long z() {
        long jJs = this.z.a().js();
        if (jJs < TTAdConstant.AD_MAX_EVENT_TIME) {
            jJs = 600000;
        }
        return this.g + jJs;
    }

    @Override // com.bytedance.embedapplog.mc
    long[] g() {
        return oq.dl;
    }

    @Override // com.bytedance.embedapplog.mc
    boolean dl() throws JSONException {
        JSONObject jSONObjectZ = this.z.gc().z();
        if (this.z.gc().wp() == 0 || jSONObjectZ == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.z.gc().z());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", jCurrentTimeMillis);
        JSONObject jSONObjectDl = r.dl(r.z(yz.z(this.z.g(), this.z.gc().z(), this.z.gz().a(), true, z.a()), r.dl), jSONObject);
        if (jSONObjectDl == null) {
            return false;
        }
        z.wp().g(!o.z(z.m(), jSONObjectDl), jSONObjectDl);
        if (cb.g) {
            cb.z("getAbConfig ".concat(String.valueOf(jSONObjectDl)), null);
        }
        this.z.gc().z(jSONObjectDl);
        this.g = jCurrentTimeMillis;
        return true;
    }
}
