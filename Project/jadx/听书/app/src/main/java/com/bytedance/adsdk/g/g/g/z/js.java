package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class js implements com.bytedance.adsdk.g.g.g.g {
    private com.bytedance.adsdk.g.g.g.z dl;
    private com.bytedance.adsdk.g.g.g.z g;
    private com.bytedance.adsdk.g.g.g.z z;

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        Object objZ = this.z.z(map);
        if (objZ == null) {
            return null;
        }
        if (((Boolean) objZ).booleanValue()) {
            return this.g.z(map);
        }
        return this.dl.z(map);
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public com.bytedance.adsdk.g.g.a.gc z() {
        return com.bytedance.adsdk.g.g.a.m.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.g.g.g.g
    public void z(com.bytedance.adsdk.g.g.g.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.adsdk.g.g.g.g
    public void g(com.bytedance.adsdk.g.g.g.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.adsdk.g.g.g.g
    public void dl(com.bytedance.adsdk.g.g.g.z zVar) {
        this.dl = zVar;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public String g() {
        return this.z.g() + "?" + this.g.g() + ":" + this.dl.g();
    }

    public String toString() {
        return g();
    }
}
