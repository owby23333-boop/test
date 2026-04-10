package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static Random a = new SecureRandom();

    public static String a() {
        String strA = a(8);
        if (strA == null || strA.length() != 16) {
            return null;
        }
        return strA;
    }

    public static String a(int i2) {
        try {
            byte[] bArr = new byte[i2];
            a.nextBytes(bArr);
            return o.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strB = b();
        String strA = a(strB, 32);
        String strA2 = a();
        String strA3 = null;
        if (strA != null && strA2 != null) {
            strA3 = a.a(str, strA2, strA);
        }
        return 3 + strB + strA2 + strA3;
    }

    public static String a(String str, int i2) {
        if (str == null || str.length() != i2) {
            return null;
        }
        int i3 = i2 / 2;
        return str.substring(i3, i2) + str.substring(0, i3);
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String strA = a(jSONObject.toString());
                    if (TextUtils.isEmpty(strA)) {
                        jSONObject2.put("message", jSONObject.toString());
                        jSONObject2.put("cypher", 0);
                    } else {
                        jSONObject2.put("message", strA);
                        jSONObject2.put("cypher", 3);
                    }
                } catch (Throwable unused) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable th) {
                Logger.d(th.getMessage());
            }
        }
        return jSONObject2;
    }

    public static String b() {
        String strA = a(16);
        if (strA == null || strA.length() != 32) {
            return null;
        }
        return strA;
    }
}
