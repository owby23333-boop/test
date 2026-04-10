package com.bytedance.sdk.openadsdk.core.multipro.g;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1272a;
    public boolean dl;
    public long e;
    public boolean g;
    public long gc;
    public boolean gz;
    public long m;
    public boolean z;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.multipro.g.z$z, reason: collision with other inner class name */
    public interface InterfaceC0190z {
        boolean h();

        z x();
    }

    public void z(boolean z) {
        this.gz = z;
    }

    public z g(boolean z) {
        this.f1272a = z;
        return this;
    }

    public z dl(boolean z) {
        this.z = z;
        return this;
    }

    public z a(boolean z) {
        this.g = z;
        return this;
    }

    public z gc(boolean z) {
        this.dl = z;
        return this;
    }

    public z z(long j) {
        this.gc = j;
        return this;
    }

    public z g(long j) {
        this.m = j;
        return this;
    }

    public z dl(long j) {
        this.e = j;
        return this;
    }

    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.z);
            jSONObject.put("isFromVideoDetailPage", this.g);
            jSONObject.put("isFromDetailPage", this.dl);
            jSONObject.put("duration", this.gc);
            jSONObject.put("totalPlayDuration", this.m);
            jSONObject.put("currentPlayPosition", this.e);
            jSONObject.put("isAutoPlay", this.f1272a);
            jSONObject.put("isMute", this.gz);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static z z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        z zVar = new z();
        zVar.dl(jSONObject.optBoolean("isCompleted"));
        zVar.a(jSONObject.optBoolean("isFromVideoDetailPage"));
        zVar.gc(jSONObject.optBoolean("isFromDetailPage"));
        zVar.z(jSONObject.optLong("duration"));
        zVar.g(jSONObject.optLong("totalPlayDuration"));
        zVar.dl(jSONObject.optLong("currentPlayPosition"));
        zVar.g(jSONObject.optBoolean("isAutoPlay"));
        zVar.z(jSONObject.optBoolean("isMute"));
        return zVar;
    }
}
