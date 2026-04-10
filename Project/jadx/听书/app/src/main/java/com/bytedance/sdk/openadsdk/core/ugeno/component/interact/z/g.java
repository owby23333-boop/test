package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1340a;
    private long dl;
    private int g;
    private float gc;
    private int z;

    public g(JSONObject jSONObject) {
        this.z = 0;
        this.g = 0;
        this.dl = 0L;
        this.f1340a = 0.1f;
        this.gc = 0.1f;
        if (jSONObject == null) {
            return;
        }
        this.z = jSONObject.optInt("time");
        this.g = jSONObject.optInt("type");
        this.dl = jSONObject.optLong("duration");
        this.f1340a = (float) jSONObject.optDouble("intensity");
        this.gc = (float) jSONObject.optDouble("density");
        if (this.g == 1 || this.dl < 100) {
            z(100L);
        }
    }

    public int z() {
        return this.z;
    }

    public int getType() {
        return this.g;
    }

    public long g() {
        return this.dl;
    }

    public void z(long j) {
        this.dl = j;
    }

    public float dl() {
        return this.f1340a;
    }

    public float a() {
        return this.gc;
    }
}
