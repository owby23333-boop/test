package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.z.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class tb extends com.bytedance.sdk.component.z.a<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.mc> z;

    public tb(com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.z = new WeakReference<>(mcVar);
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, final com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("mallTopbarClick", new a.g() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.tb.1
            @Override // com.bytedance.sdk.component.z.a.g
            public com.bytedance.sdk.component.z.a z() {
                return new tb(mcVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.z.a
    public void z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.uy.ls().t();
        WeakReference<com.bytedance.sdk.openadsdk.core.mc> weakReference = this.z;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() == null || jSONObject == null) {
            dl();
            return;
        }
        String strOptString = jSONObject.optString("schema");
        if (strOptString.isEmpty()) {
            dl();
        } else {
            z(strOptString, jSONObject.optBoolean("sync_auth", false));
        }
    }

    private void z(final String str, boolean z) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        if (2 == com.bytedance.sdk.openadsdk.core.live.g.z().gc()) {
            z(str, jSONObject);
            return;
        }
        int iZ = com.bytedance.sdk.openadsdk.core.live.g.z().z(new com.bytedance.sdk.openadsdk.core.live.g.g() { // from class: com.bytedance.sdk.openadsdk.core.fv.z.tb.2
            @Override // com.bytedance.sdk.openadsdk.core.live.g.g
            protected void z(Object obj) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("code")) {
                        Object obj2 = map.get("code");
                        if (obj2 instanceof String) {
                            try {
                                int i = Integer.parseInt((String) obj2);
                                if (i == 1) {
                                    tb.this.z(str, jSONObject);
                                    return;
                                }
                                try {
                                    jSONObject.putOpt("code", Integer.valueOf(i));
                                } catch (JSONException unused) {
                                }
                                tb.this.z(i, "授权失败");
                                tb.this.z(jSONObject);
                                return;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                    }
                }
                try {
                    jSONObject.putOpt("code", -1);
                } catch (JSONException unused3) {
                }
                tb.this.z(-1, "授权失败");
                tb.this.z(jSONObject);
            }
        }, z);
        jSONObject.putOpt("code", Integer.valueOf(iZ));
        if (iZ != 1) {
            z(iZ, "执行授权失败");
            z(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, JSONObject jSONObject) {
        int iZ = com.bytedance.sdk.openadsdk.core.live.g.z().z(str);
        try {
            jSONObject.putOpt("code", Integer.valueOf(iZ));
        } catch (JSONException unused) {
        }
        if (iZ != 1) {
            z(iZ, "schema 解析失败");
        }
        z(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        com.bytedance.sdk.component.utils.wp.g("MallTopBarClickMethod", "code = " + i + ", msg = " + str);
        com.bytedance.sdk.component.utils.hh.z(com.bytedance.sdk.openadsdk.core.zw.getContext(), "努力加载中，请稍后再试", 1);
    }

    @Override // com.bytedance.sdk.component.z.a
    protected void a() {
        this.z = null;
    }
}
