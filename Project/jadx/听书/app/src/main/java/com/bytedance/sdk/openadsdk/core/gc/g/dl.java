package com.bytedance.sdk.openadsdk.core.gc.g;

import com.umeng.umcrash.UMCrash;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static JSONObject z(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder("id=");
            sb.append(str).append("&timestamp=");
            sb.append(iCurrentTimeMillis).append("&ext=");
            sb.append(str2);
            String upperCase = com.bytedance.sdk.component.utils.gc.g(sb.toString()).toUpperCase();
            jSONObject.put("id", str);
            jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, iCurrentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
