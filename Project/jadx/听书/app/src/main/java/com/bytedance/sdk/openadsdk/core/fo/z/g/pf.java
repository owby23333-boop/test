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
public class pf implements com.bytedance.sdk.component.kb.z.z.dl {

    @com.bytedance.sdk.component.kb.g.z(z = "material_meta")
    private na dl;

    @com.bytedance.sdk.component.kb.g.z(z = MediationConstant.EXTRA_LOG_EXTRA)
    private String g;

    @com.bytedance.sdk.component.kb.g.z(z = "label")
    private String z;

    @Override // com.bytedance.sdk.component.kb.z.z.dl
    public boolean z(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.kb.z.z zVar) {
        if (!z()) {
            com.bytedance.sdk.component.utils.wp.a("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            zVar.g(map2);
            return false;
        }
        JSONObject jSONObjectZ = z(map);
        com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, eo.g(this.dl), this.z, jSONObjectZ);
        zVar.z(map2);
        return true;
    }

    private JSONObject z(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("label");
            hashSet.add(MediationConstant.EXTRA_ADID);
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
        return (TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.g) || this.dl == null) ? false : true;
    }
}
