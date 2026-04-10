package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class ac {
    static final char[] aas = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String W(File file) throws Throwable {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            try {
                bArr = new byte[4096];
            } catch (Throwable th2) {
                th = th2;
            }
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    String strM = m(messageDigest.digest());
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    return strM;
                }
                messageDigest.update(bArr, 0, i2);
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return null;
        }
    }

    @NonNull
    public static String el(String str) {
        return l(str.getBytes());
    }

    public static String em(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            return toHexString(bArrDigest, 0, bArrDigest.length);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return "";
        }
    }

    public static String l(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = bArrDigest.length;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = bArrDigest[i2];
                if (i3 < 0) {
                    i3 += 256;
                }
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String m(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static String toHexString(byte[] bArr, int i2, int i3) {
        an.checkNotNull(bArr);
        if (i3 + 0 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3 * 2;
        char[] cArr = new char[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i6 + 0] & 255;
            int i8 = i5 + 1;
            char[] cArr2 = aas;
            cArr[i5] = cArr2[i7 >> 4];
            i5 = i8 + 1;
            cArr[i8] = cArr2[i7 & 15];
        }
        return new String(cArr, 0, i4);
    }
}
