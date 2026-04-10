package com.bytedance.sdk.openadsdk.core.fo.z.g;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.kb.g.g
public class ls implements com.bytedance.sdk.component.kb.z.z.dl {

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na dl;

    @com.bytedance.sdk.component.kb.g.z(z = MediationConstant.EXTRA_LOG_EXTRA)
    private String g;

    @com.bytedance.sdk.component.kb.g.z(z = "type")
    private String z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        if (!z()) {
            com.bytedance.sdk.component.utils.wp.a("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            zVar.g(map2);
            return false;
        }
        final JSONObject jSONObjectZ = z(map);
        final int iGz = eo.gz(this.dl);
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.g.ls.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(ls.this.z).gz(ls.this.g).z(iGz).g(jSONObjectZ.toString());
            }
        }, this.z);
        zVar.z(map2);
        return true;
    }

    private JSONObject z(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("type");
            hashSet.add(MediationConstant.EXTRA_LOG_EXTRA);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean z() {
        return (TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.g)) ? false : true;
    }
}
