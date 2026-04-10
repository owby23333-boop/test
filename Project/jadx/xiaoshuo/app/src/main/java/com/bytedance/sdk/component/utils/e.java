package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.e$e, reason: collision with other inner class name */
    public static class C0105e {
        static final Random e = e.d();
    }

    public static String bf(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strE = e(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strE == null) ? str : com.bytedance.sdk.component.tg.e.bf(str.substring(49), strSubstring, strE);
    }

    public static Random d() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static JSONObject e(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strE = e(jSONObject.toString());
                if (TextUtils.isEmpty(strE)) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                } else {
                    jSONObject2.put("message", strE);
                    jSONObject2.put("cypher", 3);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable th) {
            wu.e(th.getMessage());
        }
        return jSONObject2;
    }

    public static String bf() {
        String strE = e(8);
        if (strE == null || strE.length() != 16) {
            return null;
        }
        return strE;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strE = e();
        String strE2 = e(strE, 32);
        String strBf = bf();
        return 3 + strE + strBf + ((strE2 == null || strBf == null) ? null : com.bytedance.sdk.component.tg.e.e(str, strBf, strE2));
    }

    public static String e() {
        String strE = e(16);
        if (strE == null || strE.length() != 32) {
            return null;
        }
        return strE;
    }

    public static String e(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String e(int i) {
        try {
            byte[] bArr = new byte[i];
            C0105e.e.nextBytes(bArr);
            return ga.e(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
