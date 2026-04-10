package com.anythink.core.common.e;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f7368h = "business_type";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7369i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7370j = 1001;
    public String a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7375g;

    public static String a(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f7368h, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final String a() {
        return this.f7372d + "--extra: " + this.f7375g + "--requestType: " + this.b + "--content:" + this.f7373e;
    }
}
