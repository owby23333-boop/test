package com.yuewen;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes12.dex */
public class t8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17912a;

    public static byte[] a(byte[] bArr, String str) throws Exception {
        return TextUtils.isEmpty(str) ? new byte[0] : i(str, 2, "AES/ECB/nopadding").doFinal(bArr);
    }

    public static String b(String str) throws Exception {
        return c(str, f17912a);
    }

    public static String c(String str, String str2) throws Exception {
        return new String(a(Base64.decode(str, 2), str2), StandardCharsets.UTF_8);
    }

    public static byte[] d(String str, String str2, String str3) throws Exception {
        byte[] bytes = str2.getBytes();
        int length = 16 - (str.getBytes().length % 16);
        for (int i = 0; i < length; i++) {
            str = str + str3;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/nopadding");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(str.getBytes());
    }

    public static byte[] e(byte[] bArr, String str) throws Exception {
        return TextUtils.isEmpty(str) ? new byte[0] : i(str, 1, "AES/ECB/PKCS5Padding").doFinal(bArr);
    }

    public static String f(String str) throws Exception {
        return h(str, f17912a);
    }

    public static boolean g(File file, File file2, String str) throws Exception {
        if (!file2.exists() || file2.length() <= 0) {
            return false;
        }
        return q41.J(new CipherInputStream(new FileInputStream(file2), i(str, 1, "AES/ECB/PKCS5Padding")), file);
    }

    public static String h(String str, String str2) throws Exception {
        return Base64.encodeToString(d(str, str2, " "), 2);
    }

    public static Cipher i(String str, int i, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(str2);
        cipher.init(i, secretKeySpec);
        return cipher;
    }

    public static void j(String str) {
        f17912a = str;
    }
}
