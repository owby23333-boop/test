package com.yuewen;

import com.duokan.core.diagnostic.LogLevel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t90<T> {
    public abstract T a(JSONObject jSONObject) throws Exception;

    public List<T> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        try {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(a(jSONArray.optJSONObject(i)));
            }
        } catch (Exception e) {
            ia0.w().j(LogLevel.ERROR, "DataParser", "parseList", e);
        }
        return arrayList;
    }
}
