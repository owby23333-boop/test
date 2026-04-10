package com.bytedance.embedapplog;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f290a;
    private String dl;
    private long g;
    private final JSONObject gc = new JSONObject();
    private int m;
    private String z;

    public void z(String str) {
        this.z = str;
    }

    public String z() {
        return this.z;
    }

    public void z(long j) {
        this.g = j;
    }

    public void g(String str) {
        this.dl = str;
    }

    public void z(int i) {
        this.m = i;
    }

    public void dl(String str) {
        this.f290a = str;
    }

    public JSONObject g() {
        return this.gc;
    }

    public void dl() {
        try {
            this.gc.putOpt("duration", Long.valueOf(this.g));
            if ("d_i0".equals(this.z) || "d_a0".equals(this.z)) {
                this.gc.putOpt("data", new JSONObject(this.dl));
            } else {
                this.gc.putOpt("data", this.dl);
            }
            this.gc.putOpt(MediationConstant.KEY_ERROR_MSG, this.f290a);
        } catch (JSONException e) {
            js.z("__kite json error " + e.getMessage());
        }
    }

    public String toString() {
        return "FingerInfo{name='" + this.z + "', duration=" + this.g + ", data='" + this.dl + "', error='" + this.f290a + "'}";
    }
}
