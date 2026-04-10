package com.bytedance.adsdk.ugeno.dl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ls f228a;
    private JSONObject dl;
    private int g;
    private ls gc;
    private com.bytedance.adsdk.ugeno.g.dl z;

    public com.bytedance.adsdk.ugeno.g.dl z() {
        return this.z;
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.z = dlVar;
    }

    public int g() {
        return this.g;
    }

    public void z(int i) {
        this.g = i;
    }

    public JSONObject dl() {
        return this.dl;
    }

    public void z(JSONObject jSONObject) {
        this.dl = jSONObject;
    }

    public ls a() {
        return this.f228a;
    }

    public void z(ls lsVar) {
        this.f228a = lsVar;
    }

    public void g(ls lsVar) {
        this.gc = lsVar;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.z + ", mEventType=" + this.g + ", mEvent=" + this.dl + '}';
    }
}
