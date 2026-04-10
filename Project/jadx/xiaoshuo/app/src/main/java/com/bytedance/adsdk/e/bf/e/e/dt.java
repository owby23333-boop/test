package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class dt implements com.bytedance.adsdk.e.bf.e.e {
    private com.bytedance.adsdk.e.bf.d.d e;

    public dt(com.bytedance.adsdk.e.bf.d.d dVar) {
        this.e = dVar;
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
