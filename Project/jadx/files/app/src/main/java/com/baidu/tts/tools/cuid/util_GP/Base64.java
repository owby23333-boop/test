package com.baidu.tts.tools.cuid.util_GP;

import androidx.core.view.MotionEventCompat;
import com.umeng.analytics.pro.cb;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[length + (length / 76) + 3];
        int length2 = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length2; i4 += 3) {
            int i5 = i2 + 1;
            byte[] bArr3 = MAP;
            bArr2[i2] = bArr3[(bArr[i4] & 255) >> 2];
            int i6 = i5 + 1;
            int i7 = i4 + 1;
            bArr2[i5] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] & 255) >> 4)];
            int i8 = i6 + 1;
            int i9 = i4 + 2;
            bArr2[i6] = bArr3[((bArr[i7] & cb.f19604m) << 2) | ((bArr[i9] & 255) >> 6)];
            i2 = i8 + 1;
            bArr2[i8] = bArr3[bArr[i9] & Utf8.REPLACEMENT_BYTE];
            if ((i2 - i3) % 76 == 0 && i2 != 0) {
                bArr2[i2] = 10;
                i3++;
                i2++;
            }
        }
        int length3 = bArr.length % 3;
        if (length3 == 1) {
            int i10 = i2 + 1;
            byte[] bArr4 = MAP;
            bArr2[i2] = bArr4[(bArr[length2] & 255) >> 2];
            int i11 = i10 + 1;
            bArr2[i10] = bArr4[(bArr[length2] & 3) << 4];
            int i12 = i11 + 1;
            bArr2[i11] = 61;
            i2 = i12 + 1;
            bArr2[i12] = 61;
        } else if (length3 == 2) {
            int i13 = i2 + 1;
            byte[] bArr5 = MAP;
            bArr2[i2] = bArr5[(bArr[length2] & 255) >> 2];
            int i14 = i13 + 1;
            int i15 = (bArr[length2] & 3) << 4;
            int i16 = length2 + 1;
            bArr2[i13] = bArr5[((bArr[i16] & 255) >> 4) | i15];
            int i17 = i14 + 1;
            bArr2[i14] = bArr5[(bArr[i16] & cb.f19604m) << 2];
            i2 = i17 + 1;
            bArr2[i17] = 61;
        }
        return new String(bArr2, 0, i2, str);
    }

    public static byte[] decode(byte[] bArr, int i2) {
        byte b;
        int i3;
        int i4;
        int i5 = (i2 / 4) * 3;
        if (i5 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i5];
        int i6 = i2;
        int i7 = 0;
        while (true) {
            byte b2 = bArr[i6 - 1];
            b = 10;
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                if (b2 != 61) {
                    break;
                }
                i7++;
            }
            i6--;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 < i6) {
            byte b3 = bArr[i8];
            if (b3 != b && b3 != 13 && b3 != 32 && b3 != 9) {
                if (b3 >= 65 && b3 <= 90) {
                    i3 = b3 - 65;
                } else if (b3 >= 97 && b3 <= 122) {
                    i3 = b3 - 71;
                } else if (b3 >= 48 && b3 <= 57) {
                    i3 = b3 + 4;
                } else if (b3 == 43) {
                    i3 = 62;
                } else {
                    if (b3 != 47) {
                        return null;
                    }
                    i3 = 63;
                }
                int i12 = (i9 << 6) | ((byte) i3);
                if (i11 % 4 == 3) {
                    int i13 = i10 + 1;
                    bArr2[i10] = (byte) ((16711680 & i12) >> 16);
                    int i14 = i13 + 1;
                    bArr2[i13] = (byte) ((65280 & i12) >> 8);
                    i4 = i14 + 1;
                    bArr2[i14] = (byte) (i12 & 255);
                } else {
                    i4 = i10;
                }
                i11++;
                i10 = i4;
                i9 = i12;
            }
            i8++;
            b = 10;
        }
        if (i7 > 0) {
            int i15 = i9 << (i7 * 6);
            int i16 = i10 + 1;
            bArr2[i10] = (byte) ((i15 & 16711680) >> 16);
            if (i7 == 1) {
                i10 = i16 + 1;
                bArr2[i16] = (byte) ((i15 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
            } else {
                i10 = i16;
            }
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(bArr2, 0, bArr3, 0, i10);
        return bArr3;
    }
}
