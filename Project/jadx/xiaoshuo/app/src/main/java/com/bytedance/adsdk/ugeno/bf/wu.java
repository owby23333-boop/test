package com.bytedance.adsdk.ugeno.bf;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class wu {
    private int bf;
    private JSONObject d;
    private com.bytedance.adsdk.ugeno.component.bf e;
    private wu ga;
    private wu tg;

    public int bf() {
        return this.bf;
    }

    public JSONObject d() {
        return this.d;
    }

    public com.bytedance.adsdk.ugeno.component.bf e() {
        return this.e;
    }

    public wu tg() {
        return this.tg;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.e + ", mEventType=" + this.bf + ", mEvent=" + this.d + '}';
    }

    public void bf(wu wuVar) {
        this.ga = wuVar;
    }

    public void e(com.bytedance.adsdk.ugeno.component.bf bfVar) {
        this.e = bfVar;
    }

    public void e(int i) {
        this.bf = i;
    }

    public void e(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void e(wu wuVar) {
        this.tg = wuVar;
    }
}
