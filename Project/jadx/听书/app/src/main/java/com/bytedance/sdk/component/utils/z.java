package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.z$z, reason: collision with other inner class name */
    static class C0141z {
        static final Random z = z.dl();
    }

    public static JSONObject z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return z(jSONObject.toString());
    }

    public static JSONObject z(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strG = g(str);
                if (!TextUtils.isEmpty(strG)) {
                    jSONObject.put("message", strG);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable unused) {
                jSONObject.put("message", str);
                jSONObject.put("cypher", 0);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strZ = z();
        String strZ2 = z(strZ, 32);
        String strG = g();
        String strZ3 = (strZ2 == null || strG == null) ? null : com.bytedance.sdk.component.gc.z.z(str, strG, strZ2);
        StringBuilder sb = new StringBuilder("3");
        sb.append(strZ).append(strG).append(strZ3);
        return sb.toString();
    }

    public static String dl(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strZ = z(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strZ == null) ? str : com.bytedance.sdk.component.gc.z.g(str.substring(49), strSubstring, strZ);
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
            C0141z.z.nextBytes(bArr);
            return gc.z(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random dl() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
