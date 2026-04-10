package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.msdk.adapter.util.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a() {
        String strB = m0.b();
        if (strB == null || strB.length() != 16) {
            return null;
        }
        return strB;
    }

    public static String a(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] bArrDecode = Base64.decode(str, 0);
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(2, secretKeySpec);
                return new String(cipher.doFinal(bArrDecode));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String a(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(com.anythink.expressad.foundation.g.a.bN)), 0);
        } catch (Throwable th) {
            Logger.e(th.getMessage());
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(com.anythink.expressad.foundation.g.a.bN)), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
