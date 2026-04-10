package com.bytedance.sdk.component.adexpress.dynamic.d;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    public String bf;
    public String d;
    public List<e> e;
    public String tg;

    public static class e {
        public JSONObject bf;
        public int e;
    }

    public static tg e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        tg tgVar = new tg();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    e eVar = new e();
                    eVar.e = jSONObjectOptJSONObject.optInt("id");
                    eVar.bf = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(eVar);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        tgVar.e = arrayList;
        tgVar.bf = jSONObject.optString("diff_data");
        tgVar.d = jSONObject.optString("style_diff");
        tgVar.tg = jSONObject.optString("tag_diff");
        return tgVar;
    }
}
