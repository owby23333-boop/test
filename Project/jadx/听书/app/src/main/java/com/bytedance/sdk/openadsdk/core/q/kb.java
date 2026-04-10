package com.bytedance.sdk.openadsdk.core.q;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class kb implements com.bytedance.sdk.component.gz.z.z.gc {
    com.bytedance.sdk.component.fo.g z;

    public kb(com.bytedance.sdk.component.fo.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.component.gz.z.z.gc
    public boolean z() {
        com.bytedance.sdk.component.fo.g gVar = this.z;
        if (gVar != null) {
            return gVar.gz();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.z.gc
    public String g() {
        com.bytedance.sdk.component.fo.g gVar = this.z;
        return gVar != null ? gVar.a() : "";
    }

    @Override // com.bytedance.sdk.component.gz.z.z.gc
    public int dl() {
        com.bytedance.sdk.component.fo.g gVar = this.z;
        if (gVar != null) {
            return gVar.z();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.component.gz.z.z.gc
    public String a() {
        com.bytedance.sdk.component.fo.g gVar = this.z;
        return gVar != null ? gVar.g() : "";
    }

    @Override // com.bytedance.sdk.component.gz.z.z.gc
    public Map<String, String> gc() {
        com.bytedance.sdk.component.fo.g gVar = this.z;
        if (gVar != null) {
            return gVar.dl();
        }
        return new HashMap();
    }
}
