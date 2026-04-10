package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class vn extends w {
    public vn() {
        super(com.bytedance.adsdk.e.bf.d.bf.GT);
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE;
        Object objE2 = this.e.e(map);
        if (objE2 != null && (objE = this.bf.e(map)) != null && (objE2 instanceof Number) && (objE instanceof Number)) {
            return com.bytedance.adsdk.e.bf.tg.e.d.e((Number) objE2, (Number) objE);
        }
        return null;
    }
}
