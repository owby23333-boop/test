package com.ss.android.downloadlib.p;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class tg {
    public static String e(String str, String str2, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("notification_jump_url", str2);
            }
            jSONObject.put("show_toast", z);
            jSONObject.put("business_type", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
