package com.bytedance.sdk.component.tg;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.utils.wu;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static String e;

    public static String bf(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return new String(cipher.doFinal(bArrDecode));
        } catch (Throwable th) {
            wu.d(th.getMessage());
            return null;
        }
    }

    public static String e(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            wu.d(th.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            if (TextUtils.isEmpty(e)) {
                e = e("AES/CBC/PKCS5Padding");
            }
            Cipher cipher = Cipher.getInstance(e);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(bArrDecode));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String e(String str) {
        int[] iArr = new int[str.length()];
        iArr[4] = 6;
        iArr[5] = 1;
        iArr[6] = 1;
        return new String(e(str.getBytes(), iArr));
    }

    public static byte[] e(byte[] bArr, int[] iArr) {
        if (bArr == null || bArr.length == 0 || iArr == null || iArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ iArr[i % iArr.length]);
        }
        return bArr2;
    }
}
