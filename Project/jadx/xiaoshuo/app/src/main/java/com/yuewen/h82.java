package com.yuewen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11958b;
    public String c;
    public String d;

    public h82(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("role");
        StringBuilder sb = new StringBuilder();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.getJSONArray(i).optString(1);
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(strOptString);
            }
        }
        this.d = sb.toString();
        this.c = jSONObject.optString("title");
        this.f11957a = jSONObject.optString("cover");
        this.f11958b = jSONObject.optString("book_id");
    }

    public static h82 a(JSONObject jSONObject) throws JSONException {
        return new h82(jSONObject);
    }
}
