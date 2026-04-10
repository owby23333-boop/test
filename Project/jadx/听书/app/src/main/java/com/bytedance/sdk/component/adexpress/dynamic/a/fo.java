package com.bytedance.sdk.component.adexpress.dynamic.a;

import com.bytedance.sdk.component.utils.wp;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public static void z(String str, JSONObject jSONObject) {
        JSONObject jSONObjectYz = com.bytedance.sdk.component.adexpress.g.yz(str);
        if (jSONObjectYz == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectYz.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        z(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject z(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectYz = com.bytedance.sdk.component.adexpress.g.yz(str);
        if (jSONObjectYz == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return z(jSONObject2, jSONObjectYz.optJSONObject("themeValues"), jSONObject);
    }

    private static void z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        }
    }

    public static JSONObject z(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String z(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectYz = com.bytedance.sdk.component.adexpress.g.yz(str);
        if (jSONObjectYz == null || (jSONObjectOptJSONObject = jSONObjectYz.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String z(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectYz = com.bytedance.sdk.component.adexpress.g.yz(str);
        if (jSONObjectYz == null || (jSONObjectOptJSONObject = jSONObjectYz.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject z(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }

    public static String g(String str, String str2) {
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            if (str.indexOf(46) < 0) {
                str = str + ".png";
            }
            return str2 + "static/images/" + str;
        }
        return z.z(str);
    }
}
