package com.anythink.expressad.foundation.h;

import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public static final int a = 256;
    private static Map<Character, Character> b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<Character, Character> f10693c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f10694d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static char[] f10695e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f10696f = '=';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f10697g;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', 'd');
        b.put('I', 'R');
        b.put('J', 'z');
        b.put('K', 'p');
        b.put('L', 'W');
        b.put('M', 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put('Y', 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put('b', 'Y');
        b.put('c', 'h');
        b.put('d', 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', 'l');
        b.put('h', 't');
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put('l', 'Q');
        b.put('m', 'r');
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', 'u');
        b.put('q', 'q');
        b.put('r', '8');
        b.put('s', 's');
        b.put('t', 'w');
        b.put('u', '/');
        b.put('v', 'X');
        b.put('w', 'M');
        b.put('x', 'e');
        b.put('y', 'B');
        b.put('z', 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', 'b');
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', 'm');
        b.put('/', 'C');
        f10695e = new char[f10694d.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            char[] cArr = f10694d;
            if (i3 >= cArr.length) {
                break;
            }
            f10695e[i3] = b.get(Character.valueOf(cArr[i3])).charValue();
            i3++;
        }
        f10697g = new byte[128];
        int i4 = 0;
        while (true) {
            byte[] bArr = f10697g;
            if (i4 >= bArr.length) {
                break;
            }
            bArr[i4] = 127;
            i4++;
        }
        while (true) {
            char[] cArr2 = f10695e;
            if (i2 >= cArr2.length) {
                return;
            }
            f10697g[cArr2[i2]] = (byte) i2;
            i2++;
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i2) {
        try {
            char c2 = cArr[3] == '=' ? (char) 2 : (char) 3;
            if (cArr[2] == '=') {
                c2 = 1;
            }
            byte b2 = f10697g[cArr[0]];
            byte b3 = f10697g[cArr[1]];
            byte b4 = f10697g[cArr[2]];
            byte b5 = f10697g[cArr[3]];
            if (c2 == 2) {
                bArr[i2] = (byte) ((3 & (b3 >> 4)) | ((b2 << 2) & 252));
                bArr[i2 + 1] = (byte) (((b3 << 4) & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) | ((b4 >> 2) & 15));
                return 2;
            }
            if (c2 != 3) {
                bArr[i2] = (byte) (((b2 << 2) & 252) | (3 & (b3 >> 4)));
                return 1;
            }
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((b2 << 2) & 252) | ((b3 >> 4) & 3));
            bArr[i3] = (byte) (((b3 << 4) & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) | ((b4 >> 2) & 15));
            bArr[i3 + 1] = (byte) ((b5 & Utf8.REPLACEMENT_BYTE) | ((b4 << 6) & 192));
            return 3;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, bytes.length);
    }

    private static byte[] c(String str) {
        int i2;
        try {
            int length = str.length();
            char[] cArr = new char[length < 259 ? length : 259];
            byte[] bArr = new byte[((length >> 2) * 3) + 3];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length) {
                int i6 = i3 + 256;
                if (i6 <= length) {
                    str.getChars(i3, i6, cArr, i5);
                    i2 = i5 + 256;
                } else {
                    str.getChars(i3, length, cArr, i5);
                    i2 = (length - i3) + i5;
                }
                int iA = i4;
                int i7 = i5;
                while (i5 < i2) {
                    char c2 = cArr[i5];
                    if (c2 == '=' || (c2 < f10697g.length && f10697g[c2] != 127)) {
                        int i8 = i7 + 1;
                        cArr[i7] = c2;
                        if (i8 == 4) {
                            iA += a(cArr, bArr, iA);
                            i7 = 0;
                        } else {
                            i7 = i8;
                        }
                    }
                    i5++;
                }
                i5 = i7;
                i3 = i6;
                i4 = iA;
            }
            if (i4 == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, 0, i4);
            return bArr2;
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] a(char[] cArr, int i2, int i3) {
        try {
            char[] cArr2 = new char[4];
            byte[] bArr = new byte[((i3 >> 2) * 3) + 3];
            int iA = 0;
            int i4 = 0;
            for (int i5 = i2; i5 < i2 + i3; i5++) {
                char c2 = cArr[i5];
                if (c2 == '=' || (c2 < f10697g.length && f10697g[c2] != 127)) {
                    int i6 = i4 + 1;
                    cArr2[i4] = c2;
                    if (i6 == 4) {
                        iA += a(cArr2, bArr, iA);
                        i4 = 0;
                    } else {
                        i4 = i6;
                    }
                }
            }
            if (iA == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[iA];
            System.arraycopy(bArr, 0, bArr2, 0, iA);
            return bArr2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] bArrC = c(str);
        if (bArrC == null || bArrC.length <= 0) {
            return null;
        }
        return new String(bArrC);
    }

    private static String a(byte[] bArr) {
        return a(bArr, bArr.length);
    }

    private static String a(byte[] bArr, int i2) {
        if (i2 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i2 / 3) << 2) + 4];
            int i3 = 0;
            int i4 = 0;
            while (i2 >= 3) {
                int i5 = ((bArr[i3] & 255) << 16) + ((bArr[i3 + 1] & 255) << 8) + (bArr[i3 + 2] & 255);
                int i6 = i4 + 1;
                cArr[i4] = f10695e[i5 >> 18];
                int i7 = i6 + 1;
                cArr[i6] = f10695e[(i5 >> 12) & 63];
                int i8 = i7 + 1;
                cArr[i7] = f10695e[(i5 >> 6) & 63];
                i4 = i8 + 1;
                cArr[i8] = f10695e[i5 & 63];
                i3 += 3;
                i2 -= 3;
            }
            if (i2 == 1) {
                int i9 = bArr[i3] & 255;
                int i10 = i4 + 1;
                cArr[i4] = f10695e[i9 >> 2];
                int i11 = i10 + 1;
                cArr[i10] = f10695e[(i9 << 4) & 63];
                int i12 = i11 + 1;
                cArr[i11] = f10696f;
                i4 = i12 + 1;
                cArr[i12] = f10696f;
            } else if (i2 == 2) {
                int i13 = ((bArr[i3] & 255) << 8) + (bArr[i3 + 1] & 255);
                int i14 = i4 + 1;
                cArr[i4] = f10695e[i13 >> 10];
                int i15 = i14 + 1;
                cArr[i14] = f10695e[(i13 >> 4) & 63];
                int i16 = i15 + 1;
                cArr[i15] = f10695e[(i13 << 2) & 63];
                i4 = i16 + 1;
                cArr[i16] = f10696f;
            }
            return new String(cArr, 0, i4);
        } catch (Exception unused) {
            return null;
        }
    }
}
