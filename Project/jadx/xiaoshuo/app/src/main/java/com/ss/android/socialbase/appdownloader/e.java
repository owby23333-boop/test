package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    public int bf = -1;
    public String d;
    public String e;
    public String ga;
    public String tg;

    public JSONObject bf() {
        JSONObject jSONObject = new JSONObject();
        e(jSONObject);
        return jSONObject;
    }

    public String e() {
        return bf().toString();
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.e);
            jSONObject.put("error_code", String.valueOf(this.bf));
            jSONObject.put("error_msg", this.d);
            jSONObject.put("real_device_plan", this.tg);
            jSONObject.put("device_plans", this.ga);
        } catch (Throwable unused) {
        }
    }

    public static e e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.ga = jSONObject.optString("device_plans", null);
            eVar.tg = jSONObject.optString("real_device_plan", null);
            eVar.d = jSONObject.optString("error_msg", null);
            eVar.e = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                eVar.bf = -1;
            } else {
                eVar.bf = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return eVar;
    }
}
