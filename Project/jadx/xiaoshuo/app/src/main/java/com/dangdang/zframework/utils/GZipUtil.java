package com.dangdang.zframework.utils;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes10.dex */
public class GZipUtil {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static byte[] compress(byte[] bArr) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr2;
        ?? r0 = 0;
        byte[] byteArray = null;
        gZIPOutputStream = null;
        GZIPOutputStream gZIPOutputStream = null;
        r0 = 0;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(bArr, 0, bArr.length);
                        gZIPOutputStream2.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.flush();
                        gZIPOutputStream2.close();
                        byteArrayOutputStream.close();
                        r0 = byteArray;
                    } catch (Exception e) {
                        e = e;
                        bArr2 = byteArray;
                        gZIPOutputStream = gZIPOutputStream2;
                        e.printStackTrace();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        r0 = bArr2;
                    } catch (Throwable th) {
                        th = th;
                        r0 = gZIPOutputStream2;
                        if (r0 != 0) {
                            r0.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bArr2 = null;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                bArr2 = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            return r0;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006d  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] unCompress(byte[] r7) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r7 == 0) goto L71
            int r1 = r7.length
            if (r1 > 0) goto L8
            goto L71
        L8:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4b
            r1.<init>()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L4b
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L41
            java.util.zip.GZIPInputStream r7 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3b
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3b
            r3 = 2048(0x800, float:2.87E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L60
        L1b:
            int r4 = r7.read(r3)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L60
            if (r4 < 0) goto L26
            r5 = 0
            r1.write(r3, r5, r4)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L60
            goto L1b
        L26:
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L60
            r1.close()
            r7.close()
        L30:
            r2.close()
            goto L5f
        L34:
            r3 = move-exception
            goto L4f
        L36:
            r7 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L61
        L3b:
            r3 = move-exception
            r7 = r0
            goto L4f
        L3e:
            r7 = move-exception
            r2 = r0
            goto L48
        L41:
            r3 = move-exception
            r7 = r0
            r2 = r7
            goto L4f
        L45:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L48:
            r0 = r7
            r7 = r2
            goto L61
        L4b:
            r3 = move-exception
            r7 = r0
            r1 = r7
            r2 = r1
        L4f:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L57
            r1.close()
        L57:
            if (r7 == 0) goto L5c
            r7.close()
        L5c:
            if (r2 == 0) goto L5f
            goto L30
        L5f:
            return r0
        L60:
            r0 = move-exception
        L61:
            if (r1 == 0) goto L66
            r1.close()
        L66:
            if (r7 == 0) goto L6b
            r7.close()
        L6b:
            if (r2 == 0) goto L70
            r2.close()
        L70:
            throw r0
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.zframework.utils.GZipUtil.unCompress(byte[]):byte[]");
    }
}
