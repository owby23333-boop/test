package com.bytedance.adsdk.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements gz {
    @Override // com.bytedance.adsdk.g.gz
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public String z(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length >= 2) {
            String strValueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(strValueOf)) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strValueOf);
                String strValueOf2 = String.valueOf(objArr[1]);
                if (TextUtils.isEmpty(strValueOf2)) {
                    return null;
                }
                Object objZ = com.bytedance.adsdk.g.g.z.z(strValueOf2).z(jSONObject2);
                if (TextUtils.isEmpty(String.valueOf(objZ))) {
                    if (objArr.length >= 3) {
                        return String.valueOf(objArr[2]);
                    }
                    return null;
                }
                return String.valueOf(objZ);
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        return null;
    }
}
