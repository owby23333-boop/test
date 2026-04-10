package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tb implements com.bytedance.adsdk.g.g.g.z {
    private final String z;

    public tb(String str) {
        this.z = str;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        return this.z;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public com.bytedance.adsdk.g.g.a.gc z() {
        return com.bytedance.adsdk.g.g.a.m.STRING;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public String g() {
        return "'" + this.z + "'";
    }

    public String toString() {
        return g();
    }
}
