package com.bytedance.embedapplog;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class jz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Long f292a;
    final Boolean dl;
    final Long e;
    final String g;
    final Long gc;
    final Integer m;
    final String z;

    jz(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.z = str;
        this.g = str2;
        this.dl = bool;
        this.f292a = l;
        this.gc = l2;
        this.m = num;
        this.e = l3;
    }

    public String toString() {
        return g().toString();
    }

    Map<String, String> z() {
        HashMap map = new HashMap();
        pd.z(map, "id", this.z);
        pd.z(map, "req_id", this.g);
        pd.z(map, "is_track_limited", String.valueOf(this.dl));
        pd.z(map, "take_ms", String.valueOf(this.f292a));
        pd.z(map, "time", String.valueOf(this.gc));
        pd.z(map, "query_times", String.valueOf(this.m));
        pd.z(map, "hw_id_version_code", String.valueOf(this.e));
        return map;
    }

    JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        pd.z(jSONObject, "id", this.z);
        pd.z(jSONObject, "req_id", this.g);
        pd.z(jSONObject, "is_track_limited", this.dl);
        pd.z(jSONObject, "take_ms", this.f292a);
        pd.z(jSONObject, "time", this.gc);
        pd.z(jSONObject, "query_times", this.m);
        pd.z(jSONObject, "hw_id_version_code", this.e);
        return jSONObject;
    }

    static jz z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new jz(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            cb.z(e);
            return null;
        }
    }
}
