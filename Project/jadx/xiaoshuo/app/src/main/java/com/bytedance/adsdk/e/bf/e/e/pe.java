package com.bytedance.adsdk.e.bf.e.e;

import android.text.TextUtils;
import com.xiaomi.onetrack.util.z;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class pe implements com.bytedance.adsdk.e.bf.e.e {
    private final String e;

    public pe(String str) {
        this.e = str;
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public String bf() {
        return this.e;
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public Object e(Map<String, JSONObject> map) {
        Object objE;
        if (map == null || map.size() <= 0 || (objE = e(this.e, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.e + "]";
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public com.bytedance.adsdk.e.bf.d.tg e() {
        return com.bytedance.adsdk.e.bf.d.ga.VARIABLE;
    }

    public Object e(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return e(str.split(z.f7779a), 0, jSONObject);
    }

    private Object e(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf <= iIndexOf2) {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                objOpt = jSONObject.opt(str);
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return e(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return e(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
