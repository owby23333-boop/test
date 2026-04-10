package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class iq {
    public Map<String, z> z = new HashMap();

    public iq(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sub_convert_link");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    z zVar = new z(jSONObjectOptJSONObject.optJSONObject(next));
                    if (zVar.g()) {
                        this.z.put(next, zVar);
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public void z(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, z> entry : this.z.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().z());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private static iq z(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.zm();
    }

    public static boolean z(na naVar, String str) {
        iq iqVarZ = z(naVar);
        return (iqVarZ == null || !iqVarZ.z.containsKey(str) || TextUtils.isEmpty(dl(naVar, str))) ? false : true;
    }

    public static int g(na naVar, String str) {
        z zVar;
        iq iqVarZ = z(naVar);
        if (iqVarZ == null || (zVar = iqVarZ.z.get(str)) == null) {
            return 0;
        }
        return zVar.z;
    }

    public static String dl(na naVar, String str) {
        z zVar;
        iq iqVarZ = z(naVar);
        return (iqVarZ == null || (zVar = iqVarZ.z.get(str)) == null) ? "" : zVar.g;
    }

    public static String a(na naVar, String str) {
        z zVar;
        iq iqVarZ = z(naVar);
        return (iqVarZ == null || (zVar = iqVarZ.z.get(str)) == null) ? "" : zVar.dl;
    }

    public static String gc(na naVar, String str) {
        z zVar;
        iq iqVarZ = z(naVar);
        return (iqVarZ == null || (zVar = iqVarZ.z.get(str)) == null) ? "" : zVar.f1171a;
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1171a;
        public String dl;
        public String g;
        public int z;

        public z(JSONObject jSONObject) {
            try {
                this.z = jSONObject.optInt("type");
                this.g = jSONObject.optString("url");
                this.dl = jSONObject.optString("pid");
                this.f1171a = jSONObject.optString("ecom_live_params");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }

        public JSONObject z() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.z);
                jSONObject.put("url", this.g);
                jSONObject.put("pid", this.dl);
                jSONObject.put("ecom_live_params", this.f1171a);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean g() {
            return 3 == this.z ? !TextUtils.isEmpty(this.f1171a) : !TextUtils.isEmpty(this.g);
        }
    }
}
