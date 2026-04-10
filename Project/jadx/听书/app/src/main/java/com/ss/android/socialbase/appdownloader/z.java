package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2046a;
    public String dl;
    public int g = -1;
    public String gc;
    public String z;

    public String z() {
        return g().toString();
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        z(jSONObject);
        return jSONObject;
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.z);
            jSONObject.put("error_code", String.valueOf(this.g));
            jSONObject.put("error_msg", this.dl);
            jSONObject.put("real_device_plan", this.f2046a);
            jSONObject.put("device_plans", this.gc);
        } catch (Throwable unused) {
        }
    }

    public static z z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        z zVar = new z();
        try {
            JSONObject jSONObject = new JSONObject(str);
            zVar.gc = jSONObject.optString("device_plans", null);
            zVar.f2046a = jSONObject.optString("real_device_plan", null);
            zVar.dl = jSONObject.optString("error_msg", null);
            zVar.z = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                zVar.g = -1;
            } else {
                zVar.g = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return zVar;
    }
}
