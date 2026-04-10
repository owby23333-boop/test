package com.yuewen;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class et1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10851b;

    public et1(int i, long j) {
        this.f10850a = i;
        this.f10851b = j;
    }

    public static et1 b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new et1(jSONObject.getInt("dayCount"), jSONObject.getLong(et.j));
        } catch (JSONException unused) {
            return null;
        }
    }

    public int a() {
        return this.f10850a;
    }

    public long c() {
        return this.f10851b;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dayCount", this.f10850a);
            jSONObject.put(et.j, this.f10851b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return d().toString();
    }
}
