package com.yuewen;

import com.duokan.core.diagnostic.LogLevel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b50 extends g82 {
    public int s;
    public String t;
    public String u;
    public int v;

    public b50(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.s = jSONObject.optInt("type");
        this.t = jSONObject.optString("object_id");
        this.u = jSONObject.optString("title");
        this.v = jSONObject.optInt("rate");
    }

    public static b50 d(JSONObject jSONObject) {
        try {
            return new b50(jSONObject);
        } catch (JSONException e) {
            ia0.w().j(LogLevel.ERROR, "CommentItem", "parse from json error", e);
            return null;
        }
    }
}
