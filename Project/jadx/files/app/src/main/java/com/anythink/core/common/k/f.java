package com.anythink.core.common.k;

import com.umeng.analytics.pro.cb;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final String a = "MD5";
    private static char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 240) >>> 4));
                sb.append(Integer.toHexString(b2 & cb.f19604m));
            }
            return sb.toString().toLowerCase(Locale.US);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 240) >>> 4));
                sb.append(Integer.toHexString(b2 & cb.f19604m));
            }
            return sb.toString().toUpperCase(Locale.US);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                sb.append(b[(bArrDigest[i2] & 240) >>> 4]);
                sb.append(b[bArrDigest[i2] & cb.f19604m]);
            }
            return sb.toString().toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(b[(bArr[i2] & 240) >>> 4]);
            sb.append(b[bArr[i2] & cb.f19604m]);
        }
        return sb.toString();
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Integer.toHexString((b2 & 240) >>> 4));
            sb.append(Integer.toHexString(b2 & cb.f19604m));
        }
        return sb.toString().toLowerCase(Locale.US);
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Integer.toHexString((b2 & 240) >>> 4));
            sb.append(Integer.toHexString(b2 & cb.f19604m));
        }
        return sb.toString().toUpperCase(Locale.US);
    }
}
