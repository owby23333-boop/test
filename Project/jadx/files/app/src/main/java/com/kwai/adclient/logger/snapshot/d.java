package com.kwai.adclient.logger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private final String aDq;
    private final LinkedHashMap<String, String> aDr = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    d(String str) {
        this.aDq = str;
    }

    synchronized JSONObject FT() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.aDr.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("time", this.time);
            jSONObject.put("span_name", this.aDq);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
