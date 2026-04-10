package com.yuewen;

import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class hc2 {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11996b;
    public final int c;
    public final int d;

    public hc2(JSONObject jSONObject) throws JSONException {
        this.f11995a = jSONObject.getInt("status");
        this.f11996b = jSONObject.getInt("readTime");
        this.c = jSONObject.getInt("targetReadTime");
        this.d = jSONObject.getInt("leftCount");
    }

    public static hc2 a(JSONObject jSONObject) throws JSONException {
        return new hc2(jSONObject);
    }

    public long b() {
        return ((long) (this.f11996b * 1000)) / TimeUnit.MINUTES.toMillis(1L);
    }

    public long c() {
        return Math.max((((long) (this.c * 1000)) / TimeUnit.MINUTES.toMillis(1L)) - b(), 0L);
    }

    public boolean d() {
        return this.f11995a == 1;
    }

    public boolean e() {
        return this.f11995a == 3;
    }

    public boolean f() {
        return h() || e();
    }

    public boolean g() {
        return this.d <= 0;
    }

    public boolean h() {
        return this.f11995a == 2;
    }

    public boolean i() {
        return this.f11995a == 0;
    }
}
