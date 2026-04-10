package com.bytedance.sdk.openadsdk.tg.d;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class bh extends e {
    private String bf;
    private long d;
    private long ga;
    private long tg;

    @Override // com.bytedance.sdk.openadsdk.tg.d.tg
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.bf);
            jSONObject.put("preload_size", this.d);
            jSONObject.put("load_time", this.tg);
            jSONObject.put("local_cache", this.ga);
            e(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bf(long j) {
        this.tg = j;
    }

    public void d(long j) {
        this.ga = j;
    }

    public void e(String str) {
        this.bf = str;
    }

    public void e(long j) {
        this.d = j;
    }

    public long e() {
        return this.ga;
    }
}
