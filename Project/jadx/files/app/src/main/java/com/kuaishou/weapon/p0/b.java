package com.kuaishou.weapon.p0;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final String a = "AES/CBC/NoPadding";
    public static final int b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16560c = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f16561d = "AES/CBC/PKCS5Padding";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f16562e = "AES";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f16563f = "AES/CBC/PKCS7Padding";

    public static byte[] a(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), f16562e);
        Cipher cipher = Cipher.getInstance(f16561d);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f16562e);
            Cipher cipher = Cipher.getInstance(f16561d);
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < 16; i2++) {
                bArr3[i2] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z2) {
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

    public static byte[] b(String str, String str2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), f16562e);
        Cipher cipher = Cipher.getInstance(f16561d);
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|68|3|(4:5|(2:8|6)|69|9)(2:10|(1:12))|13|(2:64|(3:59|14|(3:55|15|(6:53|16|(1:18)|70|19|20))))|(2:51|21)|(4:22|(1:24)(1:71)|63|44)|25|66|26|61|27|28|63|44|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|68|3|(4:5|(2:8|6)|69|9)(2:10|(1:12))|13|64|(3:59|14|(3:55|15|(6:53|16|(1:18)|70|19|20)))|(2:51|21)|(4:22|(1:24)(1:71)|63|44)|25|66|26|61|27|28|63|44|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = -1
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L9f
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L9f
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L9f
            r2 = 0
            r3 = 16
            if (r9 >= r3) goto L2a
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L9f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9f
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L9f
            r1 = 0
        L19:
            int r5 = 16 - r9
            if (r1 >= r5) goto L25
            java.lang.String r5 = "0"
            r4.append(r5)     // Catch: java.lang.Throwable -> L9f
            int r1 = r1 + 1
            goto L19
        L25:
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L9f
            goto L34
        L2a:
            int r9 = r1.length()     // Catch: java.lang.Throwable -> L9f
            if (r9 <= r3) goto L34
            java.lang.String r1 = r1.substring(r2, r3)     // Catch: java.lang.Throwable -> L9f
        L34:
            r9 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L89
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L89
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L87
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L87
            javax.crypto.spec.SecretKeySpec r8 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L85
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L85
            java.lang.String r5 = "AES"
            r8.<init>(r1, r5)     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Throwable -> L85
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L85
            r6 = 0
        L53:
            if (r6 >= r3) goto L5a
            r5[r6] = r2     // Catch: java.lang.Throwable -> L85
            int r6 = r6 + 1
            goto L53
        L5a:
            javax.crypto.spec.IvParameterSpec r3 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L85
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L85
            r5 = 2
            r1.init(r5, r8, r3)     // Catch: java.lang.Throwable -> L85
            javax.crypto.CipherInputStream r8 = new javax.crypto.CipherInputStream     // Catch: java.lang.Throwable -> L85
            r8.<init>(r4, r1)     // Catch: java.lang.Throwable -> L85
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch: java.lang.Throwable -> L83
        L6c:
            int r1 = r8.read(r9)     // Catch: java.lang.Throwable -> L83
            if (r1 == r0) goto L76
            r7.write(r9, r2, r1)     // Catch: java.lang.Throwable -> L83
            goto L6c
        L76:
            r8.close()     // Catch: java.lang.Throwable -> L83
            r7.close()     // Catch: java.io.IOException -> L7c java.lang.Throwable -> L9f
        L7c:
            r4.close()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> L9f
        L7f:
            r8.close()     // Catch: java.io.IOException -> L9e java.lang.Throwable -> L9f
            goto L9e
        L83:
            r9 = r8
            goto L8b
        L85:
            goto L8b
        L87:
            r7 = r9
            goto L8b
        L89:
            r7 = r9
            r4 = r7
        L8b:
            if (r7 == 0) goto L92
            r7.close()     // Catch: java.io.IOException -> L91 java.lang.Throwable -> L9f
            goto L92
        L91:
        L92:
            if (r4 == 0) goto L99
            r4.close()     // Catch: java.io.IOException -> L98 java.lang.Throwable -> L9f
            goto L99
        L98:
        L99:
            if (r9 == 0) goto L9e
            r9.close()     // Catch: java.io.IOException -> L9e java.lang.Throwable -> L9f
        L9e:
            return r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.b.c(java.lang.String, java.lang.String, byte[]):int");
    }
}
