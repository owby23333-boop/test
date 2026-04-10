package com.bytedance.adsdk.g.g.g.z;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bytedance.adsdk.g.g.g.z {
    private final Object z;

    public e(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.z = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.z = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase("null")) {
                this.z = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        return this.z;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public com.bytedance.adsdk.g.g.a.gc z() {
        return com.bytedance.adsdk.g.g.a.m.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.z + "]";
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public String g() {
        Object obj = this.z;
        return obj != null ? obj.toString() : "NULL";
    }
}
