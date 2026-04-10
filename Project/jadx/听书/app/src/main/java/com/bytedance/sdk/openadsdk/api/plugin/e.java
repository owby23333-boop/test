package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f895a = new HashMap();
    private long dl;
    private long g;
    private String z;

    private e(String str, long j) {
        this.z = str;
        this.g = j;
        this.dl = j;
    }

    public static e z(String str) {
        return new e(str, SystemClock.elapsedRealtime());
    }

    public long z() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.g;
        this.f895a.put(this.z, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long g(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.dl;
        this.dl = SystemClock.elapsedRealtime();
        this.f895a.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void z(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f895a.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
