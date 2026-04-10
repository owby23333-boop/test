package com.bytedance.adsdk.g;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements gz {
    @Override // com.bytedance.adsdk.g.gz
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Boolean z(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
