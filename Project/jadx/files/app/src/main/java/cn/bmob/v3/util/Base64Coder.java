package cn.bmob.v3.util;

import com.umeng.analytics.pro.cb;

/* JADX INFO: loaded from: classes.dex */
public class Base64Coder {
    private static final byte[] map2;
    private static final String systemLineSeparator = System.getProperty("line.separator");
    private static final char[] map1 = new char[64];

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            map1[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            map1[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            map1[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = map1;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        map2 = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = map2;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            map2[map1[i4]] = (byte) i4;
        }
    }

    private Base64Coder() {
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static byte[] decodeLines(String str) {
        char[] cArr = new char[str.length()];
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != ' ' && cCharAt != '\r' && cCharAt != '\n' && cCharAt != '\t') {
                cArr[i2] = cCharAt;
                i2++;
            }
        }
        return decode(cArr, 0, i2);
    }

    public static String decodeString(String str) {
        return new String(decode(str));
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static String encodeLines(byte[] bArr) {
        return encodeLines(bArr, 0, bArr.length, 76, systemLineSeparator);
    }

    public static String encodeString(String str) {
        return new String(encode(str.getBytes()));
    }

    public static byte[] decode(char[] cArr) {
        return decode(cArr, 0, cArr.length);
    }

    public static char[] encode(byte[] bArr, int i2) {
        return encode(bArr, 0, i2);
    }

    public static String encodeLines(byte[] bArr, int i2, int i3, int i4, String str) {
        int i5 = (i4 * 3) / 4;
        if (i5 <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder((((i3 + 2) / 3) * 4) + ((((i3 + i5) - 1) / i5) * str.length()));
        int i6 = 0;
        while (i6 < i3) {
            int iMin = Math.min(i3 - i6, i5);
            sb.append(encode(bArr, i2 + i6, iMin));
            sb.append(str);
            i6 += iMin;
        }
        return sb.toString();
    }

    public static byte[] decode(char[] cArr, int i2, int i3) {
        int i4;
        char c2;
        int i5;
        if (i3 % 4 == 0) {
            while (i3 > 0 && cArr[(i2 + i3) - 1] == '=') {
                i3--;
            }
            int i6 = (i3 * 3) / 4;
            byte[] bArr = new byte[i6];
            int i7 = i3 + i2;
            int i8 = 0;
            while (i2 < i7) {
                int i9 = i2 + 1;
                char c3 = cArr[i2];
                int i10 = i9 + 1;
                char c4 = cArr[i9];
                char c5 = 'A';
                if (i10 < i7) {
                    i4 = i10 + 1;
                    c2 = cArr[i10];
                } else {
                    i4 = i10;
                    c2 = 'A';
                }
                if (i4 < i7) {
                    int i11 = i4 + 1;
                    char c6 = cArr[i4];
                    i4 = i11;
                    c5 = c6;
                }
                if (c3 <= 127 && c4 <= 127 && c2 <= 127 && c5 <= 127) {
                    byte[] bArr2 = map2;
                    byte b = bArr2[c3];
                    byte b2 = bArr2[c4];
                    byte b3 = bArr2[c2];
                    byte b4 = bArr2[c5];
                    if (b >= 0 && b2 >= 0 && b3 >= 0 && b4 >= 0) {
                        int i12 = (b << 2) | (b2 >>> 4);
                        int i13 = ((b2 & cb.f19604m) << 4) | (b3 >>> 2);
                        int i14 = ((b3 & 3) << 6) | b4;
                        int i15 = i8 + 1;
                        bArr[i8] = (byte) i12;
                        if (i15 < i6) {
                            i5 = i15 + 1;
                            bArr[i15] = (byte) i13;
                        } else {
                            i5 = i15;
                        }
                        if (i5 < i6) {
                            i8 = i5 + 1;
                            bArr[i5] = (byte) i14;
                        } else {
                            i8 = i5;
                        }
                        i2 = i4;
                    } else {
                        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                    }
                } else {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] encode(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = ((i3 * 4) + 2) / 3;
        char[] cArr = new char[((i3 + 2) / 3) * 4];
        int i9 = i3 + i2;
        int i10 = 0;
        while (i2 < i9) {
            int i11 = i2 + 1;
            int i12 = bArr[i2] & 255;
            if (i11 < i9) {
                i4 = i11 + 1;
                i5 = bArr[i11] & 255;
            } else {
                i4 = i11;
                i5 = 0;
            }
            if (i4 < i9) {
                i6 = i4 + 1;
                i7 = bArr[i4] & 255;
            } else {
                i6 = i4;
                i7 = 0;
            }
            int i13 = i12 >>> 2;
            int i14 = ((i12 & 3) << 4) | (i5 >>> 4);
            int i15 = ((i5 & 15) << 2) | (i7 >>> 6);
            int i16 = i7 & 63;
            int i17 = i10 + 1;
            char[] cArr2 = map1;
            cArr[i10] = cArr2[i13];
            int i18 = i17 + 1;
            cArr[i17] = cArr2[i14];
            char c2 = '=';
            cArr[i18] = i18 < i8 ? cArr2[i15] : '=';
            int i19 = i18 + 1;
            if (i19 < i8) {
                c2 = map1[i16];
            }
            cArr[i19] = c2;
            i10 = i19 + 1;
            i2 = i6;
        }
        return cArr;
    }
}
