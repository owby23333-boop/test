package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import com.bytedance.msdk.gz.q;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private int z;
    private final Map<String, Float> g = new ConcurrentHashMap();
    private final Map<String, a> dl = new ConcurrentHashMap();

    public g(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null) {
            this.z = jSONObject.optInt("lt_days");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("estimate");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.g.put(next, Float.valueOf((float) jSONObjectOptJSONObject.optDouble(next)));
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("rule_excs");
            if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() == 0) {
                return;
            }
            Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next2);
                if (jSONObjectOptJSONObject3 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("prime_rits")) != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        this.dl.put(strOptString, new a(next2, strOptString, jSONObjectOptJSONObject3));
                    }
                }
            }
        }
    }

    public JSONObject z(String str, q qVar) {
        gc gcVar;
        if (!com.bytedance.msdk.core.g.g().eo() || str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        float fZ = z(str);
        a aVar = this.dl.get(str);
        if (aVar != null) {
            Map<String, gc> mapGc = aVar.gc();
            String[] strArrDl = aVar.dl();
            if (mapGc != null && !mapGc.isEmpty() && strArrDl != null && strArrDl.length > 0) {
                for (String str2 : strArrDl) {
                    if (!TextUtils.isEmpty(str2) && (gcVar = mapGc.get(str2)) != null) {
                        try {
                            jSONObject.putOpt(str2, Integer.valueOf(gcVar.z(fZ)));
                        } catch (Exception e) {
                            com.bytedance.msdk.z.gc.dl.a("", "calculateRangeByScore计算异常：(tableName：" + str2 + ",primeRit:" + str + "），" + e.getMessage());
                        }
                    }
                }
            }
        }
        qVar.put(MediationConstant.KEY_GM_POLICY, jSONObject);
        qVar.put("adl_scr", Float.valueOf(fZ));
        com.bytedance.msdk.core.z.kb().z(str, fZ);
        return jSONObject;
    }

    public float z(String str) {
        a aVar = this.dl.get(str);
        float fZ = -1.0f;
        if (aVar != null) {
            Map<String, Float> mapG = aVar.g();
            String strA = aVar.a();
            if (mapG != null) {
                if (mapG.containsKey("lt_x_times")) {
                    Float f = mapG.get("lt_x_times");
                    int iG = z.g();
                    if (f != null) {
                        fZ = z(strA, f.floatValue() * iG, -1.0f);
                    }
                }
                if (mapG.containsKey("active_duration")) {
                    Float f2 = mapG.get("active_duration");
                    long jM = z.m();
                    if (f2 != null) {
                        fZ = z(strA, f2.floatValue() * jM, fZ);
                    }
                }
                if (mapG.containsKey("active_count")) {
                    Float f3 = mapG.get("active_count");
                    int iA = z.a();
                    if (f3 != null) {
                        fZ = z(strA, f3.floatValue() * iA, fZ);
                    }
                }
                if (mapG.containsKey("show_period")) {
                    Float f4 = mapG.get("show_period");
                    long jGz = z.gz(str);
                    if (f4 != null) {
                        fZ = z(strA, f4.floatValue() * jGz, fZ);
                    }
                }
                if (mapG.containsKey("show_count")) {
                    Float f5 = mapG.get("show_count");
                    int iA2 = z.a(str);
                    if (f5 != null) {
                        fZ = z(strA, f5.floatValue() * iA2, fZ);
                    }
                }
                if (mapG.containsKey("dislike_count")) {
                    Float f6 = mapG.get("dislike_count");
                    int iG2 = z.g(str);
                    if (f6 != null) {
                        fZ = z(strA, f6.floatValue() * iG2, fZ);
                    }
                }
                if (mapG.containsKey("click_count")) {
                    Float f7 = mapG.get("click_count");
                    int iM = z.m(str);
                    if (f7 != null) {
                        fZ = z(strA, f7.floatValue() * iM, fZ);
                    }
                }
                if (mapG.containsKey("install_days")) {
                    Float f8 = mapG.get("install_days");
                    int iGc = z.gc();
                    if (f8 != null) {
                        fZ = z(strA, f8.floatValue() * iGc, fZ);
                    }
                }
                if (!this.g.isEmpty()) {
                    for (Map.Entry<String, Float> entry : this.g.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            float fFloatValue = entry.getValue().floatValue();
                            Float f9 = mapG.get(key);
                            if (f9 != null) {
                                fZ = z(strA, f9.floatValue() * fFloatValue, fZ);
                            }
                        }
                    }
                }
            }
        }
        return fZ;
    }

    private float z(String str, float f, float f2) {
        if (f2 == -1.0f) {
            return f;
        }
        str.hashCode();
        switch (str) {
            case "*":
                return f2 * f;
            case "+":
                return f2 + f;
            case "max":
                return Math.max(f, f2);
            case "min":
                return Math.min(f, f2);
            default:
                return f2;
        }
    }

    public int z() {
        return this.z;
    }

    public a g(String str) {
        return this.dl.get(str);
    }

    public String dl(String str) {
        a aVarG;
        if (str == null || (aVarG = g(str)) == null) {
            return null;
        }
        return aVarG.z();
    }
}
