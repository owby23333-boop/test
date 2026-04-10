package com.bytedance.sdk.openadsdk.core.kb.dl.g;

import com.bytedance.sdk.openadsdk.core.iq.na;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f1223a;
    public String dl;
    public String g;
    public na z;

    public static z z() {
        return new z();
    }

    public static z z(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        na naVarZ = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString("tag", null);
            try {
                strOptString2 = jSONObject.optString("label", null);
                try {
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
                    try {
                        naVarZ = com.bytedance.sdk.openadsdk.core.z.z(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    jSONObjectOptJSONObject = null;
                }
            } catch (Exception unused3) {
                strOptString2 = null;
                jSONObjectOptJSONObject = strOptString2;
            }
        } catch (Exception unused4) {
            strOptString = null;
            strOptString2 = null;
        }
        return z().z(strOptString).g(strOptString2).g(jSONObjectOptJSONObject).z(naVarZ);
    }

    public z z(na naVar) {
        this.z = naVar;
        return this;
    }

    public z z(String str) {
        this.g = str;
        return this;
    }

    public z g(String str) {
        this.dl = str;
        return this;
    }

    public z g(JSONObject jSONObject) {
        this.f1223a = jSONObject;
        return this;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.g);
            jSONObject.put("label", this.dl);
            JSONObject jSONObject2 = this.f1223a;
            if (jSONObject2 != null) {
                jSONObject.put("extra", jSONObject2);
            }
            na naVar = this.z;
            if (naVar != null) {
                jSONObject.put("material_meta", naVar.kv());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
