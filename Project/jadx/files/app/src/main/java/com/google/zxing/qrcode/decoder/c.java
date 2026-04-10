package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.k;
import com.tencent.smtt.sdk.TbsListener;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[Mode.values().length];

        static {
            try {
                a[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc A[LOOP:0: B:53:0x001e->B:49:0x00dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.zxing.common.d a(byte[] r17, com.google.zxing.qrcode.decoder.g r18, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.c.a(byte[], com.google.zxing.qrcode.decoder.g, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.common.d");
    }

    private static void b(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > cVar.a()) {
            throw FormatException.f();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iA = cVar.a(13);
            int i4 = (iA % 192) | ((iA / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.f();
        }
    }

    private static void c(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw FormatException.f();
            }
            int iA = cVar.a(10);
            if (iA >= 1000) {
                throw FormatException.f();
            }
            sb.append(a(iA / 100));
            sb.append(a((iA / 10) % 10));
            sb.append(a(iA % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw FormatException.f();
            }
            int iA2 = cVar.a(7);
            if (iA2 >= 100) {
                throw FormatException.f();
            }
            sb.append(a(iA2 / 10));
            sb.append(a(iA2 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw FormatException.f();
            }
            int iA3 = cVar.a(4);
            if (iA3 >= 10) {
                throw FormatException.f();
            }
            sb.append(a(iA3));
        }
    }

    private static void a(com.google.zxing.common.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int iA = cVar.a(13);
                int i4 = (iA % 96) | ((iA / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.f();
            }
        }
        throw FormatException.f();
    }

    private static void a(com.google.zxing.common.c cVar, StringBuilder sb, int i2, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String strName;
        if ((i2 << 3) <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.a(8);
            }
            if (characterSetECI == null) {
                strName = k.a(bArr, map);
            } else {
                strName = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, strName));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.f();
            }
        }
        throw FormatException.f();
    }

    private static char a(int i2) throws FormatException {
        char[] cArr = a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.zxing.common.c r3, java.lang.StringBuilder r4, int r5, boolean r6) throws com.google.zxing.FormatException {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.a(r2)
            int r2 = r1 / 45
            char r2 = a(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = a(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.f()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.a(r2)
            char r3 = a(r3)
            r4.append(r3)
            goto L47
        L42:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.f()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.c.a(com.google.zxing.common.c, java.lang.StringBuilder, int, boolean):void");
    }

    private static int a(com.google.zxing.common.c cVar) throws FormatException {
        int iA = cVar.a(8);
        if ((iA & 128) == 0) {
            return iA & 127;
        }
        if ((iA & 192) == 128) {
            return cVar.a(8) | ((iA & 63) << 8);
        }
        if ((iA & TbsListener.ErrorCode.EXCEED_INCR_UPDATE) == 192) {
            return cVar.a(16) | ((iA & 31) << 16);
        }
        throw FormatException.f();
    }
}
