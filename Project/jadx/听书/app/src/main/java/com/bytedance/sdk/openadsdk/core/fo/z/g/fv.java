package com.bytedance.sdk.openadsdk.core.fo.z.g;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class fv implements com.bytedance.sdk.component.kb.z.z.dl {

    @com.bytedance.sdk.component.kb.g.z(z = "reward_dialog_callback")
    private com.bytedance.sdk.openadsdk.core.component.reward.dl.uy z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar = this.z;
        if (uyVar == null) {
            zVar.g(map2);
            return true;
        }
        uyVar.z();
        zVar.z(map2);
        return true;
    }
}
