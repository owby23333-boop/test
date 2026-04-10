package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private na z;

    public static void z(com.bytedance.sdk.component.z.p pVar, na naVar) {
        pVar.z("sendEventCode", (com.bytedance.sdk.component.z.gc<?, ?>) new x(naVar));
    }

    public x(na naVar) {
        this.z = naVar;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.ls.dl.z.g gVar;
        JSONObject jSONObject2 = new JSONObject();
        na naVar = this.z;
        if (naVar != null && (gVar = (com.bytedance.sdk.openadsdk.ls.dl.z.g) com.bytedance.sdk.openadsdk.core.io.z(naVar.dc(), com.bytedance.sdk.openadsdk.ls.dl.z.g.class)) != null) {
            HashMap map = new HashMap();
            int iOptInt = jSONObject.optInt("event_code", -1);
            if (iOptInt >= 200) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("info");
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObjectOptJSONObject.opt(next));
                    }
                }
                gVar.z(iOptInt, map);
            }
        }
        return jSONObject2;
    }
}
