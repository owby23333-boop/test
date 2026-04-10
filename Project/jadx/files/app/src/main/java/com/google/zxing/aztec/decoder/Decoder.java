package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.c.e;
import com.anythink.expressad.foundation.d.c;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.tts.tools.cuid.util.DeviceId;
import com.google.zxing.FormatException;
import com.google.zxing.common.b;
import com.google.zxing.common.d;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.umeng.analytics.pro.am;
import com.umeng.message.proguard.ad;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Decoder {
    private static final String[] b = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", DeviceId.CUIDInfo.I_FIXED, "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f16123c = {"CTRL_PS", " ", "a", "b", "c", "d", e.a, "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", c.bj, "r", "s", "t", "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", am.aD, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f16124d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", com.anythink.expressad.foundation.g.a.bQ, "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f16125e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", DispatchConstants.SIGN_SPLIT_SYMBOL, "'", ad.f20405r, ad.f20406s, "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f16126f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private com.google.zxing.l.a a;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[Table.values().length];

        static {
            try {
                a[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static int a(int i2, boolean z2) {
        return ((z2 ? 88 : 112) + (i2 << 4)) * i2;
    }

    private boolean[] b(boolean[] zArr) throws FormatException {
        com.google.zxing.common.reedsolomon.a aVar;
        int i2 = 8;
        if (this.a.d() <= 2) {
            i2 = 6;
            aVar = com.google.zxing.common.reedsolomon.a.f16173j;
        } else if (this.a.d() <= 8) {
            aVar = com.google.zxing.common.reedsolomon.a.f16177n;
        } else if (this.a.d() <= 22) {
            i2 = 10;
            aVar = com.google.zxing.common.reedsolomon.a.f16172i;
        } else {
            i2 = 12;
            aVar = com.google.zxing.common.reedsolomon.a.f16171h;
        }
        int iC = this.a.c();
        int length = zArr.length / i2;
        if (length < iC) {
            throw FormatException.f();
        }
        int[] iArr = new int[length];
        int length2 = zArr.length % i2;
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = a(zArr, length2, i2);
            i3++;
            length2 += i2;
        }
        try {
            new com.google.zxing.common.reedsolomon.c(aVar).a(iArr, length - iC);
            int i4 = (1 << i2) - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < iC; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw FormatException.f();
                }
                if (i7 == 1 || i7 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(iC * i2) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < iC; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i4 - 1) {
                    Arrays.fill(zArr2, i8, (i8 + i2) - 1, i10 > 1);
                    i8 += i2 - 1;
                } else {
                    int i11 = i2 - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e2) {
            throw FormatException.a(e2);
        }
    }

    private static String c(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        Table tableA = table2;
        int i2 = 0;
        while (i2 < length) {
            if (table2 != Table.BINARY) {
                int i3 = table2 == Table.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int iA = a(zArr, i2, i3);
                i2 += i3;
                String strA = a(table2, iA);
                if (strA.startsWith("CTRL_")) {
                    tableA = a(strA.charAt(5));
                    if (strA.charAt(6) != 'L') {
                        tableA = table2;
                        table2 = tableA;
                    }
                } else {
                    sb.append(strA);
                }
                table2 = tableA;
            } else {
                if (length - i2 < 5) {
                    break;
                }
                int iA2 = a(zArr, i2, 5);
                int i4 = i2 + 5;
                if (iA2 == 0) {
                    if (length - i4 < 11) {
                        break;
                    }
                    iA2 = a(zArr, i4, 11) + 31;
                    i4 += 11;
                }
                int i5 = i4;
                int i6 = 0;
                while (true) {
                    if (i6 >= iA2) {
                        i2 = i5;
                        break;
                    }
                    if (length - i5 < 8) {
                        i2 = length;
                        break;
                    }
                    sb.append((char) a(zArr, i5, 8));
                    i5 += 8;
                    i6++;
                }
                table2 = tableA;
            }
        }
        return sb.toString();
    }

    public d a(com.google.zxing.l.a aVar) throws FormatException {
        this.a = aVar;
        boolean[] zArrB = b(a(aVar.a()));
        d dVar = new d(a(zArrB), c(zArrB), null, null);
        dVar.a(zArrB.length);
        return dVar;
    }

    private static Table a(char c2) {
        if (c2 == 'B') {
            return Table.BINARY;
        }
        if (c2 == 'D') {
            return Table.DIGIT;
        }
        if (c2 == 'P') {
            return Table.PUNCT;
        }
        if (c2 == 'L') {
            return Table.LOWER;
        }
        if (c2 != 'M') {
            return Table.UPPER;
        }
        return Table.MIXED;
    }

    private static String a(Table table, int i2) {
        int i3 = a.a[table.ordinal()];
        if (i3 == 1) {
            return b[i2];
        }
        if (i3 == 2) {
            return f16123c[i2];
        }
        if (i3 == 3) {
            return f16124d[i2];
        }
        if (i3 == 4) {
            return f16125e[i2];
        }
        if (i3 == 5) {
            return f16126f[i2];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] a(b bVar) {
        boolean zE = this.a.e();
        int iD = this.a.d();
        int i2 = (zE ? 11 : 14) + (iD << 2);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[a(iD, zE)];
        int i3 = 2;
        if (zE) {
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                iArr[(i5 - i7) - 1] = (i6 - r12) - 1;
                iArr[i5 + i7] = (i7 / 15) + i7 + i6 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < iD) {
            int i10 = ((iD - i8) << i3) + (zE ? 9 : 12);
            int i11 = i8 << 1;
            int i12 = (i2 - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 << 1;
                int i15 = 0;
                while (i15 < i3) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = bVar.b(iArr[i16], iArr[i17]);
                    int i18 = iArr[i17];
                    int i19 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = bVar.b(i18, iArr[i19]);
                    int i20 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = bVar.b(iArr[i19], iArr[i20]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = bVar.b(iArr[i20], iArr[i16]);
                    i15++;
                    iD = iD;
                    zE = zE;
                    i3 = 2;
                }
                i13++;
                i3 = 2;
            }
            i9 += i10 << 3;
            i8++;
            i3 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    private static byte a(boolean[] zArr, int i2) {
        int iA;
        int length = zArr.length - i2;
        if (length >= 8) {
            iA = a(zArr, i2, 8);
        } else {
            iA = a(zArr, i2, length) << (8 - length);
        }
        return (byte) iA;
    }

    static byte[] a(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = a(zArr, i2 << 3);
        }
        return bArr;
    }
}
