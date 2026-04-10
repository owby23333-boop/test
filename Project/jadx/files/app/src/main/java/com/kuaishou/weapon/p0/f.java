package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", com.anythink.core.c.e.a, "f"};

    private static String a(byte b) {
        int i2 = b;
        if (b < 0) {
            i2 = b + com.umeng.analytics.pro.cb.a;
        }
        return a[i2 / 16] + a[i2 % 16];
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                    }
                    String strC = c(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    return strC;
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
            }
        }
        return null;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
            } catch (Throwable unused) {
                return str2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(a(b));
        }
        return stringBuffer.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return a(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            int i3 = i2 * 2;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            cArr2[i3 + 1] = cArr[b & com.umeng.analytics.pro.cb.f19604m];
        }
        return new String(cArr2);
    }

    public static byte[] d(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
