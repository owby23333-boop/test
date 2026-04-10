package com.anythink.core.common.h;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.cb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static Map<Character, Character> a;
    private static char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static char[] f7569c = {'5', 'P', 'V', 'u', '3', 'J', 'j', 'l', 'e', 'Q', 'b', 'H', '9', 'A', 'v', 'h', 't', 's', 'g', 'W', 'I', 'C', 'U', 'i', 'F', '2', 'a', 'd', 'M', '8', 'D', 'y', 'Z', 'O', 'N', 'k', '/', '4', 'R', '7', '0', 'f', 'n', '+', 'z', 'G', 'Y', 'L', 'X', 'p', 'm', '1', 'E', 'K', 'S', 'T', 'o', 'x', '6', 'q', 'w', 'r', 'c', 'B'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static byte[] f7570d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cb.f19602k, cb.f19603l, cb.f19604m, cb.f19605n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    protected static b a(String str, String str2) {
        b bVar = new b();
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 2)));
            int iBitLength = publicKeyGeneratePublic instanceof RSAPublicKey ? ((RSAPublicKey) publicKeyGeneratePublic).getModulus().bitLength() : 0;
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            int i2 = (iBitLength / 8) - 11;
            bVar.a(new String(Base64.encode(i2 > 0 ? a(cipher, str2.getBytes(), i2) : cipher.doFinal(str2.getBytes()), 2)));
        } catch (Throwable th) {
            bVar.b(th.getMessage());
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        if (r2 == (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        r1.write(r2 | ((r5 & 3) << 6));
        r2 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] b(java.lang.String r8) {
        /*
            byte[] r8 = r8.getBytes()
            int r0 = r8.length
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>(r0)
            r2 = 0
        Lb:
            if (r2 >= r0) goto L82
        Ld:
            byte[] r3 = com.anythink.core.common.h.a.f7570d
            int r4 = r2 + 1
            r2 = r8[r2]
            r2 = r3[r2]
            r3 = -1
            if (r4 >= r0) goto L1d
            if (r2 == r3) goto L1b
            goto L1d
        L1b:
            r2 = r4
            goto Ld
        L1d:
            if (r2 == r3) goto L82
        L1f:
            byte[] r5 = com.anythink.core.common.h.a.f7570d
            int r6 = r4 + 1
            r4 = r8[r4]
            r4 = r5[r4]
            if (r6 >= r0) goto L2e
            if (r4 == r3) goto L2c
            goto L2e
        L2c:
            r4 = r6
            goto L1f
        L2e:
            if (r4 == r3) goto L82
            int r2 = r2 << 2
            r5 = r4 & 48
            int r5 = r5 >>> 4
            r2 = r2 | r5
            r1.write(r2)
        L3a:
            int r2 = r6 + 1
            r5 = r8[r6]
            r6 = 61
            if (r5 != r6) goto L47
            byte[] r8 = r1.toByteArray()
            return r8
        L47:
            byte[] r7 = com.anythink.core.common.h.a.f7570d
            r5 = r7[r5]
            if (r2 >= r0) goto L52
            if (r5 == r3) goto L50
            goto L52
        L50:
            r6 = r2
            goto L3a
        L52:
            if (r5 == r3) goto L82
            r4 = r4 & 15
            int r4 = r4 << 4
            r7 = r5 & 60
            int r7 = r7 >>> 2
            r4 = r4 | r7
            r1.write(r4)
        L60:
            int r4 = r2 + 1
            r2 = r8[r2]
            if (r2 != r6) goto L6b
            byte[] r8 = r1.toByteArray()
            return r8
        L6b:
            byte[] r7 = com.anythink.core.common.h.a.f7570d
            r2 = r7[r2]
            if (r4 >= r0) goto L76
            if (r2 == r3) goto L74
            goto L76
        L74:
            r2 = r4
            goto L60
        L76:
            if (r2 == r3) goto L82
            r3 = r5 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            r1.write(r2)
            r2 = r4
            goto Lb
        L82:
            byte[] r8 = r1.toByteArray()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.h.a.b(java.lang.String):byte[]");
    }

    private static byte[] a(Cipher cipher, byte[] bArr, int i2) throws BadPaddingException, IllegalBlockSizeException, IOException {
        byte[] bArrDoFinal;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = length - i3;
            if (i5 > 0) {
                if (i5 > i2) {
                    bArrDoFinal = cipher.doFinal(bArr, i3, i2);
                } else {
                    bArrDoFinal = cipher.doFinal(bArr, i3, i5);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i4++;
                i3 = i4 * i2;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static String a(String str) {
        Character chValueOf;
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                char[] charArray = str.toCharArray();
                if (charArray != null && charArray.length > 0) {
                    char[] cArr = new char[charArray.length];
                    for (int i2 = 0; i2 < charArray.length; i2++) {
                        char c2 = charArray[i2];
                        if (a == null) {
                            a = new HashMap();
                            for (int i3 = 0; i3 < b.length; i3++) {
                                a.put(Character.valueOf(f7569c[i3]), Character.valueOf(b[i3]));
                            }
                        }
                        if (a.containsKey(Character.valueOf(c2))) {
                            chValueOf = a.get(Character.valueOf(c2));
                        } else {
                            chValueOf = Character.valueOf(c2);
                        }
                        cArr[i2] = chValueOf.charValue();
                    }
                    str2 = new String(cArr);
                }
                return new String(b(str2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    private static Character a(char c2) {
        if (a == null) {
            a = new HashMap();
            for (int i2 = 0; i2 < b.length; i2++) {
                a.put(Character.valueOf(f7569c[i2]), Character.valueOf(b[i2]));
            }
        }
        if (a.containsKey(Character.valueOf(c2))) {
            return a.get(Character.valueOf(c2));
        }
        return Character.valueOf(c2);
    }
}
