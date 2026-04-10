package com.bytedance.sdk.openadsdk.m.dl;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1451a;
    private int dl;
    private int e;
    private long fo;
    private long g;
    private String gc;
    private long gz;
    private boolean kb;
    private JSONArray m;
    private int uy;
    private long z;

    public void z(boolean z) {
        this.kb = z;
    }

    public void z(long j) {
        this.fo = j;
    }

    public void z(int i) {
        this.uy = i;
    }

    public void z(JSONArray jSONArray) {
        this.m = jSONArray;
    }

    public void g(long j) {
        this.gz = j;
    }

    public void g(int i) {
        this.e = i;
    }

    public void dl(long j) {
        this.z = j;
    }

    public void a(long j) {
        this.g = j;
    }

    public void dl(int i) {
        this.dl = i;
    }

    public void a(int i) {
        this.f1451a = i;
    }

    public void z(String str) {
        this.gc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.z);
            jSONObject.put("total_duration", this.g);
            jSONObject.put("error_code", this.dl);
            jSONObject.put("extra_error_code", this.f1451a);
            jSONObject.put("error_message", this.gc);
            jSONObject.put("event_list", this.m);
            jSONObject.put("vbtt_skip_type", this.e);
            jSONObject.put("video_cache_size", this.gz);
            jSONObject.put("current", this.fo);
            jSONObject.put("percent", this.uy);
            jSONObject.put("has_endcard_skip", this.kb);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }
}
