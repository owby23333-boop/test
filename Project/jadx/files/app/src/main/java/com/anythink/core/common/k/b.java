package com.anythink.core.common.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.core.view.MotionEventCompat;
import java.io.FileDescriptor;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static int[] a(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new int[]{options.outWidth, options.outHeight};
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private static Bitmap a(String str, int i2, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = a(options.outWidth, options.outHeight, i2, i3);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i2, int i3) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            options.inSampleSize = a(options.outWidth, options.outHeight, i2, i3);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static int a(int i2, int i3, int i4, int i5) {
        int i6 = 1;
        if (i4 <= 0 && i5 <= 0) {
            return 1;
        }
        while (i2 / i6 > i4 && i3 / i6 > i5) {
            i6 *= 2;
        }
        return i6;
    }

    public static Bitmap a(Context context, Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            com.anythink.core.common.j.c.a("Error", "Error, cannot access an invalid/free'd bitmap here!", com.anythink.core.common.b.n.a().r());
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth() / 3, bitmap.getHeight() / 3, Bitmap.Config.ARGB_8888);
            if (Build.VERSION.SDK_INT >= 17) {
                RenderScript renderScriptCreate = RenderScript.create(context);
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
                Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                scriptIntrinsicBlurCreate.setRadius(25.0f);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                new Canvas(bitmapCreateBitmap).drawColor(855638016);
                renderScriptCreate.destroy();
                return bitmapCreateBitmap;
            }
            return a(bitmapCreateBitmap);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static Bitmap a(Bitmap bitmap) {
        int[] iArr;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[Math.max(width, height)];
        int[] iArr7 = new int[173056];
        for (int i5 = 0; i5 < 173056; i5++) {
            iArr7[i5] = i5 / 676;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, 51, 3);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i6 >= height) {
                break;
            }
            int i9 = -25;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 25; i9 <= i19; i19 = 25) {
                int i20 = height;
                int i21 = iArr2[Math.min(i3, Math.max(i9, 0)) + i7];
                int[] iArr9 = iArr8[i9 + 25];
                iArr9[0] = (i21 & 16711680) >> 16;
                iArr9[1] = (i21 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i21 & 255;
                int iAbs = 26 - Math.abs(i9);
                i10 += iArr9[0] * iAbs;
                i11 += iArr9[1] * iAbs;
                i12 += iArr9[2] * iAbs;
                if (i9 > 0) {
                    i16 += iArr9[0];
                    i17 += iArr9[1];
                    i18 += iArr9[2];
                } else {
                    i13 += iArr9[0];
                    i14 += iArr9[1];
                    i15 += iArr9[2];
                }
                i9++;
                height = i20;
            }
            int i22 = height;
            int i23 = 25;
            for (int i24 = 0; i24 < width; i24++) {
                iArr3[i7] = iArr7[i10];
                iArr4[i7] = iArr7[i11];
                iArr5[i7] = iArr7[i12];
                int i25 = i10 - i13;
                int i26 = i11 - i14;
                int i27 = i12 - i15;
                int[] iArr10 = iArr8[((i23 - 25) + 51) % 51];
                int i28 = i13 - iArr10[0];
                int i29 = i14 - iArr10[1];
                int i30 = i15 - iArr10[2];
                if (i6 == 0) {
                    iArr6[i24] = Math.min(i24 + 25 + 1, i3);
                }
                int i31 = iArr2[iArr6[i24] + i8];
                iArr10[0] = (i31 & 16711680) >> 16;
                iArr10[1] = (i31 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i31 & 255;
                int i32 = i16 + iArr10[0];
                int i33 = i17 + iArr10[1];
                int i34 = i18 + iArr10[2];
                i10 = i25 + i32;
                i11 = i26 + i33;
                i12 = i27 + i34;
                i23 = (i23 + 1) % 51;
                int[] iArr11 = iArr8[i23 % 51];
                i13 = i28 + iArr11[0];
                i14 = i29 + iArr11[1];
                i15 = i30 + iArr11[2];
                i16 = i32 - iArr11[0];
                i17 = i33 - iArr11[1];
                i18 = i34 - iArr11[2];
                i7++;
            }
            i8 += width;
            i6++;
            height = i22;
        }
        int i35 = height;
        int i36 = 0;
        while (i36 < width) {
            int[] iArr12 = iArr6;
            int i37 = width * (-25);
            int i38 = -25;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            for (int i48 = 25; i38 <= i48; i48 = 25) {
                int iMax = Math.max(0, i37) + i36;
                int[] iArr13 = iArr8[i38 + 25];
                iArr13[0] = iArr3[iMax];
                iArr13[1] = iArr4[iMax];
                iArr13[2] = iArr5[iMax];
                int iAbs2 = 26 - Math.abs(i38);
                i39 += iArr3[iMax] * iAbs2;
                i40 += iArr4[iMax] * iAbs2;
                i41 += iArr5[iMax] * iAbs2;
                if (i38 > 0) {
                    i45 += iArr13[0];
                    i46 += iArr13[1];
                    i47 += iArr13[2];
                } else {
                    i42 += iArr13[0];
                    i43 += iArr13[1];
                    i44 += iArr13[2];
                }
                if (i38 < i4) {
                    i37 += width;
                }
                i38++;
            }
            int i49 = i36;
            int i50 = i47;
            int i51 = i35;
            int i52 = 0;
            int i53 = i46;
            int i54 = i45;
            int i55 = 25;
            while (i52 < i51) {
                iArr2[i49] = (iArr2[i49] & (-16777216)) | (iArr7[i39] << 16) | (iArr7[i40] << 8) | iArr7[i41];
                int i56 = i39 - i42;
                int i57 = i40 - i43;
                int i58 = i41 - i44;
                int[] iArr14 = iArr8[((i55 - 25) + 51) % 51];
                int i59 = i42 - iArr14[0];
                int i60 = i43 - iArr14[1];
                int i61 = i44 - iArr14[2];
                if (i36 == 0) {
                    iArr = iArr7;
                    iArr12[i52] = Math.min(i52 + 26, i4) * width;
                } else {
                    iArr = iArr7;
                }
                int i62 = iArr12[i52] + i36;
                iArr14[0] = iArr3[i62];
                iArr14[1] = iArr4[i62];
                iArr14[2] = iArr5[i62];
                int i63 = i54 + iArr14[0];
                int i64 = i53 + iArr14[1];
                int i65 = i50 + iArr14[2];
                i39 = i56 + i63;
                i40 = i57 + i64;
                i41 = i58 + i65;
                i55 = (i55 + 1) % 51;
                int[] iArr15 = iArr8[i55];
                i42 = i59 + iArr15[0];
                i43 = i60 + iArr15[1];
                i44 = i61 + iArr15[2];
                i54 = i63 - iArr15[0];
                i53 = i64 - iArr15[1];
                i50 = i65 - iArr15[2];
                i49 += width;
                i52++;
                iArr7 = iArr;
            }
            i36++;
            i35 = i51;
            iArr6 = iArr12;
            iArr7 = iArr7;
        }
        bitmap.setPixels(iArr2, 0, width, 0, 0, width, i35);
        return bitmap;
    }
}
