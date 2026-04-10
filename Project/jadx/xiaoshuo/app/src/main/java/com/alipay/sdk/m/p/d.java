package com.alipay.sdk.m.p;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1901a = "RSA";

    /* JADX WARN: Removed duplicated region for block: B:44:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.String r1 = "RSA"
            java.security.PublicKey r6 = b(r1, r6)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String r1 = "RSA/ECB/PKCS1Padding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r2 = 1
            r1.init(r2, r6)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String r6 = "UTF-8"
            byte[] r5 = r5.getBytes(r6)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            int r6 = r1.getBlockSize()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3 = 0
        L21:
            int r4 = r5.length     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            if (r3 >= r4) goto L35
            int r4 = r5.length     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            int r4 = r4 - r3
            if (r4 >= r6) goto L2b
            int r4 = r5.length     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            int r4 = r4 - r3
            goto L2c
        L2b:
            r4 = r6
        L2c:
            byte[] r4 = r1.doFinal(r5, r3, r4)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r2.write(r4)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            int r3 = r3 + r6
            goto L21
        L35:
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r2.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L3d:
            r5 = move-exception
            goto L56
        L3f:
            r5 = move-exception
            goto L45
        L41:
            r5 = move-exception
            goto L55
        L43:
            r5 = move-exception
            r2 = r0
        L45:
            com.alipay.sdk.m.y.g.a(r5)     // Catch: java.lang.Throwable -> L53
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r5 = move-exception
            com.alipay.sdk.m.y.g.a(r5)
        L52:
            return r0
        L53:
            r5 = move-exception
            r0 = r2
        L55:
            r2 = r0
        L56:
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r6 = move-exception
            com.alipay.sdk.m.y.g.a(r6)
        L60:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.p.d.a(java.lang.String, java.lang.String):byte[]");
    }

    public static PublicKey b(String str, String str2) throws Exception {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(a.a(str2)));
    }
}
