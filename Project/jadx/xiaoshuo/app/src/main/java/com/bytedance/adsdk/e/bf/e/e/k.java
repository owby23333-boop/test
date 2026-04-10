package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k implements com.bytedance.adsdk.e.bf.e.e {
    private final String e;

    public k(String str) {
        this.e = str;
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public String bf() {
        return '\'' + this.e + "'";
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        return this.e;
    }

    public String toString() {
        return bf();
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public com.bytedance.adsdk.e.bf.d.tg e() {
        return com.bytedance.adsdk.e.bf.d.ga.STRING;
    }
}
