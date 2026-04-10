package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends p {
    public a() {
        super(com.bytedance.adsdk.g.g.a.dl.EQ);
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        Object objZ = this.z.z(map);
        Object objZ2 = this.g.z(map);
        if (objZ == null && objZ2 == null) {
            return Boolean.TRUE;
        }
        if (objZ == null && objZ2 != null) {
            return Boolean.FALSE;
        }
        if (objZ != null && objZ2 == null) {
            return Boolean.FALSE;
        }
        if ((objZ instanceof Number) && (objZ2 instanceof Number)) {
            return Boolean.valueOf(com.bytedance.adsdk.g.g.gc.z.g.z((Number) objZ, (Number) objZ2));
        }
        return Boolean.valueOf(objZ.equals(objZ2));
    }
}
