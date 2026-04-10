package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class s implements com.bytedance.adsdk.e.bf.e.e {
    private final com.bytedance.adsdk.e.bf.d.bf e;

    public s(com.bytedance.adsdk.e.bf.d.bf bfVar) {
        this.e = bfVar;
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public String bf() {
        return this.e.e();
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return bf();
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public com.bytedance.adsdk.e.bf.d.tg e() {
        return this.e;
    }
}
