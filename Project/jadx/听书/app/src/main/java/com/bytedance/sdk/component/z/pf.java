package com.bytedance.sdk.component.z;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class pf {
    private final Map<String, Object> z = new ConcurrentHashMap();

    public static pf z() {
        return new pf();
    }

    private pf() {
    }

    public pf z(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.z.put(str, obj);
        }
        return this;
    }

    public String g() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.z.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
