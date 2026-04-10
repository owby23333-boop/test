package com.bytedance.adsdk.g;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gz {
    @Override // com.bytedance.adsdk.g.gz
    public Object z(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        String strValueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        return Uri.encode(strValueOf);
    }
}
