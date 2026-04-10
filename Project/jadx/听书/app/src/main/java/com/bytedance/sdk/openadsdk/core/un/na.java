package com.bytedance.sdk.openadsdk.core.un;

import android.util.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class na extends com.bytedance.sdk.component.fo.g.gc {
    public na(com.bytedance.sdk.component.g.z.wp wpVar) {
        super(wpVar);
    }

    public void z(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pairZ;
        try {
            pairZ = com.bytedance.sdk.openadsdk.core.dl.m.z().z(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl(th.getMessage());
            pairZ = null;
        }
        if (pairZ != null && pairZ.first != null) {
            if (((Integer) pairZ.first).intValue() == 4) {
                z("application/octet-stream", (byte[]) pairZ.second);
                z(true);
                g("x-pglcypher", String.valueOf(pairZ.first));
                return;
            }
            z((JSONObject) pairZ.second);
            return;
        }
        dl(com.bytedance.sdk.component.utils.z.z(jSONObject).toString());
    }

    public void g(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.zw.g().ly()) {
            z(jSONObject, str);
        } else {
            dl(com.bytedance.sdk.component.utils.z.z(jSONObject).toString());
        }
    }

    public void dl(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.zw.g().yw()) {
            z(jSONObject, str);
        } else {
            dl(com.bytedance.sdk.component.utils.z.z(jSONObject).toString());
        }
    }
}
