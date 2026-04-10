package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class wu extends w {
    public wu() {
        super(com.bytedance.adsdk.e.bf.d.bf.MOD);
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE;
        Object objE2 = this.e.e(map);
        if (objE2 == null || (objE = this.bf.e(map)) == null) {
            return null;
        }
        return com.bytedance.adsdk.e.bf.tg.e.vn.e((Number) objE2, (Number) objE);
    }
}
