package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class od {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15250b;

    public od(boolean z, long j) {
        this.f15250b = z;
        this.f15249a = j;
    }

    public static od a(JSONObject jSONObject) {
        try {
            return new od(jSONObject.getBoolean("is_new"), jSONObject.getLong("end_time"));
        } catch (JSONException unused) {
            return null;
        }
    }
}
