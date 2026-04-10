package com.yuewen;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u23 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18316b;
    public String c;
    public String d;
    public String e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18318b;

        public a(String str, String str2) {
            this.f18317a = str;
            this.f18318b = str2;
        }

        public void a(@NonNull List<String> list) {
            if (!TextUtils.isEmpty(this.f18317a)) {
                list.add("trace_id");
                list.add(this.f18317a);
            }
            if (TextUtils.isEmpty(this.f18318b)) {
                return;
            }
            list.add("ab_test");
            list.add(this.f18318b);
        }
    }

    public u23(String str) {
        this.f18315a = 0L;
        this.f18316b = 0;
        this.c = "";
        this.d = "";
        this.e = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f18315a = jSONObject.optLong("readMillis", jSONObject.optLong("local_reading_millis", 0L));
            this.f18316b = jSONObject.optInt("readChars", 0);
            this.c = jSONObject.optString("traceId", "");
            this.e = jSONObject.optString("abTest", "");
            this.d = jSONObject.optString("recTraceId", "");
        } catch (JSONException unused) {
        }
    }

    public a a() {
        return new a(this.c, this.e);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("readMillis", this.f18315a);
            jSONObject.put("readChars", this.f18316b);
            jSONObject.put("traceId", this.c);
            jSONObject.put("abTest", this.e);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return b().toString();
    }

    public u23() {
        this.f18315a = 0L;
        this.f18316b = 0;
        this.c = "";
        this.d = "";
        this.e = "";
    }
}
