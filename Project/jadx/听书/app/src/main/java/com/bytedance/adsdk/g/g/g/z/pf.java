package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf implements com.bytedance.adsdk.g.g.g.z {
    private Number z;

    public pf(String str) {
        if (str.indexOf(46) >= 0) {
            Float fValueOf = Float.valueOf(str);
            this.z = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.z = Double.valueOf(str);
                return;
            }
            return;
        }
        try {
            this.z = Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            this.z = Long.valueOf(str);
        }
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        return this.z;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public com.bytedance.adsdk.g.g.a.gc z() {
        return com.bytedance.adsdk.g.g.a.m.NUMBER;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public String g() {
        return this.z.toString();
    }

    public String toString() {
        return g();
    }
}
