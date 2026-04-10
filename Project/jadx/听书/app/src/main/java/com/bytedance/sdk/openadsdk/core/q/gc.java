package com.bytedance.sdk.openadsdk.core.q;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static boolean z(String str, double d) {
        JSONObject jSONObjectTc = zw.g().tc();
        if (jSONObjectTc != null && !TextUtils.isEmpty(str)) {
            try {
                double dOptDouble = jSONObjectTc.optDouble(str, d);
                if (dOptDouble >= 1.0d || dOptDouble < 0.0d || com.bytedance.sdk.openadsdk.core.i.dl.z.contains(str)) {
                    return true;
                }
                return com.bytedance.sdk.openadsdk.core.m.g.z((float) dOptDouble, false);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.dl("sample throwable:" + th.getMessage());
            }
        }
        return true;
    }
}
