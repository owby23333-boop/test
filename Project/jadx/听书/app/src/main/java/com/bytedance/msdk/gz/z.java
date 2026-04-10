package com.bytedance.msdk.gz;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static String z(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    public static String z(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(bArr), 0);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    public static String g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(bArrDecode));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    public static String z() {
        String strGc = mc.gc();
        if (strGc == null || strGc.length() != 16) {
            return null;
        }
        return strGc;
    }

    public static String z(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }

    public static String z(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            com.bytedance.msdk.z.gc.dl.dl(th.getMessage());
            return null;
        }
    }
}
