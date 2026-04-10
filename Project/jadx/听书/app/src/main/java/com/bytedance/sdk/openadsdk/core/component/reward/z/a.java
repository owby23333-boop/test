package com.bytedance.sdk.openadsdk.core.component.reward.z;

import com.bytedance.sdk.openadsdk.ls.dl.g.kb;
import com.bytedance.sdk.openadsdk.ls.dl.g.pf;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private com.bytedance.sdk.openadsdk.tb.z.g.z.a g;
    private com.bytedance.sdk.openadsdk.tb.z.g.z.e z;

    public a(com.bytedance.sdk.openadsdk.tb.z.g.z.e eVar) {
        this.z = eVar;
    }

    public a(com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar) {
        this.g = aVar;
    }

    public void z(int i, String str) {
        com.bytedance.sdk.openadsdk.tb.z.g.z.e eVar = this.z;
        if (eVar != null) {
            eVar.z(i, str);
        }
        com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar = this.g;
        if (aVar != null) {
            aVar.z(i, str);
        }
    }

    public void z(Object obj) {
        com.bytedance.sdk.openadsdk.tb.z.g.z.e eVar = this.z;
        if (eVar != null && (obj instanceof pf)) {
            eVar.z((pf) obj);
        }
        com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar = this.g;
        if (aVar == null || !(obj instanceof kb)) {
            return;
        }
        aVar.z((kb) obj);
    }

    public void g(Object obj) {
        com.bytedance.sdk.openadsdk.tb.z.g.z.e eVar = this.z;
        if (eVar != null && (obj instanceof pf)) {
            eVar.z();
            this.z.g((pf) obj);
        }
        com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar = this.g;
        if (aVar == null || !(obj instanceof kb)) {
            return;
        }
        aVar.z();
        this.g.g((kb) obj);
    }

    public long z() {
        Object obj = this.z;
        if (obj != null) {
            return obj instanceof com.bytedance.sdk.openadsdk.core.z.g ? ((com.bytedance.sdk.openadsdk.core.z.g) obj).g() : System.currentTimeMillis();
        }
        Object obj2 = this.g;
        if (obj2 != null) {
            return obj2 instanceof com.bytedance.sdk.openadsdk.core.z.g ? ((com.bytedance.sdk.openadsdk.core.z.g) obj2).g() : System.currentTimeMillis();
        }
        return 0L;
    }
}
