package com.bytedance.sdk.openadsdk.core.kb.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1212a;
    private JSONObject dl;
    private String g;
    private String z;

    public static gz z() {
        return new gz();
    }

    public gz z(JSONObject jSONObject) {
        this.f1212a = jSONObject;
        return this;
    }

    public gz z(String str) {
        this.z = str;
        return this;
    }

    public gz g(String str) {
        this.g = str;
        return this;
    }

    public gz g(JSONObject jSONObject) {
        this.dl = jSONObject;
        return this;
    }

    public String g() {
        return this.z;
    }

    public String dl() {
        return this.g;
    }

    public JSONObject a() {
        return this.dl;
    }

    public JSONObject gc() {
        return this.f1212a;
    }
}
