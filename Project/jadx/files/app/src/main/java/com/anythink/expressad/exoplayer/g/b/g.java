package com.anythink.expressad.exoplayer.g.b;

import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.anythink.expressad.exoplayer.g.b {
    public static final a a = new a() { // from class: com.anythink.expressad.exoplayer.g.b.g.1
        @Override // com.anythink.expressad.exoplayer.g.b.g.a
        public final boolean a(int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    };
    public static final int b = af.f("ID3");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9094c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9095d = "Id3Decoder";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9096e = 128;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9097f = 64;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9098g = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9099h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9100i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f9101j = 64;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9102k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9103l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9104m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9105n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f9106o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f9107p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final a f9108q;

    public interface a {
        boolean a(int i2, int i3, int i4, int i5, int i6);
    }

    private static final class b {
        private final int a;
        private final boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9109c;

        public b(int i2, boolean z2, int i3) {
            this.a = i2;
            this.b = z2;
            this.f9109c = i3;
        }
    }

    public g() {
        this(null);
    }

    private static String a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : com.umeng.message.proguard.k.f20481d : "UTF-16" : "ISO-8859-1";
    }

    private static int b(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    private static l b(s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int iA = a(bArr, 0, iD);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iD);
        return new l("WXXX", str, a(bArr, iB, b(bArr, iB), "ISO-8859-1"));
    }

    private static j c(s sVar, int i2) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        int iB = b(bArr, 0);
        return new j(new String(bArr, 0, iB, "ISO-8859-1"), b(bArr, iB + 1, bArr.length));
    }

    private static f d(s sVar, int i2) {
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i4 = iB + 1;
        int iA = a(bArr, i4, iD);
        String strA2 = a(bArr, i4, iA, strA);
        int iB2 = iA + b(iD);
        int iA2 = a(bArr, iB2, iD);
        return new f(str, strA2, a(bArr, iB2, iA2, strA), b(bArr, iA2 + b(iD), bArr.length));
    }

    private static e e(s sVar, int i2) {
        if (i2 < 4) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        byte[] bArr = new byte[3];
        sVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        sVar.a(bArr2, 0, i3);
        int iA = a(bArr2, 0, iD);
        String str2 = new String(bArr2, 0, iA, strA);
        int iB = iA + b(iD);
        return new e(str, str2, a(bArr2, iB, a(bArr2, iB, iD), strA));
    }

    private static int f(s sVar, int i2) {
        byte[] bArr = sVar.a;
        int iC = sVar.c();
        while (true) {
            int i3 = iC + 1;
            if (i3 >= i2) {
                return i2;
            }
            if ((bArr[iC] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, iC + 2, bArr, i3, (i2 - iC) - 2);
                i2--;
            }
            iC = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    @Override // com.anythink.expressad.exoplayer.g.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.g.e r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.g.b.g.a(com.anythink.expressad.exoplayer.g.e):com.anythink.expressad.exoplayer.g.a");
    }

    private g(a aVar) {
        this.f9108q = aVar;
    }

    private static com.anythink.expressad.exoplayer.g.b.b c(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new com.anythink.expressad.exoplayer.g.b.b(str, bArr);
    }

    private static l b(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new l(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static d b(s sVar, int i2, int i3, boolean z2, int i4, a aVar) throws Throwable {
        int iC = sVar.c();
        int iB = b(sVar.a, iC);
        String str = new String(sVar.a, iC, iB - iC, "ISO-8859-1");
        sVar.c(iB + 1);
        int iD = sVar.d();
        boolean z3 = (iD & 2) != 0;
        boolean z4 = (iD & 1) != 0;
        int iD2 = sVar.d();
        String[] strArr = new String[iD2];
        for (int i5 = 0; i5 < iD2; i5++) {
            int iC2 = sVar.c();
            int iB2 = b(sVar.a, iC2);
            strArr[i5] = new String(sVar.a, iC2, iB2 - iC2, "ISO-8859-1");
            sVar.c(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = iC + i2;
        while (sVar.c() < i6) {
            h hVarA = a(i3, sVar, z2, i4, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new d(str, z3, z4, strArr, hVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.anythink.expressad.exoplayer.g.a a(byte[] r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.g.b.g.a(byte[], int):com.anythink.expressad.exoplayer.g.a");
    }

    private static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? new byte[0] : Arrays.copyOfRange(bArr, i2, i3);
    }

    private static b a(s sVar) {
        if (sVar.a() < 10) {
            return null;
        }
        int iG = sVar.g();
        if (iG != b) {
            "Unexpected first three bytes of ID3 tag header: ".concat(String.valueOf(iG));
            return null;
        }
        int iD = sVar.d();
        sVar.d(1);
        int iD2 = sVar.d();
        int iL = sVar.l();
        if (iD == 2) {
            if ((iD2 & 64) != 0) {
                return null;
            }
        } else if (iD == 3) {
            if ((iD2 & 64) != 0) {
                int i2 = sVar.i();
                sVar.d(i2);
                iL -= i2 + 4;
            }
        } else {
            if (iD != 4) {
                "Skipped ID3 tag with unsupported majorVersion=".concat(String.valueOf(iD));
                return null;
            }
            if ((iD2 & 64) != 0) {
                int iL2 = sVar.l();
                sVar.d(iL2 - 4);
                iL -= iL2;
            }
            if ((iD2 & 16) != 0) {
                iL -= 10;
            }
        }
        return new b(iD, iD < 4 && (iD2 & 128) != 0, iL);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[PHI: r3
  0x0078: PHI (r3v13 boolean) = (r3v5 boolean), (r3v16 boolean) binds: [B:39:0x0085, B:31:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.anythink.expressad.exoplayer.k.s r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.c()
        L8:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Lb2
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L22
            int r7 = r18.i()     // Catch: java.lang.Throwable -> Lb2
            long r8 = r18.h()     // Catch: java.lang.Throwable -> Lb2
            int r10 = r18.e()     // Catch: java.lang.Throwable -> Lb2
            goto L2c
        L22:
            int r7 = r18.g()     // Catch: java.lang.Throwable -> Lb2
            int r8 = r18.g()     // Catch: java.lang.Throwable -> Lb2
            long r8 = (long) r8
            r10 = 0
        L2c:
            r11 = 0
            if (r7 != 0) goto L3a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3a
            if (r10 != 0) goto L3a
            r1.c(r2)
            return r4
        L3a:
            r7 = 4
            if (r0 != r7) goto L6b
            if (r21 != 0) goto L6b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4b
            r1.c(r2)
            return r6
        L4b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6b:
            if (r0 != r7) goto L7a
            r3 = r10 & 64
            if (r3 == 0) goto L73
            r3 = 1
            goto L74
        L73:
            r3 = 0
        L74:
            r7 = r10 & 1
            if (r7 == 0) goto L89
        L78:
            r7 = 1
            goto L8a
        L7a:
            if (r0 != r3) goto L88
            r3 = r10 & 32
            if (r3 == 0) goto L82
            r3 = 1
            goto L83
        L82:
            r3 = 0
        L83:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L89
            goto L78
        L88:
            r3 = 0
        L89:
            r7 = 0
        L8a:
            if (r3 == 0) goto L8d
            goto L8e
        L8d:
            r4 = 0
        L8e:
            if (r7 == 0) goto L92
            int r4 = r4 + 4
        L92:
            long r3 = (long) r4
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L9b
            r1.c(r2)
            return r6
        L9b:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Lb2
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La8
            r1.c(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.d(r3)     // Catch: java.lang.Throwable -> Lb2
            goto L8
        Lae:
            r1.c(r2)
            return r4
        Lb2:
            r0 = move-exception
            r1.c(r2)
            goto Lb8
        Lb7:
            throw r0
        Lb8:
            goto Lb7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.g.b.g.a(com.anythink.expressad.exoplayer.k.s, int, int, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0273 A[Catch: all -> 0x016b, UnsupportedEncodingException -> 0x016f, TryCatch #3 {UnsupportedEncodingException -> 0x016f, all -> 0x016b, blocks: (B:92:0x0112, B:94:0x0142, B:97:0x0149, B:110:0x0183, B:113:0x01b5, B:122:0x01df, B:131:0x020c, B:143:0x0261, B:145:0x0273, B:152:0x02b8, B:149:0x0297, B:151:0x02ae), top: B:196:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0297 A[Catch: all -> 0x016b, UnsupportedEncodingException -> 0x016f, TryCatch #3 {UnsupportedEncodingException -> 0x016f, all -> 0x016b, blocks: (B:92:0x0112, B:94:0x0142, B:97:0x0149, B:110:0x0183, B:113:0x01b5, B:122:0x01df, B:131:0x020c, B:143:0x0261, B:145:0x0273, B:152:0x02b8, B:149:0x0297, B:151:0x02ae), top: B:196:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0362 A[Catch: all -> 0x038d, UnsupportedEncodingException -> 0x0391, TryCatch #4 {UnsupportedEncodingException -> 0x0391, all -> 0x038d, blocks: (B:183:0x0373, B:154:0x02ca, B:167:0x02f5, B:174:0x0338, B:180:0x0352, B:181:0x0362), top: B:196:0x0104 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0110  */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.anythink.expressad.exoplayer.g.b.h] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v28, types: [com.anythink.expressad.exoplayer.g.b.h] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.anythink.expressad.exoplayer.g.b.h a(int r18, com.anythink.expressad.exoplayer.k.s r19, boolean r20, int r21, com.anythink.expressad.exoplayer.g.b.g.a r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 937
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.g.b.g.a(int, com.anythink.expressad.exoplayer.k.s, boolean, int, com.anythink.expressad.exoplayer.g.b.g$a):com.anythink.expressad.exoplayer.g.b.h");
    }

    private static k a(s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int iA = a(bArr, 0, iD);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iD);
        return new k("TXXX", str, a(bArr, iB, a(bArr, iB, iD), strA));
    }

    private static k a(s sVar, int i2, String str) {
        if (i2 <= 0) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        return new k(str, null, new String(bArr, 0, a(bArr, 0, iD), strA));
    }

    private static com.anythink.expressad.exoplayer.g.b.a a(s sVar, int i2, int i3) {
        int iB;
        String strConcat;
        int iD = sVar.d();
        String strA = a(iD);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        sVar.a(bArr, 0, i4);
        if (i3 == 2) {
            strConcat = "image/" + af.d(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(strConcat)) {
                strConcat = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(bArr, 0);
            String strD = af.d(new String(bArr, 0, iB, "ISO-8859-1"));
            strConcat = strD.indexOf(47) == -1 ? "image/".concat(String.valueOf(strD)) : strD;
        }
        int i5 = bArr[iB + 1] & 255;
        int i6 = iB + 2;
        int iA = a(bArr, i6, iD);
        return new com.anythink.expressad.exoplayer.g.b.a(strConcat, new String(bArr, i6, iA - i6, strA), i5, b(bArr, iA + b(iD), bArr.length));
    }

    private static c a(s sVar, int i2, int i3, boolean z2, int i4, a aVar) throws Throwable {
        int iC = sVar.c();
        int iB = b(sVar.a, iC);
        String str = new String(sVar.a, iC, iB - iC, "ISO-8859-1");
        sVar.c(iB + 1);
        int i5 = sVar.i();
        int i6 = sVar.i();
        long jH = sVar.h();
        long j2 = jH == 4294967295L ? -1L : jH;
        long jH2 = sVar.h();
        long j3 = jH2 == 4294967295L ? -1L : jH2;
        ArrayList arrayList = new ArrayList();
        int i7 = iC + i2;
        while (sVar.c() < i7) {
            h hVarA = a(i3, sVar, z2, i4, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new c(str, i5, i6, j2, j3, hVarArr);
    }

    private static String a(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private static int a(byte[] bArr, int i2, int i3) {
        int iB = b(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if (iB % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(bArr, iB + 1);
        }
        return bArr.length;
    }

    private static String a(byte[] bArr, int i2, int i3, String str) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, str);
    }
}
