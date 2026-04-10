package com.bytedance.sdk.openadsdk.upie.z;

import android.text.TextUtils;
import com.bytedance.adsdk.g.kb;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static String z(String str, JSONObject jSONObject) {
        com.bytedance.adsdk.g.g.z zVarZ;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (!str.startsWith("${") || !str.endsWith("}") || (zVarZ = com.bytedance.adsdk.g.g.z.z(str.substring(2, str.length() - 1))) == null) {
                    return str;
                }
                Object objZ = zVarZ.z(jSONObject);
                if (objZ instanceof String) {
                    return (String) objZ;
                }
                if (objZ instanceof com.bytedance.adsdk.g.g.z.z) {
                    return String.valueOf(kb.z((com.bytedance.adsdk.g.g.z.z) objZ));
                }
                return String.valueOf(objZ);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return str;
    }
}
