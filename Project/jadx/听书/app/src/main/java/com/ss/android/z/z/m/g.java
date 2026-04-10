package com.ss.android.z.z.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    public static long z(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static boolean z(com.ss.android.socialbase.downloader.i.z zVar, String str) {
        if (zVar == null || zVar.z("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }

    public static JSONObject z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        return jSONObject2;
    }

    public static JSONObject z(JSONObject jSONObject) {
        return z(jSONObject, new JSONObject());
    }

    public static JSONObject z(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    z(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    public static String z(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
