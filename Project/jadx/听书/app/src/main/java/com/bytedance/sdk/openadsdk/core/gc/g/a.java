package com.bytedance.sdk.openadsdk.core.gc.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public Map<String, JSONObject> g;
    public int z;

    public boolean z() {
        int i = this.z;
        return i > 20000 && i < 100000;
    }

    public static a z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("code");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
        HashMap map = new HashMap();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("id", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString("req_id", "");
                    if (!TextUtils.isEmpty(z(strOptString, strOptString2))) {
                        map.put(z(strOptString, strOptString2), jSONObjectOptJSONObject);
                    }
                }
            }
        }
        a aVar = new a();
        aVar.g = map;
        aVar.z = iOptInt;
        return aVar;
    }

    public static String z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2 + "_" + str;
    }
}
