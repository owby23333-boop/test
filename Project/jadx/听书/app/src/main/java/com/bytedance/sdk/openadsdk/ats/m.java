package com.bytedance.sdk.openadsdk.ats;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.q.v;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements gc {
    private Map<String, Object> z;

    @Override // com.bytedance.sdk.openadsdk.ats.gc
    public void z(String str, Throwable th) {
        wp.z("AutoService", "onServiceCreateFailed:".concat(String.valueOf(str)));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, "ser create failed ".concat(String.valueOf(str)));
        } catch (JSONException unused) {
        }
        v.z().z("ats", jSONObject, th);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.gc
    public void z(String str, String str2, String str3, Throwable th) {
        wp.z("AutoService", "onReuseFailed--:" + str + " " + str2 + " " + str3 + ",", th);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str3);
            jSONObject.put("api", str);
            jSONObject.put("impl", str2);
        } catch (JSONException unused) {
        }
        v.z().z("ats", jSONObject, th);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.gc
    public void z(String str, Object obj) {
        wp.z("AutoService", "onServiceReused key:" + str + " ,obj=" + obj);
    }

    @Override // com.bytedance.sdk.openadsdk.ats.gc
    public void g(String str, Object obj) {
        Map<String, Object> map;
        wp.z("AutoService", "onReuseServiceRegister key:" + str + " ,obj=" + obj);
        if (TextUtils.isEmpty(str) || obj == null || (map = this.z) == null) {
            return;
        }
        map.put(str, obj);
    }

    public Map<String, Object> z() {
        return this.z;
    }
}
