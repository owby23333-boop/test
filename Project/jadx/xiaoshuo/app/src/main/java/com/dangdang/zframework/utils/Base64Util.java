package com.dangdang.zframework.utils;

import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes10.dex */
public class Base64Util {
    private static final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] decodingTable = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            decodingTable[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            decodingTable[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            decodingTable[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            decodingTable[i4] = (byte) ((i4 - 48) + 52);
        }
        byte[] bArr = decodingTable;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
    }

    public static byte[] decode(byte[] bArr) {
        byte[] bArrDiscardNonBase64Bytes = discardNonBase64Bytes(bArr);
        byte[] bArr2 = bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length + (-2)] == 61 ? new byte[(((bArrDiscardNonBase64Bytes.length / 4) - 1) * 3) + 1] : bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length + (-1)] == 61 ? new byte[(((bArrDiscardNonBase64Bytes.length / 4) - 1) * 3) + 2] : new byte[(bArrDiscardNonBase64Bytes.length / 4) * 3];
        int i = 0;
        int i2 = 0;
        while (i < bArrDiscardNonBase64Bytes.length - 4) {
            byte[] bArr3 = decodingTable;
            byte b2 = bArr3[bArrDiscardNonBase64Bytes[i]];
            byte b3 = bArr3[bArrDiscardNonBase64Bytes[i + 1]];
            byte b4 = bArr3[bArrDiscardNonBase64Bytes[i + 2]];
            byte b5 = bArr3[bArrDiscardNonBase64Bytes[i + 3]];
            bArr2[i2] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr2[i2 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
            bArr2[i2 + 2] = (byte) (b5 | (b4 << 6));
            i += 4;
            i2 += 3;
        }
        if (bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 2] == 61) {
            byte[] bArr4 = decodingTable;
            bArr2[bArr2.length - 1] = (byte) ((bArr4[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 3]] >> 4) | (bArr4[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 4]] << 2));
        } else if (bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 1] == 61) {
            byte[] bArr5 = decodingTable;
            byte b6 = bArr5[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 4]];
            byte b7 = bArr5[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 3]];
            byte b8 = bArr5[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 2]];
            bArr2[bArr2.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr2[bArr2.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
        } else {
            byte[] bArr6 = decodingTable;
            byte b9 = bArr6[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 4]];
            byte b10 = bArr6[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 3]];
            byte b11 = bArr6[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 2]];
            byte b12 = bArr6[bArrDiscardNonBase64Bytes[bArrDiscardNonBase64Bytes.length - 1]];
            bArr2[bArr2.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
            bArr2[bArr2.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
            bArr2[bArr2.length - 1] = (byte) (b12 | (b11 << 6));
        }
        return bArr2;
    }

    private static byte[] discardNonBase64Bytes(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (isValidBase64Byte(bArr[i2])) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }

    private static String discardNonBase64Chars(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isValidBase64Byte((byte) str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] encode(byte[] bArr) {
        int length = bArr.length % 3;
        byte[] bArr2 = length == 0 ? new byte[(bArr.length * 4) / 3] : new byte[((bArr.length / 3) + 1) * 4];
        int length2 = bArr.length - length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3 = bArr[i] & 255;
            int i4 = bArr[i + 1] & 255;
            int i5 = bArr[i + 2] & 255;
            byte[] bArr3 = encodingTable;
            bArr2[i2] = bArr3[(i3 >>> 2) & 63];
            bArr2[i2 + 1] = bArr3[((i3 << 4) | (i4 >>> 4)) & 63];
            bArr2[i2 + 2] = bArr3[((i4 << 2) | (i5 >>> 6)) & 63];
            bArr2[i2 + 3] = bArr3[i5 & 63];
            i += 3;
            i2 += 4;
        }
        if (length == 1) {
            int i6 = bArr[bArr.length - 1] & 255;
            int length3 = bArr2.length - 4;
            byte[] bArr4 = encodingTable;
            bArr2[length3] = bArr4[(i6 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr4[(i6 << 4) & 63];
            bArr2[bArr2.length - 2] = Base64.padSymbol;
            bArr2[bArr2.length - 1] = Base64.padSymbol;
        } else if (length == 2) {
            int i7 = bArr[bArr.length - 2] & 255;
            int i8 = bArr[bArr.length - 1] & 255;
            int length4 = bArr2.length - 4;
            byte[] bArr5 = encodingTable;
            bArr2[length4] = bArr5[(i7 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr5[((i7 << 4) | (i8 >>> 4)) & 63];
            bArr2[bArr2.length - 2] = bArr5[(i8 << 2) & 63];
            bArr2[bArr2.length - 1] = Base64.padSymbol;
        }
        return bArr2;
    }

    private static boolean isValidBase64Byte(byte b2) {
        if (b2 == 61) {
            return true;
        }
        return b2 >= 0 && b2 < 128 && decodingTable[b2] != -1;
    }

    public static byte[] decode(String str) {
        byte[] bArr;
        String strDiscardNonBase64Chars = discardNonBase64Chars(str);
        if (strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 2) == '=') {
            bArr = new byte[(((strDiscardNonBase64Chars.length() / 4) - 1) * 3) + 1];
        } else if (strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 1) == '=') {
            bArr = new byte[(((strDiscardNonBase64Chars.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(strDiscardNonBase64Chars.length() / 4) * 3];
        }
        int i = 0;
        int i2 = 0;
        while (i < strDiscardNonBase64Chars.length() - 4) {
            byte[] bArr2 = decodingTable;
            byte b2 = bArr2[strDiscardNonBase64Chars.charAt(i)];
            byte b3 = bArr2[strDiscardNonBase64Chars.charAt(i + 1)];
            byte b4 = bArr2[strDiscardNonBase64Chars.charAt(i + 2)];
            byte b5 = bArr2[strDiscardNonBase64Chars.charAt(i + 3)];
            bArr[i2] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr[i2 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
            bArr[i2 + 2] = (byte) (b5 | (b4 << 6));
            i += 4;
            i2 += 3;
        }
        if (strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 2) == '=') {
            byte[] bArr3 = decodingTable;
            bArr[bArr.length - 1] = (byte) ((bArr3[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 3)] >> 4) | (bArr3[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 4)] << 2));
        } else if (strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 1) == '=') {
            byte[] bArr4 = decodingTable;
            byte b6 = bArr4[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 4)];
            byte b7 = bArr4[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 3)];
            byte b8 = bArr4[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[bArr.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
        } else {
            byte[] bArr5 = decodingTable;
            byte b9 = bArr5[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 4)];
            byte b10 = bArr5[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 3)];
            byte b11 = bArr5[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 2)];
            byte b12 = bArr5[strDiscardNonBase64Chars.charAt(strDiscardNonBase64Chars.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
            bArr[bArr.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
            bArr[bArr.length - 1] = (byte) (b12 | (b11 << 6));
        }
        return bArr;
    }
}
