package com.google.zxing.r.c;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;
import com.tencent.smtt.sdk.TbsListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: compiled from: Encoder.java */
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
        }
    }

    private static int a(b bVar) {
        return d.a(bVar) + d.b(bVar) + d.c(bVar) + d.d(bVar);
    }

    static void b(CharSequence charSequence, com.google.zxing.common.a aVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iCharAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                aVar.a((iCharAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    aVar.a((iCharAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    aVar.a(iCharAt, 4);
                }
            }
        }
    }

    public static f a(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        g gVarA;
        CharacterSetECI characterSetECIA;
        boolean z2 = map != null && map.containsKey(EncodeHintType.CHARACTER_SET);
        String string = z2 ? map.get(EncodeHintType.CHARACTER_SET).toString() : "ISO-8859-1";
        Mode modeA = a(str, string);
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (modeA == Mode.BYTE && z2 && (characterSetECIA = CharacterSetECI.a(string)) != null) {
            a(characterSetECIA, aVar);
        }
        if ((map != null && map.containsKey(EncodeHintType.GS1_FORMAT)) && Boolean.valueOf(map.get(EncodeHintType.GS1_FORMAT).toString()).booleanValue()) {
            a(Mode.FNC1_FIRST_POSITION, aVar);
        }
        a(modeA, aVar);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        a(str, modeA, aVar2, string);
        if (map != null && map.containsKey(EncodeHintType.QR_VERSION)) {
            gVarA = g.c(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!a(a(modeA, aVar, aVar2, gVarA), gVarA, errorCorrectionLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        } else {
            gVarA = a(errorCorrectionLevel, modeA, aVar, aVar2);
        }
        com.google.zxing.common.a aVar3 = new com.google.zxing.common.a();
        aVar3.a(aVar);
        a(modeA == Mode.BYTE ? aVar2.d() : str.length(), gVarA, modeA, aVar3);
        aVar3.a(aVar2);
        g.b bVarA = gVarA.a(errorCorrectionLevel);
        int iD = gVarA.d() - bVarA.d();
        a(iD, aVar3);
        com.google.zxing.common.a aVarA = a(aVar3, gVarA.d(), iD, bVarA.c());
        f fVar = new f();
        fVar.a(errorCorrectionLevel);
        fVar.a(modeA);
        fVar.a(gVarA);
        int iC = gVarA.c();
        b bVar = new b(iC, iC);
        int iA = a(aVarA, errorCorrectionLevel, gVarA, bVar);
        fVar.a(iA);
        e.a(aVarA, errorCorrectionLevel, gVarA, iA, bVar);
        fVar.a(bVar);
        return fVar;
    }

    private static g a(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2) throws WriterException {
        return a(a(mode, aVar, aVar2, a(a(mode, aVar, aVar2, g.c(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    private static int a(Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2, g gVar) {
        return aVar.c() + mode.a(gVar) + aVar2.c();
    }

    static int a(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    private static Mode a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return Mode.KANJI;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z3 = true;
            } else {
                if (a(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z2 = true;
            }
        }
        if (z2) {
            return Mode.ALPHANUMERIC;
        }
        if (z3) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, g gVar, b bVar) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            e.a(aVar, errorCorrectionLevel, gVar, i4, bVar);
            int iA = a(bVar);
            if (iA < i2) {
                i3 = i4;
                i2 = iA;
            }
        }
        return i3;
    }

    private static g a(int i2, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            g gVarC = g.c(i3);
            if (a(i2, gVarC, errorCorrectionLevel)) {
                return gVarC;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i2, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return gVar.d() - gVar.a(errorCorrectionLevel).d() >= (i2 + 7) / 8;
    }

    static void a(int i2, com.google.zxing.common.a aVar) throws WriterException {
        int i3 = i2 << 3;
        if (aVar.c() <= i3) {
            for (int i4 = 0; i4 < 4 && aVar.c() < i3; i4++) {
                aVar.a(false);
            }
            int iC = aVar.c() & 7;
            if (iC > 0) {
                while (iC < 8) {
                    aVar.a(false);
                    iC++;
                }
            }
            int iD = i2 - aVar.d();
            for (int i5 = 0; i5 < iD; i5++) {
                aVar.a((i5 & 1) == 0 ? TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS : 17, 8);
            }
            if (aVar.c() != i3) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.c() + " > " + i3);
    }

    static void a(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i4 != i7 + i6) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            } else {
                iArr[0] = i11;
                iArr2[0] = i13;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    static com.google.zxing.common.a a(com.google.zxing.common.a aVar, int i2, int i3, int i4) throws WriterException {
        if (aVar.d() == i3) {
            ArrayList arrayList = new ArrayList(i4);
            int i5 = 0;
            int iMax = 0;
            int iMax2 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i2, i3, i4, i6, iArr, iArr2);
                int i7 = iArr[0];
                byte[] bArr = new byte[i7];
                aVar.a(i5 << 3, bArr, 0, i7);
                byte[] bArrA = a(bArr, iArr2[0]);
                arrayList.add(new com.google.zxing.r.c.a(bArr, bArrA));
                iMax = Math.max(iMax, i7);
                iMax2 = Math.max(iMax2, bArrA.length);
                i5 += iArr[0];
            }
            if (i3 == i5) {
                com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
                for (int i8 = 0; i8 < iMax; i8++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArrA2 = ((com.google.zxing.r.c.a) it.next()).a();
                        if (i8 < bArrA2.length) {
                            aVar2.a(bArrA2[i8], 8);
                        }
                    }
                }
                for (int i9 = 0; i9 < iMax2; i9++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] bArrB = ((com.google.zxing.r.c.a) it2.next()).b();
                        if (i9 < bArrB.length) {
                            aVar2.a(bArrB[i9], 8);
                        }
                    }
                }
                if (i2 == aVar2.d()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i2 + " and " + aVar2.d() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new com.google.zxing.common.reedsolomon.d(com.google.zxing.common.reedsolomon.a.f16175l).a(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static void a(Mode mode, com.google.zxing.common.a aVar) {
        aVar.a(mode.f(), 4);
    }

    static void a(int i2, g gVar, Mode mode, com.google.zxing.common.a aVar) throws WriterException {
        int iA = mode.a(gVar);
        int i3 = 1 << iA;
        if (i2 < i3) {
            aVar.a(i2, iA);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    static void a(String str, Mode mode, com.google.zxing.common.a aVar, String str2) throws WriterException {
        int i2 = a.a[mode.ordinal()];
        if (i2 == 1) {
            b(str, aVar);
            return;
        }
        if (i2 == 2) {
            a((CharSequence) str, aVar);
        } else if (i2 == 3) {
            a(str, aVar, str2);
        } else {
            if (i2 == 4) {
                a(str, aVar);
                return;
            }
            throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
        }
    }

    static void a(CharSequence charSequence, com.google.zxing.common.a aVar) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iA = a(charSequence.charAt(i2));
            if (iA == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int iA2 = a(charSequence.charAt(i3));
                if (iA2 != -1) {
                    aVar.a((iA * 45) + iA2, 11);
                    i2 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                aVar.a(iA, 6);
                i2 = i3;
            }
        }
    }

    static void a(String str, com.google.zxing.common.a aVar, String str2) throws WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                aVar.a(b, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    static void a(String str, com.google.zxing.common.a aVar) throws WriterException {
        int i2;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i3 = 0; i3 < length; i3 += 2) {
                int i4 = ((bytes[i3] & 255) << 8) | (bytes[i3 + 1] & 255);
                int i5 = 33088;
                if (i4 >= 33088 && i4 <= 40956) {
                    i2 = i4 - i5;
                } else if (i4 < 57408 || i4 > 60351) {
                    i2 = -1;
                } else {
                    i5 = 49472;
                    i2 = i4 - i5;
                }
                if (i2 != -1) {
                    aVar.a(((i2 >> 8) * 192) + (i2 & 255), 13);
                } else {
                    throw new WriterException("Invalid byte sequence");
                }
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    private static void a(CharacterSetECI characterSetECI, com.google.zxing.common.a aVar) {
        aVar.a(Mode.ECI.f(), 4);
        aVar.a(characterSetECI.f(), 8);
    }
}
