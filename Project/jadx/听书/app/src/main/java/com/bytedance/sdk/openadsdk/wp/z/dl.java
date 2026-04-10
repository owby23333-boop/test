package com.bytedance.sdk.openadsdk.wp.z;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.g.z.uy;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.wp.z.z;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    private String gz;

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void g(Context context, String str, com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z(Context context, String str, com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z(String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    protected void z(JSONObject jSONObject, String str, uy uyVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public boolean z(WebView webView) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public boolean z(uy uyVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z() {
        try {
            this.m.putOpt("req_id", this.dl);
            this.m.put(this.gz, new JSONArray());
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public dl(com.bytedance.sdk.openadsdk.wp.z zVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(zVar, str, str2, jSONObject, str3, str4);
        this.gz = "inspect_data";
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void dl() {
        this.z.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.wp.z.dl.1
            @Override // java.lang.Runnable
            public void run() {
                dl.this.a();
            }
        });
    }

    public void a() {
        if (this.m == null) {
            return;
        }
        v.z().dl(this.m.toString(), this.m.optString("req_id"));
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z(String str) {
        int i = this.z.g().get();
        JSONArray jSONArrayOptJSONArray = this.m.optJSONArray(this.gz);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            jSONArrayOptJSONArray.put(jSONObject);
            this.m.put("inspect_data", jSONArrayOptJSONArray);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wp.z.z
    public void z(com.bytedance.sdk.openadsdk.wp.g gVar, WebResourceResponse webResourceResponse, uy uyVar, z.InterfaceC0227z interfaceC0227z) {
        Uri uriZ = gVar.z();
        if (uriZ != null) {
            try {
                String string = uriZ.toString();
                String lowerCase = "unknown";
                if (uyVar != null && uyVar.g() != null) {
                    lowerCase = uyVar.g().trim().toLowerCase();
                }
                JSONObject jSONObjectGc = gc();
                if (jSONObjectGc != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectGc.optJSONArray(lowerCase);
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(string);
                    jSONObjectGc.putOpt(lowerCase, jSONArrayOptJSONArray);
                } else {
                    wp.a("weblp", "error pageCountJson is null");
                }
            } catch (Exception e) {
                wp.z(e);
                wp.dl("weblp", "error", e);
            }
        }
        interfaceC0227z.z(false, null);
    }

    public JSONObject gc() {
        try {
            int i = this.z.g().get();
            JSONArray jSONArrayOptJSONArray = this.m.optJSONArray(this.gz);
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("jump_number", -1);
                if (iOptInt != -1 && iOptInt == i) {
                    return jSONObject;
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return null;
    }
}
