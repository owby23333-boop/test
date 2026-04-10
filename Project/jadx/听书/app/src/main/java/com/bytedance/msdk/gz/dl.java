package com.bytedance.msdk.gz;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static Random z = new SecureRandom();

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
        } catch (Throwable th) {
            com.bytedance.msdk.z.gc.dl.z(th.getMessage());
        }
        return jSONObject2;
    }

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
            z.nextBytes(bArr);
            return i.z(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
