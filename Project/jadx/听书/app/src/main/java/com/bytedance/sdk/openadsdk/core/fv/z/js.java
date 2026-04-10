package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class js extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private final String g;
    private final WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("interactiveStart", (com.bytedance.sdk.component.z.gc<?, ?>) new js(mcVar, "interactiveStart"));
        pVar.z("interactiveFinish", (com.bytedance.sdk.component.z.gc<?, ?>) new js(mcVar, "interactiveFinish"));
        pVar.z("interactiveEnd", (com.bytedance.sdk.component.z.gc<?, ?>) new js(mcVar, "interactiveEnd"));
    }

    public js(com.bytedance.sdk.openadsdk.core.mc mcVar, String str) {
        this.z = new WeakReference<>(mcVar);
        this.g = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.mc mcVar;
        na naVarGz;
        int i;
        boolean z;
        JSONObject jSONObject2 = new JSONObject();
        if (this.z.get() == null) {
            return jSONObject2;
        }
        mcVar = this.z.get();
        naVarGz = mcVar.gz();
        String str = this.g;
        str.hashCode();
        i = 0;
        z = true;
        switch (str) {
            case "interactiveStart":
                mcVar.ls();
                return jSONObject2;
            case "interactiveEnd":
                mcVar.p();
                return jSONObject2;
            case "interactiveFinish":
                try {
                    if (jSONObject.optInt("finish", 1) != 1) {
                        z = false;
                    }
                    int iZ = z(naVarGz, jSONObject.optInt("reduce_duration", -1));
                    if (z) {
                        mcVar.a(iZ);
                    } else {
                        i = -1;
                    }
                    jSONObject2.put("code", i);
                    jSONObject2.put("reduce_duration", iZ);
                    break;
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }

    public static int z(na naVar, int i) {
        int iTd = naVar != null ? naVar.td() : 0;
        if (i >= 0 && iTd >= 0) {
            i = Math.min(i, iTd);
        } else if (i < 0) {
            i = iTd >= 0 ? iTd : 0;
        }
        if (gb.gc(naVar)) {
            return 0;
        }
        return i;
    }
}
