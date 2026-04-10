package com.yuewen;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes5.dex */
public class ap1 implements pl {
    @Override // com.yuewen.pl
    public Bitmap a(Bitmap bitmap, float f) {
        int i;
        int i2;
        int[] iArr;
        int i3 = (int) f;
        if (i3 < 1) {
            i3 = 1;
        }
        System.currentTimeMillis();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 3);
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z = false;
        while (i13 < height) {
            int i16 = height;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = -i3;
            int i26 = 0;
            while (true) {
                i = i6;
                if (i25 > i3) {
                    break;
                }
                int[] iArr9 = iArr6;
                int i27 = iArr2[i14 + Math.min(i5, Math.max(i25, 0))];
                int[] iArr10 = iArr8[i25 + i3];
                iArr10[0] = (i27 & 16711680) >> 16;
                iArr10[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = 255 & i27;
                int iAbs = i12 - Math.abs(i25);
                int i28 = iArr10[0];
                i26 += i28 * iAbs;
                int i29 = iArr10[1];
                i17 += i29 * iAbs;
                int i30 = iArr10[2];
                i18 += iAbs * i30;
                if (i25 > 0) {
                    i22 += i28;
                    i23 += i29;
                    i24 += i30;
                } else {
                    i19 += i28;
                    i20 += i29;
                    i21 += i30;
                }
                i25++;
                i6 = i;
                iArr6 = iArr9;
            }
            int[] iArr11 = iArr6;
            int i31 = i3;
            int i32 = i26;
            int i33 = 0;
            while (i33 < width) {
                if (z) {
                    i2 = i12;
                } else {
                    i2 = i12;
                    z = Color.alpha(bitmap.getPixel(i33, i13)) != 255;
                }
                iArr3[i14] = iArr7[i32];
                iArr4[i14] = iArr7[i17];
                iArr5[i14] = iArr7[i18];
                int i34 = i32 - i19;
                int i35 = i17 - i20;
                int i36 = i18 - i21;
                int[] iArr12 = iArr8[((i31 - i3) + i7) % i7];
                int i37 = i19 - iArr12[0];
                int i38 = i20 - iArr12[1];
                int i39 = i21 - iArr12[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr11[i33] = Math.min(i33 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i40 = iArr2[i15 + iArr11[i33]];
                int i41 = (i40 & 16711680) >> 16;
                iArr12[0] = i41;
                int i42 = (i40 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i42;
                int i43 = i40 & 255;
                iArr12[2] = i43;
                int i44 = i22 + i41;
                int i45 = i23 + i42;
                int i46 = i24 + i43;
                i32 = i34 + i44;
                i17 = i35 + i45;
                i18 = i36 + i46;
                i31 = (i31 + 1) % i7;
                int[] iArr13 = iArr8[i31 % i7];
                int i47 = iArr13[0];
                i19 = i37 + i47;
                int i48 = iArr13[1];
                i20 = i38 + i48;
                int i49 = iArr13[2];
                i21 = i39 + i49;
                i22 = i44 - i47;
                i23 = i45 - i48;
                i24 = i46 - i49;
                i14++;
                i33++;
                i12 = i2;
                iArr7 = iArr;
                i5 = i5;
            }
            i15 += width;
            i13++;
            height = i16;
            i6 = i;
            iArr6 = iArr11;
        }
        int i50 = i6;
        int[] iArr14 = iArr6;
        int i51 = height;
        int[] iArr15 = iArr7;
        int i52 = i12;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i3;
            int i55 = i7;
            int[] iArr16 = iArr2;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i3) {
                int i67 = width;
                int iMax = Math.max(0, i64) + i53;
                int[] iArr17 = iArr8[i63 + i3];
                iArr17[0] = iArr3[iMax];
                iArr17[1] = iArr4[iMax];
                iArr17[2] = iArr5[iMax];
                int iAbs2 = i52 - Math.abs(i63);
                i65 += iArr3[iMax] * iAbs2;
                i66 += iArr4[iMax] * iAbs2;
                i56 += iArr5[iMax] * iAbs2;
                if (i63 > 0) {
                    i60 += iArr17[0];
                    i61 += iArr17[1];
                    i62 += iArr17[2];
                } else {
                    i57 += iArr17[0];
                    i58 += iArr17[1];
                    i59 += iArr17[2];
                }
                int i68 = i50;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i50 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i50;
            int i71 = i3;
            int i72 = i53;
            int i73 = i51;
            int i74 = 0;
            while (i74 < i73) {
                if (z) {
                    iArr16[i72] = (iArr16[i72] & (-16777216)) | (iArr15[i65] << 16) | (iArr15[i66] << 8) | iArr15[i56];
                } else {
                    iArr16[i72] = (iArr15[i65] << 16) | (-16777216) | (iArr15[i66] << 8) | iArr15[i56];
                }
                int i75 = i65 - i57;
                int i76 = i66 - i58;
                int i77 = i56 - i59;
                int[] iArr18 = iArr8[((i71 - i3) + i55) % i55];
                int i78 = i57 - iArr18[0];
                int i79 = i58 - iArr18[1];
                int i80 = i59 - iArr18[2];
                int i81 = i3;
                if (i53 == 0) {
                    iArr14[i74] = Math.min(i74 + i52, i70) * i69;
                }
                int i82 = iArr14[i74] + i53;
                int i83 = iArr3[i82];
                iArr18[0] = i83;
                int i84 = iArr4[i82];
                iArr18[1] = i84;
                int i85 = iArr5[i82];
                iArr18[2] = i85;
                int i86 = i60 + i83;
                int i87 = i61 + i84;
                int i88 = i62 + i85;
                i65 = i75 + i86;
                i66 = i76 + i87;
                i56 = i77 + i88;
                i71 = (i71 + 1) % i55;
                int[] iArr19 = iArr8[i71];
                int i89 = iArr19[0];
                i57 = i78 + i89;
                int i90 = iArr19[1];
                i58 = i79 + i90;
                int i91 = iArr19[2];
                i59 = i80 + i91;
                i60 = i86 - i89;
                i61 = i87 - i90;
                i62 = i88 - i91;
                i72 += i69;
                i74++;
                i3 = i81;
            }
            i53++;
            i50 = i70;
            i51 = i73;
            i7 = i55;
            iArr2 = iArr16;
            width = i69;
        }
        return com.duokan.core.utils.a.f(iArr2, width, i51, bitmap.getConfig());
    }
}
