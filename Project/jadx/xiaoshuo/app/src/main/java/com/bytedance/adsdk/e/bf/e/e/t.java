package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t implements com.bytedance.adsdk.e.bf.e.e {
    private Number e;

    public t(String str) {
        if (str.indexOf(46) <= -1) {
            try {
                this.e = Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                this.e = Long.valueOf(str);
            }
        } else {
            Float fValueOf = Float.valueOf(str);
            this.e = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.e = Double.valueOf(str);
            }
        }
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public String bf() {
        return this.e.toString();
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
        return com.bytedance.adsdk.e.bf.d.ga.NUMBER;
    }
}
