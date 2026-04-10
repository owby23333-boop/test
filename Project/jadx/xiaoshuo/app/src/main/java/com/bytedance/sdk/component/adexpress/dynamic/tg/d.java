package com.bytedance.sdk.component.adexpress.dynamic.tg;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.d.tg;
import com.mibi.sdk.component.Constants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public JSONObject e(List<tg.e> list, int i, JSONObject jSONObject) {
        tg.e next;
        JSONObject jSONObject2;
        if (list == null || list.size() <= 0) {
            return null;
        }
        Iterator<tg.e> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && next.e == i) {
                break;
            }
        }
        if (next == null || (jSONObject2 = next.bf) == null) {
            return null;
        }
        return e(jSONObject2, jSONObject);
    }

    private static JSONObject e(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("customComponentDefaultValues");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(Constants.KEY_RECHARGE_VALUES);
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectOptJSONObject.put(next, jSONObjectOptJSONObject2.opt(next));
            }
            Iterator<String> itKeys2 = jSONObject.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                if (!TextUtils.equals(next2, "customComponentDefaultValues")) {
                    if (TextUtils.equals(next2, Constants.KEY_RECHARGE_VALUES)) {
                        jSONObject3.put(next2, jSONObjectOptJSONObject);
                    } else {
                        jSONObject3.put(next2, jSONObject.opt(next2));
                    }
                }
            }
            jSONObject3.put("type", "vessel");
            JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject(Constants.KEY_RECHARGE_VALUES);
            JSONObject jSONObjectOptJSONObject4 = jSONObject3.optJSONObject(Constants.KEY_RECHARGE_VALUES);
            if (jSONObjectOptJSONObject3 != null && jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys3 = jSONObjectOptJSONObject3.keys();
                while (itKeys3.hasNext()) {
                    String next3 = itKeys3.next();
                    if (!"clickArea".equals(next3)) {
                        jSONObjectOptJSONObject4.put(next3, jSONObjectOptJSONObject3.opt(next3));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject3;
    }
}
