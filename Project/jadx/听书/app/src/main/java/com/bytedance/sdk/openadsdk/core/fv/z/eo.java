package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class eo extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.mc dl;
    private String g;
    private SSWebView z;

    public static void z(com.bytedance.sdk.component.z.p pVar, SSWebView sSWebView, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("closeWebview", (com.bytedance.sdk.component.z.gc<?, ?>) new eo(sSWebView, "closeWebview", mcVar));
        pVar.z("makeVisible", (com.bytedance.sdk.component.z.gc<?, ?>) new eo(sSWebView, "makeVisible", mcVar));
        pVar.z("getCurrentVisibleState", (com.bytedance.sdk.component.z.gc<?, ?>) new eo(sSWebView, "getCurrentVisibleState", mcVar));
        pVar.z("changeSize", (com.bytedance.sdk.component.z.gc<?, ?>) new eo(sSWebView, "changeSize", mcVar));
        pVar.z("changeFrame", (com.bytedance.sdk.component.z.gc<?, ?>) new eo(sSWebView, "changeFrame", mcVar));
    }

    public eo(SSWebView sSWebView, String str, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = sSWebView;
        this.g = str;
        this.dl = mcVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2;
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        jSONObject2 = new JSONObject();
        String str = this.g;
        str.hashCode();
        switch (str) {
            case "changeSize":
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("size");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    int iOptInt4 = jSONArrayOptJSONArray.optInt(0);
                    int iOptInt5 = jSONArrayOptJSONArray.optInt(1);
                    com.bytedance.sdk.openadsdk.core.mc mcVar = this.dl;
                    if (mcVar != null) {
                        mcVar.z(iOptInt4, iOptInt5);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("point");
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("size");
                int iOptInt6 = Integer.MAX_VALUE;
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
                    iOptInt = Integer.MAX_VALUE;
                    iOptInt2 = Integer.MAX_VALUE;
                } else {
                    iOptInt2 = jSONArrayOptJSONArray2.optInt(0);
                    iOptInt = jSONArrayOptJSONArray2.optInt(1);
                }
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() != 2) {
                    iOptInt3 = Integer.MAX_VALUE;
                } else {
                    iOptInt6 = jSONArrayOptJSONArray3.optInt(0);
                    iOptInt3 = jSONArrayOptJSONArray3.optInt(1);
                }
                com.bytedance.sdk.openadsdk.core.mc mcVar2 = this.dl;
                if (mcVar2 != null) {
                    mcVar2.z(iOptInt2, iOptInt, iOptInt6, iOptInt3);
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.bytedance.sdk.openadsdk.core.ti.g(this.z, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "closeWebview":
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.eo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        eo.this.z.setVisibility(8);
                    }
                });
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo foVarDl = this.dl.dl();
                if (foVarDl != null) {
                    foVarDl.g();
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            case "makeVisible":
                if (this.z != null) {
                    jSONObject2.put("success", true);
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.eo.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (eo.this.z != null) {
                                eo.this.z.setVisibility(0);
                            }
                            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fo foVarDl2 = eo.this.dl.dl();
                            if (foVarDl2 != null) {
                                foVarDl2.F_();
                            }
                        }
                    });
                } else {
                    jSONObject2.put("success", false);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
