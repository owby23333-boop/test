package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.g> dl = new ArrayList();
    private String g;
    private String z;

    public h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.z = jSONObject.optString("id");
        this.g = jSONObject.optString("url");
        dl();
    }

    public h(String str, JSONArray jSONArray) {
        this.z = str;
        z(jSONArray);
    }

    public String z() {
        return this.z;
    }

    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.g> g() {
        return this.dl;
    }

    private void dl() {
        String strZ = z(this.z);
        if (!TextUtils.isEmpty(strZ)) {
            g(strZ);
            return;
        }
        com.bytedance.sdk.component.fo.g.dl dlVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
        if (dlVarDl == null || TextUtils.isEmpty(this.g)) {
            return;
        }
        dlVarDl.z(this.g);
        dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.h.1
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                if (gVar != null) {
                    try {
                        if (!gVar.gz() || gVar.a() == null) {
                            return;
                        }
                        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
                        String strA = gVar.a();
                        dlVarZ.put(h.this.z, strA);
                        h.this.g(strA);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    private String z(String str) {
        com.bytedance.sdk.component.a.g.dl dlVarZ;
        if (TextUtils.isEmpty(str) || (dlVarZ = com.bytedance.sdk.openadsdk.core.g.z()) == null) {
            return null;
        }
        return dlVarZ.get(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("pattern");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.dl.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.g(jSONArray.getJSONObject(i)));
            }
        } catch (Exception unused) {
        }
    }

    private void z(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.dl.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.g(jSONArray.getJSONObject(i)));
            } catch (Exception unused) {
                return;
            }
        }
    }
}
