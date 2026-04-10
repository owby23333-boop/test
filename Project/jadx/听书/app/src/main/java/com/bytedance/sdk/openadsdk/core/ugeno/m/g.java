package com.bytedance.sdk.openadsdk.core.ugeno.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.z.dl.z;
import com.bytedance.sdk.component.utils.wp;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.component.adexpress.z.dl.z {
    public g() {
    }

    public g(com.bytedance.sdk.component.adexpress.z.dl.z zVar) {
        if (zVar != null) {
            z(zVar.g());
            g(zVar.dl());
            z(zVar.getResources());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.z.dl.z
    public boolean m() {
        return (TextUtils.isEmpty(dl()) || TextUtils.isEmpty(g())) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.z.dl.z
    public String gz() {
        if (!m()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", g());
            jSONObject.putOpt("version", dl());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (z.C0124z c0124z : getResources()) {
                    if (c0124z != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", c0124z.z());
                        jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0124z.g());
                        jSONObject2.putOpt("level", Integer.valueOf(c0124z.dl()));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public static g gc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return g(new JSONObject(str));
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public static g g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.z(jSONObject.optString("name"));
        gVar.g(jSONObject.optString("version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    z.C0124z c0124z = new z.C0124z();
                    c0124z.z(jSONObjectOptJSONObject.optString("url"));
                    c0124z.g(jSONObjectOptJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
                    c0124z.z(jSONObjectOptJSONObject.optInt("level"));
                    arrayList.add(c0124z);
                }
            }
        }
        gVar.z(arrayList);
        if (gVar.m()) {
            return gVar;
        }
        return null;
    }
}
