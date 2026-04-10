package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i2, boolean z2) {
        Bitmap bitmap2;
        int[] iArr;
        int i3;
        int i4;
        int[] iArr2;
        int i5 = i2;
        Bitmap bitmapCopy = z2 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i5 <= 0) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i6 = width * height;
        int[] iArr3 = new int[i6];
        bitmapCopy.getPixels(iArr3, 0, width, 0, 0, width, height);
        int i7 = width - 1;
        int i8 = height - 1;
        int i9 = i5 + i5 + 1;
        int[] iArr4 = new int[i6];
        int[] iArr5 = new int[i6];
        int[] iArr6 = new int[i6];
        int[] iArr7 = new int[Math.max(width, height)];
        int i10 = (i9 + 1) >> 1;
        int i11 = i10 * i10;
        int i12 = i11 * 256;
        int[] iArr8 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr8[i13] = i13 / i11;
        }
        int[][] iArr9 = (int[][]) Array.newInstance((Class<?>) int.class, i9, 3);
        int i14 = i5 + 1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            bitmap2 = bitmapCopy;
            if (i15 >= height) {
                break;
            }
            int i18 = -i5;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            while (true) {
                i3 = i8;
                i4 = height;
                if (i18 > i5) {
                    break;
                }
                int i28 = iArr3[i16 + Math.min(i7, Math.max(i18, 0))];
                int[] iArr10 = iArr9[i18 + i5];
                iArr10[0] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i28 & 255;
                int iAbs = i14 - Math.abs(i18);
                i19 += iArr10[0] * iAbs;
                i20 += iArr10[1] * iAbs;
                i21 += iArr10[2] * iAbs;
                if (i18 > 0) {
                    i25 += iArr10[0];
                    i26 += iArr10[1];
                    i27 += iArr10[2];
                } else {
                    i22 += iArr10[0];
                    i23 += iArr10[1];
                    i24 += iArr10[2];
                }
                i18++;
                height = i4;
                i8 = i3;
            }
            int i29 = i5;
            int i30 = 0;
            while (i30 < width) {
                iArr4[i16] = iArr8[i19];
                iArr5[i16] = iArr8[i20];
                iArr6[i16] = iArr8[i21];
                int i31 = i19 - i22;
                int i32 = i20 - i23;
                int i33 = i21 - i24;
                int[] iArr11 = iArr9[((i29 - i5) + i9) % i9];
                int i34 = i22 - iArr11[0];
                int i35 = i23 - iArr11[1];
                int i36 = i24 - iArr11[2];
                if (i15 == 0) {
                    iArr2 = iArr8;
                    iArr7[i30] = Math.min(i30 + i5 + 1, i7);
                } else {
                    iArr2 = iArr8;
                }
                int i37 = iArr3[i17 + iArr7[i30]];
                iArr11[0] = (i37 & 16711680) >> 16;
                iArr11[1] = (i37 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i37 & 255;
                int i38 = i25 + iArr11[0];
                int i39 = i26 + iArr11[1];
                int i40 = i27 + iArr11[2];
                i19 = i31 + i38;
                i20 = i32 + i39;
                i21 = i33 + i40;
                i29 = (i29 + 1) % i9;
                int[] iArr12 = iArr9[i29 % i9];
                i22 = i34 + iArr12[0];
                i23 = i35 + iArr12[1];
                i24 = i36 + iArr12[2];
                i25 = i38 - iArr12[0];
                i26 = i39 - iArr12[1];
                i27 = i40 - iArr12[2];
                i16++;
                i30++;
                iArr8 = iArr2;
            }
            i17 += width;
            i15++;
            bitmapCopy = bitmap2;
            height = i4;
            i8 = i3;
        }
        int i41 = i8;
        int i42 = height;
        int[] iArr13 = iArr8;
        int i43 = 0;
        while (i43 < width) {
            int i44 = -i5;
            int i45 = i44 * width;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            while (true) {
                iArr = iArr7;
                if (i44 > i5) {
                    break;
                }
                int iMax = Math.max(0, i45) + i43;
                int[] iArr14 = iArr9[i44 + i5];
                iArr14[0] = iArr4[iMax];
                iArr14[1] = iArr5[iMax];
                iArr14[2] = iArr6[iMax];
                int iAbs2 = i14 - Math.abs(i44);
                i46 += iArr4[iMax] * iAbs2;
                i47 += iArr5[iMax] * iAbs2;
                i48 += iArr6[iMax] * iAbs2;
                if (i44 > 0) {
                    i52 += iArr14[0];
                    i53 += iArr14[1];
                    i54 += iArr14[2];
                } else {
                    i49 += iArr14[0];
                    i50 += iArr14[1];
                    i51 += iArr14[2];
                }
                int i55 = i41;
                if (i44 < i55) {
                    i45 += width;
                }
                i44++;
                i41 = i55;
                iArr7 = iArr;
            }
            int i56 = i41;
            int i57 = i43;
            int i58 = i53;
            int i59 = i54;
            int i60 = 0;
            int i61 = i5;
            int i62 = i52;
            int i63 = i51;
            int i64 = i50;
            int i65 = i49;
            int i66 = i48;
            int i67 = i47;
            int i68 = i46;
            int i69 = i42;
            while (i60 < i69) {
                iArr3[i57] = (iArr3[i57] & (-16777216)) | (iArr13[i68] << 16) | (iArr13[i67] << 8) | iArr13[i66];
                int i70 = i68 - i65;
                int i71 = i67 - i64;
                int i72 = i66 - i63;
                int[] iArr15 = iArr9[((i61 - i5) + i9) % i9];
                int i73 = i65 - iArr15[0];
                int i74 = i64 - iArr15[1];
                int i75 = i63 - iArr15[2];
                if (i43 == 0) {
                    iArr[i60] = Math.min(i60 + i14, i56) * width;
                }
                int i76 = iArr[i60] + i43;
                iArr15[0] = iArr4[i76];
                iArr15[1] = iArr5[i76];
                iArr15[2] = iArr6[i76];
                int i77 = i62 + iArr15[0];
                int i78 = i58 + iArr15[1];
                int i79 = i59 + iArr15[2];
                i68 = i70 + i77;
                i67 = i71 + i78;
                i66 = i72 + i79;
                i61 = (i61 + 1) % i9;
                int[] iArr16 = iArr9[i61];
                i65 = i73 + iArr16[0];
                i64 = i74 + iArr16[1];
                i63 = i75 + iArr16[2];
                i62 = i77 - iArr16[0];
                i58 = i78 - iArr16[1];
                i59 = i79 - iArr16[2];
                i57 += width;
                i60++;
                i5 = i2;
            }
            i43++;
            i5 = i2;
            i41 = i56;
            i42 = i69;
            iArr7 = iArr;
        }
        bitmap2.setPixels(iArr3, 0, width, 0, 0, width, i42);
        return bitmap2;
    }
}
