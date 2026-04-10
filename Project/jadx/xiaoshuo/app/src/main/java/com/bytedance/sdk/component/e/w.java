package com.bytedance.sdk.component.e;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    private final Map<String, Object> e = new ConcurrentHashMap();

    private w() {
    }

    public static w e() {
        return new w();
    }

    public String bf() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.e.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public w e(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.e.put(str, obj);
        }
        return this;
    }
}
