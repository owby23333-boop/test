package com.bytedance.sdk.openadsdk.core.ugeno.ga;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.e.d.e;
import com.xiaomi.onetrack.b.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class bf extends com.bytedance.sdk.component.adexpress.e.d.e {
    public bf() {
    }

    public static bf bf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bf bfVar = new bf();
        bfVar.e(jSONObject.optString("name"));
        bfVar.bf(jSONObject.optString("version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    e.C0086e c0086e = new e.C0086e();
                    c0086e.e(jSONObjectOptJSONObject.optString("url"));
                    c0086e.bf(jSONObjectOptJSONObject.optString("md5"));
                    c0086e.e(jSONObjectOptJSONObject.optInt(a.d));
                    arrayList.add(c0086e);
                }
            }
        }
        bfVar.e(arrayList);
        if (bfVar.ga()) {
            return bfVar;
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.e.d.e
    public boolean ga() {
        return (TextUtils.isEmpty(bf()) || TextUtils.isEmpty(e())) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.e.d.e
    public String vn() {
        if (!ga()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", e());
            jSONObject.putOpt("version", bf());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (e.C0086e c0086e : getResources()) {
                    if (c0086e != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", c0086e.e());
                        jSONObject2.putOpt("md5", c0086e.bf());
                        jSONObject2.putOpt(a.d, Integer.valueOf(c0086e.d()));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public bf(com.bytedance.sdk.component.adexpress.e.d.e eVar) {
        if (eVar != null) {
            e(eVar.e());
            bf(eVar.bf());
            e(eVar.getResources());
        }
    }

    public static bf ga(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return bf(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
