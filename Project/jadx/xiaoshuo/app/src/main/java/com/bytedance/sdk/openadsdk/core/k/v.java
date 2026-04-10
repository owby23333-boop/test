package com.bytedance.sdk.openadsdk.core.k;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
class v implements com.bytedance.sdk.component.p.e.ga.vn {
    com.bytedance.sdk.component.v.bf e;

    public v(com.bytedance.sdk.component.v.bf bfVar) {
        this.e = bfVar;
    }

    @Override // com.bytedance.sdk.component.p.e.ga.vn
    public String bf() {
        com.bytedance.sdk.component.v.bf bfVar = this.e;
        return bfVar != null ? bfVar.tg() : "";
    }

    @Override // com.bytedance.sdk.component.p.e.ga.vn
    public int d() {
        com.bytedance.sdk.component.v.bf bfVar = this.e;
        if (bfVar != null) {
            return bfVar.e();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.component.p.e.ga.vn
    public boolean e() {
        com.bytedance.sdk.component.v.bf bfVar = this.e;
        if (bfVar != null) {
            return bfVar.v();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.p.e.ga.vn
    public Map<String, String> ga() {
        com.bytedance.sdk.component.v.bf bfVar = this.e;
        return bfVar != null ? bfVar.d() : new HashMap();
    }

    @Override // com.bytedance.sdk.component.p.e.ga.vn
    public String tg() {
        com.bytedance.sdk.component.v.bf bfVar = this.e;
        return bfVar != null ? bfVar.bf() : "";
    }
}
