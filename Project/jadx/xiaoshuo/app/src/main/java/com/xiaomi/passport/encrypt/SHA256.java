package com.xiaomi.passport.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes8.dex */
public class SHA256 {
    public static byte[] getAsBytes(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String getAsHexString(String str) {
        return Hex.get(getAsBytes(str));
    }
}
