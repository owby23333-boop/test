package com.bytedance.sdk.openadsdk.core.fv.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fv extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private na f1065a;
    private Context dl;
    private com.bytedance.sdk.openadsdk.core.mc g;
    private String z;

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar, Context context, na naVar) {
        pVar.z("supportHaptic", (com.bytedance.sdk.component.z.gc<?, ?>) new fv("supportHaptic", mcVar, context, naVar));
        pVar.z("playHaptic", (com.bytedance.sdk.component.z.gc<?, ?>) new fv("playHaptic", mcVar, context, naVar));
        pVar.z("stopHaptic", (com.bytedance.sdk.component.z.gc<?, ?>) new fv("stopHaptic", mcVar, context, naVar));
    }

    public fv(String str, com.bytedance.sdk.openadsdk.core.mc mcVar, Context context, na naVar) {
        this.z = str;
        this.g = mcVar;
        this.dl = context;
        this.f1065a = naVar;
    }

    private void z(Context context, com.bytedance.sdk.openadsdk.core.iq.h hVar) {
        new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.z(context, hVar).g();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2;
        na naVar;
        com.bytedance.sdk.openadsdk.core.iq.h hVarZ;
        jSONObject2 = new JSONObject();
        String str = this.z;
        str.hashCode();
        switch (str) {
            case "stopHaptic":
                Context context = this.dl;
                if (context != null) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.dl.g(context);
                }
                return jSONObject2;
            case "supportHaptic":
                jSONObject2.put("supportHaptic", this.dl != null ? com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.dl.z(mVar.getContext()) : false);
                return jSONObject2;
            case "playHaptic":
                String strOptString = jSONObject.optString("id");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pattern");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    z(this.dl, new com.bytedance.sdk.openadsdk.core.iq.h(strOptString, jSONArrayOptJSONArray));
                } else if (!TextUtils.isEmpty(strOptString) && (naVar = this.f1065a) != null && (hVarZ = naVar.z(strOptString)) != null) {
                    z(this.dl, hVarZ);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
