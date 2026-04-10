package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class a {
    private long bf;
    private long d;
    private String e;
    private Map<String, Long> tg = new HashMap();

    private a(String str, long j) {
        this.e = str;
        this.bf = j;
        this.d = j;
    }

    public static a e(String str) {
        return new a(str, SystemClock.elapsedRealtime());
    }

    public long bf(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.d;
        this.d = jElapsedRealtime;
        this.tg.put(str, Long.valueOf(j));
        return j;
    }

    public long e() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.bf;
        this.tg.put(this.e, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void e(String str, long j) {
        this.tg.put(str, Long.valueOf(j));
    }

    public long bf() {
        return SystemClock.elapsedRealtime() - this.bf;
    }

    public void e(JSONObject jSONObject, long j) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.tg.entrySet()) {
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

    public JSONObject e(long j) {
        JSONObject jSONObject = new JSONObject();
        e(jSONObject, j);
        return jSONObject;
    }
}
