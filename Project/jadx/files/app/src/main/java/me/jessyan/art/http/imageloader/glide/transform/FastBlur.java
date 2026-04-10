package me.jessyan.art.http.imageloader.glide.transform;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class FastBlur {
    private FastBlur() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static void blur(Context context, Bitmap bitmap, View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bitmap reSizeBitmap = DrawableProvider.getReSizeBitmap(bitmap, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (view.getMeasuredWidth() / 8.0f), (int) (view.getMeasuredHeight() / 8.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.translate((-view.getLeft()) / 8.0f, (-view.getTop()) / 8.0f);
        canvas.scale(0.125f, 0.125f);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(reSizeBitmap, 0.0f, 0.0f, paint);
        view.setBackgroundDrawable(new BitmapDrawable(context.getResources(), doBlur(bitmapCreateBitmap, (int) 15.0f, true)));
        String str = "cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms";
    }

    public static Bitmap blurBitmap(Bitmap bitmap, int i2, int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        float f2 = i2;
        float f3 = i3;
        Bitmap reSizeBitmap = DrawableProvider.getReSizeBitmap(bitmap, f2, f3);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (f2 / 8.0f), (int) (f3 / 8.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(0.125f, 0.125f);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(reSizeBitmap, 0.0f, 0.0f, paint);
        Bitmap bitmapDoBlur = doBlur(bitmapCreateBitmap, (int) 15.0f, true);
        String str = "cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms";
        return bitmapDoBlur;
    }

    public static Bitmap doBlur(Bitmap bitmap, int i2, boolean z2) {
        int[] iArr;
        int i3 = i2;
        Bitmap bitmapCopy = z2 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i3 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
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
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i7, 3);
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i16 = -i3;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i16 <= i3) {
                int i26 = i6;
                int i27 = height;
                int i28 = iArr2[i14 + Math.min(i5, Math.max(i16, 0))];
                int[] iArr9 = iArr8[i16 + i3];
                iArr9[0] = (i28 & 16711680) >> 16;
                iArr9[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i28 & 255;
                int iAbs = i12 - Math.abs(i16);
                i17 += iArr9[0] * iAbs;
                i18 += iArr9[1] * iAbs;
                i19 += iArr9[2] * iAbs;
                if (i16 > 0) {
                    i23 += iArr9[0];
                    i24 += iArr9[1];
                    i25 += iArr9[2];
                } else {
                    i20 += iArr9[0];
                    i21 += iArr9[1];
                    i22 += iArr9[2];
                }
                i16++;
                height = i27;
                i6 = i26;
            }
            int i29 = i6;
            int i30 = height;
            int i31 = i3;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i17];
                iArr4[i14] = iArr7[i18];
                iArr5[i14] = iArr7[i19];
                int i33 = i17 - i20;
                int i34 = i18 - i21;
                int i35 = i19 - i22;
                int[] iArr10 = iArr8[((i31 - i3) + i7) % i7];
                int i36 = i20 - iArr10[0];
                int i37 = i21 - iArr10[1];
                int i38 = i22 - iArr10[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr6[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr6[i32]];
                iArr10[0] = (i39 & 16711680) >> 16;
                iArr10[1] = (i39 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i39 & 255;
                int i40 = i23 + iArr10[0];
                int i41 = i24 + iArr10[1];
                int i42 = i25 + iArr10[2];
                i17 = i33 + i40;
                i18 = i34 + i41;
                i19 = i35 + i42;
                i31 = (i31 + 1) % i7;
                int[] iArr11 = iArr8[i31 % i7];
                i20 = i36 + iArr11[0];
                i21 = i37 + iArr11[1];
                i22 = i38 + iArr11[2];
                i23 = i40 - iArr11[0];
                i24 = i41 - iArr11[1];
                i25 = i42 - iArr11[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            bitmapCopy = bitmap2;
            height = i30;
            i6 = i29;
        }
        Bitmap bitmap3 = bitmapCopy;
        int i43 = i6;
        int i44 = height;
        int[] iArr12 = iArr7;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i46 * width;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            while (i46 <= i3) {
                int[] iArr13 = iArr6;
                int iMax = Math.max(0, i47) + i45;
                int[] iArr14 = iArr8[i46 + i3];
                iArr14[0] = iArr3[iMax];
                iArr14[1] = iArr4[iMax];
                iArr14[2] = iArr5[iMax];
                int iAbs2 = i12 - Math.abs(i46);
                i48 += iArr3[iMax] * iAbs2;
                i49 += iArr4[iMax] * iAbs2;
                i50 += iArr5[iMax] * iAbs2;
                if (i46 > 0) {
                    i54 += iArr14[0];
                    i55 += iArr14[1];
                    i56 += iArr14[2];
                } else {
                    i51 += iArr14[0];
                    i52 += iArr14[1];
                    i53 += iArr14[2];
                }
                int i57 = i43;
                if (i46 < i57) {
                    i47 += width;
                }
                i46++;
                i43 = i57;
                iArr6 = iArr13;
            }
            int[] iArr15 = iArr6;
            int i58 = i43;
            int i59 = i45;
            int i60 = i55;
            int i61 = i56;
            int i62 = 0;
            int i63 = i3;
            int i64 = i54;
            int i65 = i53;
            int i66 = i52;
            int i67 = i51;
            int i68 = i50;
            int i69 = i49;
            int i70 = i48;
            int i71 = i44;
            while (i62 < i71) {
                iArr2[i59] = (iArr2[i59] & (-16777216)) | (iArr12[i70] << 16) | (iArr12[i69] << 8) | iArr12[i68];
                int i72 = i70 - i67;
                int i73 = i69 - i66;
                int i74 = i68 - i65;
                int[] iArr16 = iArr8[((i63 - i3) + i7) % i7];
                int i75 = i67 - iArr16[0];
                int i76 = i66 - iArr16[1];
                int i77 = i65 - iArr16[2];
                if (i45 == 0) {
                    iArr15[i62] = Math.min(i62 + i12, i58) * width;
                }
                int i78 = iArr15[i62] + i45;
                iArr16[0] = iArr3[i78];
                iArr16[1] = iArr4[i78];
                iArr16[2] = iArr5[i78];
                int i79 = i64 + iArr16[0];
                int i80 = i60 + iArr16[1];
                int i81 = i61 + iArr16[2];
                i70 = i72 + i79;
                i69 = i73 + i80;
                i68 = i74 + i81;
                i63 = (i63 + 1) % i7;
                int[] iArr17 = iArr8[i63];
                i67 = i75 + iArr17[0];
                i66 = i76 + iArr17[1];
                i65 = i77 + iArr17[2];
                i64 = i79 - iArr17[0];
                i60 = i80 - iArr17[1];
                i61 = i81 - iArr17[2];
                i59 += width;
                i62++;
                i3 = i2;
            }
            i45++;
            i3 = i2;
            i43 = i58;
            i44 = i71;
            iArr6 = iArr15;
        }
        bitmap3.setPixels(iArr2, 0, width, 0, 0, width, i44);
        return bitmap3;
    }
}
