package com.bytedance.adsdk.ugeno.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                wp.z(e);
            }
        }
    }

    public static JSONObject z(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            wp.z(e);
            return jSONObject;
        }
    }

    public static JSONArray z(String str, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str)) {
            return jSONArray;
        }
        try {
            return new JSONArray(str);
        } catch (JSONException unused) {
            return jSONArray;
        }
    }

    public static void z(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return;
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArray2.length(); i++) {
            Object objOpt = jSONArray2.opt(i);
            if (objOpt != null) {
                jSONArray.put(objOpt);
            }
        }
    }
}
