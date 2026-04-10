package com.bytedance.sdk.component.panglearmor.g;

import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static gc z;
    private boolean g = false;
    private long dl = 180000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f784a = 43200000;
    private long gc = 3;
    private long m = 30;
    private long e = 15;

    private gc() {
    }

    public static gc z() {
        if (z == null) {
            synchronized (gc.class) {
                if (z == null) {
                    z = new gc();
                }
            }
        }
        return z;
    }

    public synchronized void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.g = jSONObject.optBoolean("sensorenable", false);
                this.dl = jSONObject.optLong(an.aU, 180000L);
                this.f784a = jSONObject.optLong("expireduation", 43200000L);
                this.gc = jSONObject.optLong("showinterval", 3L);
                this.m = jSONObject.optLong("azimuth_unit", 30L);
                this.e = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }

    public boolean g() {
        return this.g;
    }

    public long dl() {
        return this.f784a;
    }

    public long a() {
        return this.dl;
    }

    public long gc() {
        return this.gc;
    }

    public long m() {
        return this.m;
    }

    public long e() {
        return this.e;
    }
}
