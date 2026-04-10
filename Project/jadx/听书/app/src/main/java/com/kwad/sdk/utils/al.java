package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public final class al {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String md5(String str) {
        return TextUtils.isEmpty(str) ? "" : md5ForByte(str.getBytes());
    }

    public static String md5ForByte(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = bArrDigest.length;
            for (int i = 0; i < length; i++) {
                int i2 = bArrDigest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String sha1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            return toHexString(bArrDigest, 0, bArrDigest.length);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return "";
        }
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        ax.checkNotNull(bArr);
        if (i2 + 0 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + 0] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String toHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static String getFileMD5Digest(File file) throws Throwable {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                bArr = new byte[4096];
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    String hexString = toHexString(messageDigest.digest());
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    return hexString;
                }
                th = th2;
                fileInputStream2 = fileInputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return null;
        }
    }

    public static String getFileMD5Digest(String str) {
        return getFileMD5Digest(new File(str));
    }
}
