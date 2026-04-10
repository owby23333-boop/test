package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ga extends w {
    public ga() {
        super(com.bytedance.adsdk.e.bf.d.bf.GT_EQ);
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE;
        if (this.e.e(map) == null || (objE = this.bf.e(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.bytedance.adsdk.e.bf.tg.e.tg.e(r0, (Number) objE)).booleanValue());
    }
}
