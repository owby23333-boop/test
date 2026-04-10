package com.ss.android.download.api.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class bf {
    public static long e(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return 0L;
        }
        try {
            return Long.valueOf(jSONObject.optString(str)).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static boolean e(com.ss.android.socialbase.downloader.p.e eVar, String str) {
        if (eVar == null || eVar.e("apk_update_handler_enable", 1) != 1) {
            return false;
        }
        return "application/ttpatch".equals(str);
    }

    public static JSONObject e(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    @NonNull
    public static JSONObject e(JSONObject jSONObject) {
        return e(jSONObject, new JSONObject());
    }

    @NonNull
    public static JSONObject e(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null && jSONObjectArr.length != 0) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    e(jSONObject2, jSONObject);
                }
            }
        }
        return jSONObject;
    }

    public static String e(String... strArr) {
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }
}
