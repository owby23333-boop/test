package com.bytedance.sdk.component.kb.dl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public enum g {
    INSTANCE;

    private Map<String, dl> g = new HashMap();

    g() {
    }

    public dl z(String str) {
        return this.g.get(str);
    }

    public void z(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                dl dlVar = new dl(jSONObject2);
                this.g.put(dlVar.g(), dlVar);
            } catch (JSONException unused) {
            }
        }
    }
}
