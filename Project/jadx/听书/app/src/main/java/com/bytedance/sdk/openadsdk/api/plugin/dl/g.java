package com.bytedance.sdk.openadsdk.api.plugin.dl;

import android.text.TextUtils;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strZ = z();
        String strZ2 = z(strZ, 32);
        String strG = g();
        String strZ3 = (strZ2 == null || strG == null) ? null : z.z(str, strG, strZ2);
        StringBuilder sb = new StringBuilder("3");
        sb.append(strZ).append(strG).append(strZ3);
        return sb.toString();
    }

    public static JSONObject z(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strZ = z(jSONObject.toString());
                if (!TextUtils.isEmpty(strZ)) {
                    jSONObject2.put("message", strZ);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject2;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strZ = z(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strZ == null) ? str : z.g(str.substring(49), strSubstring, strZ);
    }

    public static String z() {
        String strZ = z(16);
        if (strZ == null || strZ.length() != 32) {
            return null;
        }
        return strZ;
    }

    public static String z(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String g() {
        String strZ = z(8);
        if (strZ == null || strZ.length() != 16) {
            return null;
        }
        return strZ;
    }

    public static String z(int i) {
        try {
            byte[] bArr = new byte[i];
            dl().nextBytes(bArr);
            return a.z(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static SecureRandom dl() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
