package com.anythink.expressad.foundation.h;

import android.text.TextUtils;
import com.umeng.analytics.pro.cb;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements com.anythink.expressad.e.b {
    public static final String a = "MD5";

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            o.a("MD5", str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 240) >>> 4));
                sb.append(Integer.toHexString(b & cb.f19604m));
            }
            return sb.toString().toLowerCase(Locale.US);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String b(String str) {
        try {
            o.a("MD5", str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 240) >>> 4));
                sb.append(Integer.toHexString(b & cb.f19604m));
            }
            return sb.toString().toUpperCase(Locale.US);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b & 240) >>> 4));
            sb.append(Integer.toHexString(b & cb.f19604m));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    private static byte[] d(String str) throws UnsupportedEncodingException {
        int length = str.length();
        byte[] bytes = str.getBytes(com.umeng.message.proguard.k.f20482e);
        o.b(com.anythink.expressad.exoplayer.g.b.i.a, "b = " + a(bytes));
        byte[] bArr = new byte[length];
        int i2 = 0;
        for (int i3 = 0; i3 < bytes.length; i3 += 2) {
            if (bytes[i3] != -1 && bytes[i3] != -2) {
                bArr[i2] = bytes[i3];
                i2++;
                if (i2 == length) {
                    break;
                }
            }
        }
        o.b(com.anythink.expressad.exoplayer.g.b.i.a, "source = " + a(bArr));
        return bArr;
    }

    private static String c(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes(com.umeng.message.proguard.k.f20482e);
            o.b(com.anythink.expressad.exoplayer.g.b.i.a, "b = " + a(bytes));
            byte[] bArr = new byte[length];
            int i2 = 0;
            for (int i3 = 0; i3 < bytes.length; i3 += 2) {
                if (bytes[i3] != -1 && bytes[i3] != -2) {
                    bArr[i2] = bytes[i3];
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                }
            }
            o.b(com.anythink.expressad.exoplayer.g.b.i.a, "source = " + a(bArr));
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i4 = 0;
            for (byte b : bArrDigest) {
                int i5 = i4 + 1;
                cArr2[i4] = cArr[(b >>> 4) & 15];
                i4 = i5 + 1;
                cArr2[i5] = cArr[b & cb.f19604m];
            }
            return new String(cArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(Integer.toHexString((b & 240) >>> 4));
            sb.append(Integer.toHexString(b & cb.f19604m));
        }
        return sb.toString().toLowerCase(Locale.US);
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int length = bArr.length * 2;
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = 48;
        }
        byte[] bArr3 = new byte[bArr.length + 1];
        bArr3[0] = 0;
        System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        byte[] bytes = new BigInteger(bArr3).toString(16).getBytes();
        System.arraycopy(bytes, 0, bArr2, length - bytes.length, bytes.length);
        return new String(bArr2);
    }
}
