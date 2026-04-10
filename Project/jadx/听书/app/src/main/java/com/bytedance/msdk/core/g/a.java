package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f387a;
    private final String g;
    private String[] gc;
    private final String z;
    private final Map<String, Float> dl = new ConcurrentHashMap();
    private final Map<String, gc> m = new ConcurrentHashMap();

    public a(String str, String str2, JSONObject jSONObject) {
        this.z = str;
        this.g = str2;
        this.f387a = jSONObject.optString("symbol");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("score_fit_type");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            this.gc = new String[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    this.gc[i] = strOptString;
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("range");
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("value");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0 && jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                            this.m.put(strOptString, new gc(strOptString, jSONArrayOptJSONArray2, jSONArrayOptJSONArray3));
                        }
                    }
                }
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("rule_exc_mode");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
            return;
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.dl.put(next, Float.valueOf((float) jSONObjectOptJSONObject2.optDouble(next, 0.0d)));
        }
    }

    public String z() {
        return this.z;
    }

    public Map<String, Float> g() {
        return this.dl;
    }

    public String[] dl() {
        return this.gc;
    }

    public String a() {
        return this.f387a;
    }

    public Map<String, gc> gc() {
        return this.m;
    }
}
