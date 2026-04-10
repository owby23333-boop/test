package com.bytedance.adsdk.e.bf.e.e;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.adsdk.e.bf.e.bf {
    private com.bytedance.adsdk.e.bf.e.e bf;
    private com.bytedance.adsdk.e.bf.e.e d;
    private com.bytedance.adsdk.e.bf.e.e e;

    @Override // com.bytedance.adsdk.e.bf.e.bf
    public void bf(com.bytedance.adsdk.e.bf.e.e eVar) {
        this.bf = eVar;
    }

    @Override // com.bytedance.adsdk.e.bf.e.bf
    public void d(com.bytedance.adsdk.e.bf.e.e eVar) {
        this.d = eVar;
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE = this.e.e(map);
        if (objE == null) {
            return null;
        }
        return ((Boolean) objE).booleanValue() ? this.bf.e(map) : this.d.e(map);
    }

    public String toString() {
        return bf();
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public String bf() {
        return this.e.bf() + "?" + this.bf.bf() + ":" + this.d.bf();
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public com.bytedance.adsdk.e.bf.d.tg e() {
        return com.bytedance.adsdk.e.bf.d.ga.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.e.bf.e.bf
    public void e(com.bytedance.adsdk.e.bf.e.e eVar) {
        this.e = eVar;
    }
}
