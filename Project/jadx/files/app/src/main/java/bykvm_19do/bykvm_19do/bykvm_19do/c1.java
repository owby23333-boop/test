package bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class c1 {
    final String a;
    final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Boolean f665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Long f666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Long f667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Integer f668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Long f669g;

    c1(String str, String str2, Boolean bool, Long l2, Long l3, Integer num, Long l4) {
        this.a = str;
        this.b = str2;
        this.f665c = bool;
        this.f666d = l2;
        this.f667e = l3;
        this.f668f = num;
        this.f669g = l4;
    }

    @Nullable
    @AnyThread
    static c1 a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c1(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @NonNull
    Map<String, String> a() {
        HashMap map = new HashMap();
        z0.a(map, "id", this.a);
        z0.a(map, "req_id", this.b);
        z0.a(map, "is_track_limited", String.valueOf(this.f665c));
        z0.a(map, "take_ms", String.valueOf(this.f666d));
        z0.a(map, "time", String.valueOf(this.f667e));
        z0.a(map, "query_times", String.valueOf(this.f668f));
        z0.a(map, "hw_id_version_code", String.valueOf(this.f669g));
        return map;
    }

    @NonNull
    JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        z0.a(jSONObject, "id", this.a);
        z0.a(jSONObject, "req_id", this.b);
        z0.a(jSONObject, "is_track_limited", this.f665c);
        z0.a(jSONObject, "take_ms", this.f666d);
        z0.a(jSONObject, "time", this.f667e);
        z0.a(jSONObject, "query_times", this.f668f);
        z0.a(jSONObject, "hw_id_version_code", this.f669g);
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }
}
