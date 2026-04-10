package com.tencent.smtt.utils;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class LogFileUtils {
    private static OutputStream a;

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] bArrEncryptKey = encryptKey(str, str2);
            String str3 = String.format("%03d", Integer.valueOf(bArrEncryptKey.length));
            byte[] bArr = new byte[bArrEncryptKey.length + 3];
            bArr[0] = (byte) str3.charAt(0);
            bArr[1] = (byte) str3.charAt(1);
            bArr[2] = (byte) str3.charAt(2);
            System.arraycopy(bArrEncryptKey, 0, bArr, 3, bArrEncryptKey.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            String str3 = "encrypt exception:" + th.getMessage();
            return null;
        }
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            String str3 = "encrypt exception:" + th.getMessage();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void writeDataToStorage(java.io.File r6, java.lang.String r7, byte[] r8, java.lang.String r9, boolean r10) {
        /*
            java.lang.Class<com.tencent.smtt.utils.LogFileUtils> r0 = com.tencent.smtt.utils.LogFileUtils.class
            monitor-enter(r0)
            byte[] r7 = encrypt(r7, r9)     // Catch: java.lang.Throwable -> L78
            r1 = 0
            if (r7 == 0) goto Lc
            r9 = r1
            goto Ld
        Lc:
            r7 = r1
        Ld:
            java.io.File r1 = r6.getParentFile()     // Catch: java.lang.Throwable -> L71
            r1.mkdirs()     // Catch: java.lang.Throwable -> L71
            boolean r1 = r6.isFile()     // Catch: java.lang.Throwable -> L71
            if (r1 == 0) goto L31
            boolean r1 = r6.exists()     // Catch: java.lang.Throwable -> L71
            if (r1 == 0) goto L31
            long r1 = r6.length()     // Catch: java.lang.Throwable -> L71
            r3 = 2097152(0x200000, double:1.036131E-317)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L31
            r6.delete()     // Catch: java.lang.Throwable -> L71
            r6.createNewFile()     // Catch: java.lang.Throwable -> L71
        L31:
            java.io.OutputStream r1 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L71
            if (r1 != 0) goto L41
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L71
            r1.<init>(r6, r10)     // Catch: java.lang.Throwable -> L71
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L71
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L71
            com.tencent.smtt.utils.LogFileUtils.a = r6     // Catch: java.lang.Throwable -> L71
        L41:
            if (r9 == 0) goto L4d
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L71
            byte[] r7 = r9.getBytes()     // Catch: java.lang.Throwable -> L71
            r6.write(r7)     // Catch: java.lang.Throwable -> L71
            goto L67
        L4d:
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L71
            r6.write(r8)     // Catch: java.lang.Throwable -> L71
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L71
            r6.write(r7)     // Catch: java.lang.Throwable -> L71
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L71
            r7 = 2
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L71
            r8 = 0
            r9 = 10
            r7[r8] = r9     // Catch: java.lang.Throwable -> L71
            r8 = 1
            r7[r8] = r9     // Catch: java.lang.Throwable -> L71
            r6.write(r7)     // Catch: java.lang.Throwable -> L71
        L67:
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L78
            if (r6 == 0) goto L76
        L6b:
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L76
            r6.flush()     // Catch: java.lang.Throwable -> L76
            goto L76
        L71:
            java.io.OutputStream r6 = com.tencent.smtt.utils.LogFileUtils.a     // Catch: java.lang.Throwable -> L78
            if (r6 == 0) goto L76
            goto L6b
        L76:
            monitor-exit(r0)
            return
        L78:
            r6 = move-exception
            monitor-exit(r0)
            goto L7c
        L7b:
            throw r6
        L7c:
            goto L7b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.LogFileUtils.writeDataToStorage(java.io.File, java.lang.String, byte[], java.lang.String, boolean):void");
    }
}
