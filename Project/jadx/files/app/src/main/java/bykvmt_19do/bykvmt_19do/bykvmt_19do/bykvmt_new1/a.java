package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: TTAES.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(bArrDecode));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
