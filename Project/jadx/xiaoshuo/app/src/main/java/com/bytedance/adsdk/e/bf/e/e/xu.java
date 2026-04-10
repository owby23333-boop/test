package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class xu extends w {
    public xu() {
        super(com.bytedance.adsdk.e.bf.d.bf.MULTI);
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE;
        Object objE2 = this.e.e(map);
        if (objE2 == null || (objE = this.bf.e(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.e.bf.tg.e.p.e((Number) objE2, (Number) objE);
    }
}
