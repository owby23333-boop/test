package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f1060a;
    private com.bytedance.sdk.component.kb.z.z dl;
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z g;
    private String gc;
    private na z;

    public gc(com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar, na naVar, com.bytedance.sdk.component.kb.z.z zVar2, Map<String, Object> map, String str) {
        this.z = naVar;
        this.g = zVar;
        this.dl = zVar2;
        this.f1060a = map;
        this.gc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(final Map<String, Object> map) {
        int iZ = com.bytedance.sdk.openadsdk.core.live.g.z().z(this.z, new com.bytedance.sdk.openadsdk.core.live.z.dl() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.gc.1
            @Override // com.bytedance.sdk.openadsdk.core.live.z.dl
            public void z(int i) {
                if (gc.this.g != null && gc.this.g.z(map)) {
                    return;
                }
                gc.this.dl.g(gc.this.f1060a);
            }
        }, this.gc);
        if (iZ == 1 || iZ == 2) {
            z();
            return true;
        }
        com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar = this.g;
        return zVar != null && zVar.z(map);
    }

    private void z() {
        Map<String, Object> map;
        Map<String, Object> map2 = this.f1060a;
        if (map2 != null) {
            Object obj = map2.get("click_chain");
            Object obj2 = this.f1060a.get("handle_chain_data");
            if (obj == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.g.z.dl)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.g.z.dl dlVar = (com.bytedance.sdk.openadsdk.core.g.z.dl) obj;
            com.bytedance.sdk.openadsdk.core.g.z.dl.z zVar = (com.bytedance.sdk.openadsdk.core.g.z.dl.z) dlVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class);
            if (zVar != null) {
                if (obj2 != null && (obj2 instanceof Map)) {
                    map = (Map) obj2;
                } else {
                    map = new HashMap<>();
                }
                zVar.z(map, dlVar);
            }
        }
    }
}
