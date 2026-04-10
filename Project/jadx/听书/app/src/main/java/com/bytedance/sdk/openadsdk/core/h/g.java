package com.bytedance.sdk.openadsdk.core.h;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1115a;
    private JSONObject dl;
    private Map<String, String> g;
    private JSONObject gc;
    private byte[] z;

    public JSONObject z() {
        return this.gc;
    }

    public void z(JSONObject jSONObject) {
        this.gc = jSONObject;
    }

    public int g() {
        return this.f1115a;
    }

    public void z(int i) {
        this.f1115a = i;
    }

    public byte[] dl() {
        return this.z;
    }

    public void z(byte[] bArr) {
        this.z = bArr;
    }

    public JSONObject a() {
        return this.dl;
    }

    public void g(JSONObject jSONObject) {
        this.dl = jSONObject;
    }

    public Map<String, String> gc() {
        return this.g;
    }

    public void z(Map<String, String> map) {
        this.g = map;
    }
}
