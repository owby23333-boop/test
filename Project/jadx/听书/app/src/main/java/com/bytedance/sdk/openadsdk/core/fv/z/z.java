package com.bytedance.sdk.openadsdk.core.fv.z;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private Context g;
    private String z;

    public static void z(com.bytedance.sdk.component.z.p pVar, Context context) {
        pVar.z("closeView", (com.bytedance.sdk.component.z.gc<?, ?>) new z("closeView", context));
    }

    public z(String str, Context context) {
        this.z = str;
        this.g = context;
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.z;
        str.hashCode();
        if (str.equals("closeView")) {
            Context context = this.g;
            if (context != null) {
                ((Activity) context).finish();
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        }
        return jSONObject2;
    }
}
