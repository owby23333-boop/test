package com.umeng.message.proguard;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AesHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    private static final byte[] a = "uLi4/f4+Pb39.T19".getBytes();
    private static final byte[] b = "nmeug.f9/Om+L823".getBytes();

    public static String a(String str, String str2) throws Exception {
        byte[] bytes = !TextUtils.isEmpty(str2) ? str2.getBytes() : a;
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(bytes, "AES"), new IvParameterSpec(b));
        return i.d(cipher.doFinal(str.getBytes()));
    }

    public static String b(String str, String str2) throws Exception {
        byte[] bytes = !TextUtils.isEmpty(str2) ? str2.getBytes() : a;
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(bytes, "AES"), new IvParameterSpec(b));
        return new String(cipher.doFinal(i.a(str)), "UTF-8");
    }
}
