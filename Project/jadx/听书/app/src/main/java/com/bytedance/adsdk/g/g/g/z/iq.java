package com.bytedance.adsdk.g.g.g.z;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class iq implements com.bytedance.adsdk.g.g.g.z {
    private final String z;

    public iq(String str) {
        this.z = str;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public Object z(Map<String, JSONObject> map) {
        Object objZ;
        if (map == null || map.size() <= 0 || (objZ = z(this.z, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objZ;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public com.bytedance.adsdk.g.g.a.gc z() {
        return com.bytedance.adsdk.g.g.a.m.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.z + "]";
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public String g() {
        return this.z;
    }

    public Object z(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z(str.split("\\."), 0, jSONObject);
    }

    private Object z(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
                objOpt = jSONObject.opt(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                    return null;
                }
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return z(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException e2) {
                    com.bytedance.sdk.component.utils.wp.z(e2);
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return z(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
