package com.bytedance.adsdk.g;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements gz {
    @Override // com.bytedance.adsdk.g.gz
    public Object z(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                String strValueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(strValueOf) && !TextUtils.equals(strValueOf, "null")) {
                    return strValueOf;
                }
            }
        }
        return null;
    }
}
