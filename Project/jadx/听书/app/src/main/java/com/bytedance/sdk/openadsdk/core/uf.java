package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f1326a = new HashMap();
    private long dl;
    private long g;
    private String z;

    private uf(String str, long j) {
        this.z = str;
        this.g = j;
        this.dl = j;
    }

    public static uf z(String str) {
        return new uf(str, SystemClock.elapsedRealtime());
    }

    public long z() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.g;
        this.f1326a.put(this.z, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long g(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.dl;
        this.dl = jElapsedRealtime;
        this.f1326a.put(str, Long.valueOf(j));
        return j;
    }

    public void z(String str, long j) {
        this.f1326a.put(str, Long.valueOf(j));
    }

    public long g() {
        return SystemClock.elapsedRealtime() - this.g;
    }

    public void z(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f1326a.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && (value.longValue() > j || key.equals("armor_load_cost"))) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public JSONObject z(long j) {
        JSONObject jSONObject = new JSONObject();
        z(jSONObject, j);
        return jSONObject;
    }
}
