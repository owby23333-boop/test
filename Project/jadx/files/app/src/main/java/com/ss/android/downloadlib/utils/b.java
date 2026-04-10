package com.ss.android.downloadlib.utils;

import android.text.TextUtils;
import com.anythink.core.common.e.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static String mb(String str, String str2, boolean z2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("extra", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("notification_jump_url", str2);
            }
            jSONObject.put("show_toast", z2);
            jSONObject.put(o.f7368h, str3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
