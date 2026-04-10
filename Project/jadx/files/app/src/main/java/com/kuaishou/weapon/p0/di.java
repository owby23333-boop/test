package com.kuaishou.weapon.p0;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class di {
    private static final String a = "bGlidmErKw==";
    private static final String b = "WnBvc2VkQnJpZGdlLmphcg==";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f16706c = "bGlienBvc2VkX2FydC5zbw==";

    public static Integer a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(b.getBytes(), 2));
            byte[] bArrA = c.a(f16706c.getBytes(), 2);
            return (bArrA == null || !a(jSONArray, str, new String(bArrA))) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (((String) jSONArray.get(i2)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String str3 = (String) jSONArray.get(i2);
                    if (str3.contains(str) || str3.contains(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static Integer b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            String str = new String(c.a(a.getBytes(), 2));
            return (str.length() <= 1 || !a(jSONArray, str)) ? null : 1;
        } catch (Exception unused) {
            return null;
        }
    }
}
