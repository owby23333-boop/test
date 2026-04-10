package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.openadsdk.core.dislike.g.z {
    private final na z;

    @Override // com.bytedance.sdk.openadsdk.core.dislike.g.z
    public boolean z(String str, Dialog dialog) {
        return false;
    }

    public z(na naVar) {
        this.z = naVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.g.z
    public boolean z(m mVar, String str, Dialog dialog) {
        if (!"7:1".equals(mVar.z())) {
            return false;
        }
        v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.dislike.z.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                com.bytedance.sdk.openadsdk.core.q.z.g gVarZ = com.bytedance.sdk.openadsdk.core.q.z.g.g().z("stats_feedback_cannot_close");
                if (z.this.z != null) {
                    gVarZ.m(z.this.z.aq()).gz(z.this.z.vk());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("render_control", vm.g(z.this.z));
                    jSONObject.put("ad_info", z.this.z.nv());
                    jSONObject.put("render_sequence", vm.g(z.this.z));
                    gVarZ.g(jSONObject.toString());
                }
                return gVarZ;
            }
        }, "stats_feedback_cannot_close");
        return true;
    }

    public static void z(com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar, na naVar) {
        if (zVar == null || naVar == null) {
            return;
        }
        zVar.z(new z(naVar));
    }
}
