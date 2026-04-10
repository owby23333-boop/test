package com.bytedance.sdk.openadsdk.core.gk;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public boolean z = false;
    public boolean g = true;

    public static m z(String str) {
        m mVar = new m();
        if (TextUtils.isEmpty(str)) {
            return mVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            mVar.z = jSONObject.optBoolean("encrypt", false);
            mVar.g = jSONObject.optBoolean("wait_io", true);
        } catch (Throwable unused) {
        }
        return mVar;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("encrypt", this.z);
            jSONObject.put("wait_io", this.g);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
