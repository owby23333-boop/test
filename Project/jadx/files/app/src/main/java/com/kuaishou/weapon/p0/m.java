package com.kuaishou.weapon.p0;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public String a;
    private JSONObject b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16745d;

    public m(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    public JSONObject a() {
        return this.b;
    }

    public void a(String str) {
        this.f16744c = str;
    }

    public String b() {
        return this.f16744c;
    }

    public void b(String str) {
        this.f16745d = str;
    }

    public String c() {
        return this.f16745d;
    }
}
