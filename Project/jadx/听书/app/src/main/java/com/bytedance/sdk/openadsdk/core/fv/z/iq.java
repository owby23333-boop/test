package com.bytedance.sdk.openadsdk.core.fv.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class iq extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private na g;
    private Context z;

    public iq(Context context, na naVar) {
        this.z = context;
        this.g = naVar;
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, Context context, na naVar) {
        pVar.z("openNewCommonWebPage", (com.bytedance.sdk.component.z.gc<?, ?>) new iq(context, naVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        try {
            String strOptString = jSONObject.optString("web_url");
            String strOptString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = "";
            }
            TTDelegateActivity.a(this.z, strOptString, strOptString2);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
