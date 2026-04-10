package com.yuewen;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class p70 {

    public interface a {
        void a(String str, boolean z);
    }

    public void a(JSONObject jSONObject, a aVar) throws Exception {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
        if (jSONArrayOptJSONArray == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
            aVar.a(jSONObject2.getString("code"), ((long) jSONObject2.optInt("expire")) >= jCurrentTimeMillis && ((long) jSONObject2.optInt("start")) <= jCurrentTimeMillis && jSONObject2.optInt("status") == 0);
        }
    }
}
