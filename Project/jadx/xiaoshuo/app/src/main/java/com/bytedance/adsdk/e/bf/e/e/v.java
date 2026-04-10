package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class v extends w {
    public v() {
        super(com.bytedance.adsdk.e.bf.d.bf.LT_EQ);
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE;
        if (this.e.e(map) == null || (objE = this.bf.e(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.e.bf.tg.e.d.e((Number) r0, (Number) objE)).booleanValue());
    }
}
