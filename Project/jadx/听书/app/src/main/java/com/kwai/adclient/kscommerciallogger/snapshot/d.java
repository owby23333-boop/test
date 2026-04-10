package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private final String bfi;
    private final LinkedHashMap<String, String> bfj = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    d(String str) {
        this.bfi = str;
    }

    synchronized JSONObject Tq() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.bfj.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("time", this.time);
            jSONObject.put("span_name", this.bfi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
