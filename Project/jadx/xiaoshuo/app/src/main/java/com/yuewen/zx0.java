package com.yuewen;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class zx0 extends pr0 {
    public final HashMap<Long, Integer> C;

    public zx0() {
        this.C = new HashMap<>();
    }

    public static zx0 g(String str) {
        try {
            return new zx0(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.yuewen.pr0
    public JSONObject e() {
        JSONObject jSONObjectE = super.e();
        try {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Long, Integer> entry : this.C.entrySet()) {
                jSONArray.put(entry.getKey());
                jSONArray.put(entry.getValue());
            }
            jSONObjectE.put("stuffings_map", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObjectE;
    }

    @Override // com.yuewen.pr0
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        zx0 zx0Var = (zx0) obj;
        if (this.C.size() != zx0Var.C.size()) {
            return false;
        }
        for (Map.Entry<Long, Integer> entry : this.C.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            int iIntValue = entry.getValue().intValue();
            Integer num = zx0Var.C.get(Long.valueOf(jLongValue));
            if (num == null || num.intValue() != iIntValue) {
                return false;
            }
        }
        return true;
    }

    public zx0(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("stuffings_map");
        this.C = new HashMap<>();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i += 2) {
                this.C.put(Long.valueOf(jSONArrayOptJSONArray.getLong(i)), Integer.valueOf(jSONArrayOptJSONArray.getInt(i + 1)));
            }
        }
    }

    public zx0(zx0 zx0Var) {
        super(zx0Var);
        this.C = new HashMap<>(zx0Var.C);
    }
}
