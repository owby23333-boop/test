package com.kuaishou.weapon.p0;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1781a = "AES/CBC/NoPadding";
    public static final int b = 16;
    public static final String c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    private static final String d = "AES/CBC/PKCS5Padding";
    private static final String e = "AES";
    private static final String f = "AES/CBC/PKCS7Padding";

    public static byte[] a(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), e);
        Cipher cipher = Cipher.getInstance(d);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), e);
        Cipher cipher = Cipher.getInstance(d);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, e);
            Cipher cipher = Cipher.getInstance(d);
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z) {
                byte[] bArr4 = new byte[bArr2.length - 16];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            System.out.println(th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:60|3|(4:5|(2:8|6)|67|9)(2:10|(1:12))|13|(3:58|14|(3:54|15|(8:50|16|(1:18)|68|19|20|52|21)))|(5:22|(1:24)(1:69)|48|28|40)|25|65|26|63|27|48|28|40) */
    /* JADX WARN: Can't wrap try/catch for region: R(28:0|2|60|3|(4:5|(2:8|6)|67|9)(2:10|(1:12))|13|58|14|54|15|50|16|(1:18)|68|19|20|52|21|(5:22|(1:24)(1:69)|48|28|40)|25|65|26|63|27|48|28|40|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = -1
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L98
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L98
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L98
            r2 = 0
            r3 = 16
            if (r9 >= r3) goto L2a
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L98
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L98
            r1 = r2
        L19:
            int r5 = 16 - r9
            if (r1 >= r5) goto L25
            java.lang.String r5 = "0"
            r4.append(r5)     // Catch: java.lang.Throwable -> L98
            int r1 = r1 + 1
            goto L19
        L25:
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L98
            goto L34
        L2a:
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L98
            if (r9 <= r3) goto L34
            java.lang.String r1 = r1.substring(r2, r3)     // Catch: java.lang.Throwable -> L98
        L34:
            r9 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L88
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L88
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L86
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L86
            javax.crypto.spec.SecretKeySpec r8 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L83
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = "AES"
            r8.<init>(r1, r5)     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Throwable -> L83
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L83
            r6 = r2
        L53:
            if (r6 >= r3) goto L5a
            r5[r6] = r2     // Catch: java.lang.Throwable -> L83
            int r6 = r6 + 1
            goto L53
        L5a:
            javax.crypto.spec.IvParameterSpec r3 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L83
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L83
            r5 = 2
            r1.init(r5, r8, r3)     // Catch: java.lang.Throwable -> L83
            javax.crypto.CipherInputStream r8 = new javax.crypto.CipherInputStream     // Catch: java.lang.Throwable -> L83
            r8.<init>(r4, r1)     // Catch: java.lang.Throwable -> L83
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch: java.lang.Throwable -> L84
        L6c:
            int r1 = r8.read(r9)     // Catch: java.lang.Throwable -> L84
            if (r1 == r0) goto L76
            r7.write(r9, r2, r1)     // Catch: java.lang.Throwable -> L84
            goto L6c
        L76:
            r8.close()     // Catch: java.lang.Throwable -> L84
            r7.close()     // Catch: java.io.IOException -> L7c java.lang.Throwable -> L98
        L7c:
            r4.close()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> L98
        L7f:
            r8.close()     // Catch: java.io.IOException -> L97 java.lang.Throwable -> L98
            goto L97
        L83:
            r8 = r9
        L84:
            r9 = r7
            goto L8a
        L86:
            r8 = r9
            goto L8a
        L88:
            r8 = r9
            r4 = r8
        L8a:
            if (r9 == 0) goto L8f
            r9.close()     // Catch: java.io.IOException -> L8f java.lang.Throwable -> L98
        L8f:
            if (r4 == 0) goto L94
            r4.close()     // Catch: java.io.IOException -> L94 java.lang.Throwable -> L98
        L94:
            if (r8 == 0) goto L97
            goto L7f
        L97:
            return r2
        L98:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.b.c(java.lang.String, java.lang.String, byte[]):int");
    }
}
