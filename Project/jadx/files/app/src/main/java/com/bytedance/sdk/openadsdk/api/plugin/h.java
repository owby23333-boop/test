package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private long b;
    private Map<String, Long> hj = new HashMap();
    private String mb;
    private long ox;

    private h(String str, long j2) {
        this.mb = str;
        this.ox = j2;
        this.b = this.ox;
    }

    public static h mb(String str) {
        return new h(str, SystemClock.elapsedRealtime());
    }

    public long ox(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.b;
        this.b = SystemClock.elapsedRealtime();
        this.hj.put(str, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public long mb() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.ox;
        this.hj.put(this.mb, Long.valueOf(jElapsedRealtime));
        return jElapsedRealtime;
    }

    public void mb(JSONObject jSONObject, long j2) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.hj.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j2) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
