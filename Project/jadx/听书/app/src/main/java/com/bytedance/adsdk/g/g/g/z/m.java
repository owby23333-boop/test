package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends p {
    public m() {
        super(com.bytedance.adsdk.g.g.a.dl.GT);
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        Object objZ;
        Object objZ2 = this.z.z(map);
        if (objZ2 == null || (objZ = this.g.z(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.g.g.gc.z.dl.z(objZ2, (Number) objZ);
    }
}
