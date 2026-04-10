package com.kuaishou.weapon.p0;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final int a = 2048;
    public static final String b = ".gz";

    public static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int i2 = inputStream.read(bArr, 0, 2048);
                    if (i2 == -1) {
                        gZIPOutputStream.flush();
                        gZIPOutputStream.finish();
                        gZIPOutputStream.close();
                        return;
                    }
                    gZIPOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable unused) {
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
            gZIPOutputStream = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(3:29|3|(2:27|4))|(3:25|5|(2:23|6))|31|7|18|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r2) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L26
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L26
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L24
            r2.<init>()     // Catch: java.lang.Throwable -> L24
            a(r1, r2)     // Catch: java.lang.Throwable -> L22
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Throwable -> L22
            r2.flush()     // Catch: java.lang.Throwable -> L22
            r2.close()     // Catch: java.lang.Throwable -> L22
            r1.close()     // Catch: java.lang.Throwable -> L22
            r2.close()     // Catch: java.lang.Exception -> L1e
        L1e:
            r1.close()     // Catch: java.lang.Exception -> L32
            goto L32
        L22:
            goto L28
        L24:
            r2 = r0
            goto L28
        L26:
            r2 = r0
            r1 = r2
        L28:
            if (r2 == 0) goto L2f
            r2.close()     // Catch: java.lang.Exception -> L2e
            goto L2f
        L2e:
        L2f:
            if (r1 == 0) goto L32
            goto L1e
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.d.a(byte[]):byte[]");
    }

    public static void b(InputStream inputStream, OutputStream outputStream) throws Throwable {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int i2 = gZIPInputStream.read(bArr, 0, 2048);
                if (i2 == -1) {
                    gZIPInputStream.close();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
                outputStream.write(bArr, 0, i2);
            }
        } catch (Exception unused3) {
            gZIPInputStream2 = gZIPInputStream;
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (Exception unused4) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(3:29|3|(2:27|4))|(3:23|5|(2:21|6))|31|7|18|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r3) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L26
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L26
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L24
            r2.<init>()     // Catch: java.lang.Throwable -> L24
            b(r1, r2)     // Catch: java.lang.Throwable -> L22
            byte[] r3 = r2.toByteArray()     // Catch: java.lang.Throwable -> L22
            r2.flush()     // Catch: java.lang.Throwable -> L22
            r2.close()     // Catch: java.lang.Throwable -> L22
            r1.close()     // Catch: java.lang.Throwable -> L22
            r2.close()     // Catch: java.lang.Exception -> L1e
        L1e:
            r1.close()     // Catch: java.lang.Exception -> L31
            goto L31
        L22:
            r0 = r2
            goto L27
        L24:
            goto L27
        L26:
            r1 = r0
        L27:
            if (r0 == 0) goto L2e
            r0.close()     // Catch: java.lang.Exception -> L2d
            goto L2e
        L2d:
        L2e:
            if (r1 == 0) goto L31
            goto L1e
        L31:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.d.b(byte[]):byte[]");
    }
}
