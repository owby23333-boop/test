package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends p {
    public gz() {
        super(com.bytedance.adsdk.g.g.a.dl.LT_EQ);
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        Object objZ;
        if (this.z.z(map) == null || (objZ = this.g.z(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.g.g.gc.z.dl.z(r0, (Number) objZ)).booleanValue());
    }
}
