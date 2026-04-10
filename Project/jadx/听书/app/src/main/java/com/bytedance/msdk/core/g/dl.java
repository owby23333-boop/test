package com.bytedance.msdk.core.g;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.g.g().eo()) {
            String strZw = gVar != null ? gVar.zw() : null;
            g gVarWj = com.bytedance.msdk.core.g.g().wj();
            if (gVarWj != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("lt_days", Integer.valueOf(gVarWj.z()));
                    jSONObject.putOpt("rule_id", gVarWj.dl(strZw));
                } catch (Exception e) {
                    com.bytedance.msdk.z.gc.dl.a("AdLoadEventManager", "put 元素 异常：" + e.getMessage());
                }
                try {
                    jSONObject.putOpt("score", Float.valueOf(com.bytedance.msdk.core.z.kb().z(strZw)));
                } catch (Exception e2) {
                    com.bytedance.msdk.z.gc.dl.a("AdLoadEventManager", "put 元素异常：" + e2.getMessage());
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("dis_c", Integer.valueOf(z.g(strZw)));
                    jSONObject2.putOpt("ins_d", Integer.valueOf(z.gc()));
                    jSONObject2.putOpt("act_d", Integer.valueOf(z.g()));
                    jSONObject2.putOpt("act_times", Integer.valueOf(z.a()));
                    jSONObject.putOpt("active_target", jSONObject2);
                } catch (Exception e3) {
                    com.bytedance.msdk.z.gc.dl.a("AdLoadEventManager", "put 元素异常：" + e3.getMessage());
                }
                if (gVar != null && gVar.oq() != null) {
                    Map<String, Object> mapOq = gVar.oq();
                    if (mapOq.containsKey(MediationConstant.KEY_USE_POLICY)) {
                        try {
                            jSONObject.putOpt("user_enter", mapOq.get(MediationConstant.KEY_USE_POLICY));
                        } catch (Exception e4) {
                            com.bytedance.msdk.z.gc.dl.a("AdLoadEventManager", "put 元素异常：" + e4.getMessage());
                        }
                    }
                }
                map.put("dynamic_policy", jSONObject);
            }
        }
    }
}
