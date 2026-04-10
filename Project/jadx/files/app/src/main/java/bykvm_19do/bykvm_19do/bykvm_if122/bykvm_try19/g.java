package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static JSONObject a() {
        Map<String, ITTAdapterConfiguration> mapE = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        if (mapE == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ITTAdapterConfiguration> entry : mapE.entrySet()) {
            if (entry.getKey() != null) {
                String[] strArrSplit = entry.getKey().split("\\.");
                if (strArrSplit.length >= 5) {
                    try {
                        jSONObject.put(strArrSplit[4] + "Adapter", entry.getValue().getAdapterVersion());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
