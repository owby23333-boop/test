package com.amgcyo.cuttadon.app.o;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.jessyan.art.base.QDTCProtect;

/* JADX INFO: compiled from: MkShapeUtils.java */
/* JADX INFO: loaded from: classes.dex */
@QDTCProtect
public final class a {
    private static final byte[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static boolean b = false;

    public static SecretKeySpec a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        return new SecretKeySpec(messageDigest.digest(), "AES");
    }

    public static String b(String str, String str2) throws GeneralSecurityException {
        try {
            return Base64.encodeToString(b(a(str), a, str2.getBytes("UTF-8")), 2);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            throw new GeneralSecurityException(e2);
        }
    }

    public static String a(String str, String str2) throws GeneralSecurityException {
        try {
            return new String(a(a(str), a, Base64.decode(str2, 2)), "UTF-8");
        } catch (Exception e2) {
            throw new GeneralSecurityException(e2);
        }
    }

    public static byte[] b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }

    public static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }
}
