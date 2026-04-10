package com.bytedance.sdk.openadsdk.core.fo.z.z.g;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z g;
    private com.bytedance.sdk.openadsdk.core.video.g.g z;

    public g(com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar, com.bytedance.sdk.openadsdk.core.video.g.g gVar) {
        this.g = zVar;
        this.z = gVar;
    }

    public g(com.bytedance.sdk.openadsdk.core.video.g.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.g.g gVar = this.z;
        if (gVar == null) {
            return this.g.z(map);
        }
        if (gVar.z()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar = this.g;
        if (zVar == null) {
            return false;
        }
        return zVar.z(map);
    }
}
