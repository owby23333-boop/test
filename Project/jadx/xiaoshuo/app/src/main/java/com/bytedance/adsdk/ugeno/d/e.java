package com.bytedance.adsdk.ugeno.d;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.m.y.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static String e(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (!str.startsWith("${") || !str.endsWith(l.d)) {
                    return str;
                }
                com.bytedance.adsdk.e.bf.e eVarE = com.bytedance.adsdk.e.bf.e.e(str.substring(2, str.length() - 1));
                Object objE = eVarE.e(jSONObject);
                Log.d("ELParser", "el: " + str + "; result: " + objE);
                return objE instanceof String ? (String) eVarE.e(jSONObject) : String.valueOf(objE);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }
}
