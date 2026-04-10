package com.bytedance.sdk.openadsdk.core.pf;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean z(String str) {
        int iBw;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = x.z("fsswiper_freq").get(str, "");
            if (TextUtils.isEmpty(str2) || (iBw = zw.g().bw()) <= 0) {
                return false;
            }
            if (new JSONObject(str2).optInt(z(), 0) >= iBw) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void g(String str) {
        dl(str);
    }

    private static void dl(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.a.g.dl dlVarZ = x.z("fsswiper_freq");
        try {
            String str2 = dlVarZ.get(str, "");
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str2);
            }
            String strZ = z();
            int iOptInt = jSONObject.optInt(strZ, 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(strZ, iOptInt + 1);
            dlVarZ.put(str, jSONObject2.toString());
        } catch (Exception unused) {
        }
    }

    private static String z() {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}
