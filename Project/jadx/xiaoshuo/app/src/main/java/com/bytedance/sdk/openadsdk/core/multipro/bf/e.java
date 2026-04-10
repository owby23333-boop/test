package com.bytedance.sdk.openadsdk.core.multipro.bf;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    public boolean bf;
    public boolean d;
    public boolean e;
    public long ga;
    public long p;
    public boolean tg;
    public boolean v;
    public long vn;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.bf.e$e, reason: collision with other inner class name */
    public interface InterfaceC0145e {
        boolean p();

        e vn();
    }

    public e bf(boolean z) {
        this.tg = z;
        return this;
    }

    public e d(boolean z) {
        this.e = z;
        return this;
    }

    public void e(boolean z) {
        this.v = z;
    }

    public e ga(boolean z) {
        this.d = z;
        return this;
    }

    public e tg(boolean z) {
        this.bf = z;
        return this;
    }

    public e bf(long j) {
        this.vn = j;
        return this;
    }

    public e d(long j) {
        this.p = j;
        return this;
    }

    public e e(long j) {
        this.ga = j;
        return this;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.e);
            jSONObject.put("isFromVideoDetailPage", this.bf);
            jSONObject.put("isFromDetailPage", this.d);
            jSONObject.put("duration", this.ga);
            jSONObject.put("totalPlayDuration", this.vn);
            jSONObject.put("currentPlayPosition", this.p);
            jSONObject.put("isAutoPlay", this.tg);
            jSONObject.put("isMute", this.v);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static e e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        e eVar = new e();
        eVar.d(jSONObject.optBoolean("isCompleted"));
        eVar.tg(jSONObject.optBoolean("isFromVideoDetailPage"));
        eVar.ga(jSONObject.optBoolean("isFromDetailPage"));
        eVar.e(jSONObject.optLong("duration"));
        eVar.bf(jSONObject.optLong("totalPlayDuration"));
        eVar.d(jSONObject.optLong("currentPlayPosition"));
        eVar.bf(jSONObject.optBoolean("isAutoPlay"));
        eVar.e(jSONObject.optBoolean("isMute"));
        return eVar;
    }
}
