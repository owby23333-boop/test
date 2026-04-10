package com.yuewen;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes17.dex */
public class nd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14816a = 128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14817b = 16;
    public static final int c = 32;
    public static final int d = 160;
    public static final int e = 20;
    public static final int f = 40;
    public static final /* synthetic */ boolean g = false;

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.valueOf(str.substring(i2, i2 + 2), 16).intValue();
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x004e -> B:40:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r3, java.lang.String r4) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r3 = r3.getPath()
            r0.<init>(r3)
            boolean r3 = r0.exists()
            r1 = 0
            if (r3 != 0) goto L15
            return r1
        L15:
            r3 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L41
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L41
            java.lang.String r3 = "md5"
            java.lang.String r3 = e(r2, r3)     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L52
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L52
            if (r0 != 0) goto L37
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L52
            if (r3 == 0) goto L37
            r2.close()     // Catch: java.lang.Exception -> L31
            goto L35
        L31:
            r3 = move-exception
            r3.printStackTrace()
        L35:
            r3 = 1
            return r3
        L37:
            r2.close()     // Catch: java.lang.Exception -> L4d
            goto L51
        L3b:
            r3 = move-exception
            goto L44
        L3d:
            r4 = move-exception
            r2 = r3
            r3 = r4
            goto L53
        L41:
            r4 = move-exception
            r2 = r3
            r3 = r4
        L44:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r2 == 0) goto L51
            r2.close()     // Catch: java.lang.Exception -> L4d
            goto L51
        L4d:
            r3 = move-exception
            r3.printStackTrace()
        L51:
            return r1
        L52:
            r3 = move-exception
        L53:
            if (r2 == 0) goto L5d
            r2.close()     // Catch: java.lang.Exception -> L59
            goto L5d
        L59:
            r4 = move-exception
            r4.printStackTrace()
        L5d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.nd0.c(java.lang.String, java.lang.String):boolean");
    }

    public static String d(File file, String str) {
        FileInputStream fileInputStream;
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
        }
        try {
            String strE = e(fileInputStream, str);
            try {
                fileInputStream.close();
            } catch (Throwable unused2) {
            }
            return strE;
        } catch (Throwable unused3) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Throwable unused4) {
                }
            }
            return "";
        }
    }

    public static String e(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    return a(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String f(String str, String str2) {
        return g(str, "utf-8", str2);
    }

    public static String g(String str, String str2, String str3) {
        try {
            return e(new ByteArrayInputStream(str.getBytes(str2)), str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
