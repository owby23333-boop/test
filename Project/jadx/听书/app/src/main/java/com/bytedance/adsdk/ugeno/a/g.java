package com.bytedance.adsdk.ugeno.a;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.a;
import com.bytedance.adsdk.ugeno.a.z;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static String z(String str, JSONObject jSONObject) {
        z zVarDl;
        z.InterfaceC0043z interfaceC0043zZ;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (zVarDl = a.z().dl()) == null || (interfaceC0043zZ = zVarDl.z(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0043zZ.z(jSONObject);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return str;
    }
}
