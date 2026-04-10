package com.scottyab.aescrypt;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class AESCrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f7218a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7219b = false;

    private AESCrypt() {
    }

    public static String a(final String password, String base64EncodedCipherText) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpecA = a(password);
            c("base64EncodedCipherText", base64EncodedCipherText);
            byte[] bArrDecode = Base64.decode(base64EncodedCipherText, 2);
            a("decodedCipherText", bArrDecode);
            byte[] bArrA = a(secretKeySpecA, f7218a, bArrDecode);
            a("decryptedBytes", bArrA);
            String str = new String(bArrA, "UTF-8");
            c("message", str);
            return str;
        } catch (UnsupportedEncodingException e) {
            if (f7219b) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    public static String b(final String password, String message) throws GeneralSecurityException {
        try {
            SecretKeySpec secretKeySpecA = a(password);
            c("message", message);
            String strEncodeToString = Base64.encodeToString(b(secretKeySpecA, f7218a, message.getBytes("UTF-8")), 2);
            c("Base64.NO_WRAP", strEncodeToString);
            return strEncodeToString;
        } catch (UnsupportedEncodingException e) {
            if (f7219b) {
                Log.e("AESCrypt", "UnsupportedEncodingException ", e);
            }
            throw new GeneralSecurityException(e);
        }
    }

    private static void c(String what, String value) {
        if (f7219b) {
            Log.d("AESCrypt", what + "[" + value.length() + "] [" + value + "]");
        }
    }

    private static String a(byte[] bytes) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int i2 = bytes[i] & 255;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] b(final SecretKeySpec key, final byte[] iv, final byte[] message) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, key, new IvParameterSpec(iv));
        byte[] bArrDoFinal = cipher.doFinal(message);
        a("cipherText", bArrDoFinal);
        return bArrDoFinal;
    }

    private static SecretKeySpec a(final String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = password.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] bArrDigest = messageDigest.digest();
        a("SHA-256 key ", bArrDigest);
        return new SecretKeySpec(bArrDigest, "AES");
    }

    private static void a(String what, byte[] bytes) {
        if (f7219b) {
            Log.d("AESCrypt", what + "[" + bytes.length + "] [" + a(bytes) + "]");
        }
    }

    public static byte[] a(final SecretKeySpec key, final byte[] iv, final byte[] decodedCipherText) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, key, new IvParameterSpec(iv));
        byte[] bArrDoFinal = cipher.doFinal(decodedCipherText);
        a("decryptedBytes", bArrDoFinal);
        return bArrDoFinal;
    }
}
