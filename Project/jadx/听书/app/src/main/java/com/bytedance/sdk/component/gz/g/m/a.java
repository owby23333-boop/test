package com.bytedance.sdk.component.gz.g.m;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f744a;
    private boolean dl;
    private String g;
    private JSONObject gc;
    private int m;
    private String z;

    a(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.z = str;
        this.g = str2;
        this.dl = z;
        this.f744a = i;
        this.gc = jSONObject;
        this.m = i2;
    }

    public JSONObject z() {
        if (this.gc == null) {
            this.gc = new JSONObject();
        }
        return this.gc;
    }

    public String g() {
        return this.z;
    }

    public String dl() {
        return this.g;
    }

    public boolean a() {
        return this.dl;
    }

    public int gc() {
        return this.f744a;
    }

    public void z(int i) {
        this.f744a = i;
    }
}
