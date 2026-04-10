package com.bytedance.sdk.component.adexpress.dynamic.tg;

import com.mibi.sdk.component.Constants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    public static String bf(String str) {
        return e.e(str);
    }

    public static void e(String str, JSONObject jSONObject) {
        JSONObject jSONObjectPl = com.bytedance.sdk.component.adexpress.bf.pl(str);
        if (jSONObjectPl == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectPl.optJSONObject(Constants.KEY_RECHARGE_VALUES);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        e(jSONObjectOptJSONObject, jSONObject);
    }

    public static JSONObject e(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectPl = com.bytedance.sdk.component.adexpress.bf.pl(str);
        if (jSONObjectPl == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return e(jSONObject2, jSONObjectPl.optJSONObject("themeValues"), jSONObject);
    }

    private static void e(JSONObject jSONObject, JSONObject jSONObject2) {
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
                    e.printStackTrace();
                }
            }
        }
    }

    public static JSONObject e(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String e(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectPl = com.bytedance.sdk.component.adexpress.bf.pl(str);
        if (jSONObjectPl == null || (jSONObjectOptJSONObject = jSONObjectPl.optJSONObject(Constants.KEY_RECHARGE_VALUES)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String e(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectPl = com.bytedance.sdk.component.adexpress.bf.pl(str);
        if (jSONObjectPl == null || (jSONObjectOptJSONObject = jSONObjectPl.optJSONObject(Constants.KEY_RECHARGE_VALUES)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject e(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject(Constants.KEY_RECHARGE_VALUES);
    }
}
