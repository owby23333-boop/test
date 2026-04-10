package com.xiaomi.onetrack.d;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import com.yuewen.yg3;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7660a = "DigestUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f7661b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static byte[] b(String str) {
        return a(a(str, "UTF-8"));
    }

    public static String c(String str) {
        return a(b(str), true);
    }

    public static String d(String str) {
        return a(g(str), true);
    }

    public static String e(String str) {
        return a(f(str), true);
    }

    public static byte[] f(String str) {
        return c(a(str, "UTF-8"));
    }

    public static byte[] g(String str) {
        return c().digest(a(str, "UTF-8"));
    }

    public static String h(String str) {
        return TextUtils.isEmpty(str) ? "" : e(str.getBytes());
    }

    public static String b(byte[] bArr) {
        return a(a(bArr), true);
    }

    private static MessageDigest c() {
        return a(yg3.b.f20351b);
    }

    public static String d(byte[] bArr) {
        return a(c(bArr), true);
    }

    public static String e(byte[] bArr) {
        String str;
        if (bArr != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
            } catch (Exception e) {
                p.b(f7660a, "getMD5 exception: " + e);
                str = "";
            }
        } else {
            str = "";
        }
        return str.toLowerCase();
    }

    private static MessageDigest a() {
        return a("MD5");
    }

    private static MessageDigest b() {
        return a("SHA-256");
    }

    public static byte[] c(byte[] bArr) {
        return b().digest(bArr);
    }

    public static byte[] a(byte[] bArr) {
        return a().digest(bArr);
    }

    public static String a(byte[] bArr, boolean z) {
        return new String(a(bArr, z ? f7661b : c));
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & Ascii.SI];
        }
        return cArr2;
    }

    private static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
