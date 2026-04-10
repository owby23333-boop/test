package com.bytedance.sdk.component.adexpress.dynamic.dl;

import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f550a;
    public String dl;
    public String g;
    public List<z> z;

    public static class z {
        public JSONObject g;
        public int z;
    }

    public static a z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    z zVar = new z();
                    zVar.z = jSONObjectOptJSONObject.optInt("id");
                    zVar.g = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(zVar);
                }
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        aVar.z = arrayList;
        aVar.g = jSONObject.optString("diff_data");
        aVar.dl = jSONObject.optString("style_diff");
        aVar.f550a = jSONObject.optString("tag_diff");
        return aVar;
    }
}
