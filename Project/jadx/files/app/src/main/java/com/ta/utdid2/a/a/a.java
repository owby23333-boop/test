package com.ta.utdid2.a.a;

import com.umeng.analytics.pro.cb;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(String str) {
        byte[] bArrA;
        try {
            bArrA = a(a(), str.getBytes());
        } catch (Exception unused) {
            bArrA = null;
        }
        if (bArrA != null) {
            return a(bArrA);
        }
        return null;
    }

    public static String b(String str) {
        try {
            return new String(b(a(), m174a(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] a() throws Exception {
        return e.a(new byte[]{33, 83, -50, -89, -84, -114, 80, 99, 10, Utf8.REPLACEMENT_BYTE, 22, -65, -11, 30, 101, -118});
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(b()));
        return cipher.doFinal(bArr2);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(b()));
        return cipher.doFinal(bArr2);
    }

    private static byte[] b() {
        try {
            byte[] bArrDecode = b.decode("IUQSvE6r1TfFPdPEjfklLw==".getBytes("UTF-8"), 2);
            if (bArrDecode != null) {
                return e.a(bArrDecode);
            }
        } catch (Exception unused) {
        }
        return new byte[16];
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static byte[] m174a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
        }
        return bArr;
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            a(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & cb.f19604m));
    }
}
