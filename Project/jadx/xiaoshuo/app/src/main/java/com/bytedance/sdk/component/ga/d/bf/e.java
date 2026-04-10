package com.bytedance.sdk.component.ga.d.bf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private final Bitmap.Config d;
    private final int ga;
    private final int tg;
    private final ImageView.ScaleType vn;
    public static final ImageView.ScaleType e = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config bf = Bitmap.Config.ARGB_4444;

    public e(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config) {
        this.d = config;
        this.tg = i;
        this.ga = i2;
        this.vn = scaleType;
    }

    public static int e(int i, int i2, int i3, int i4) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int e(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public Bitmap e(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.tg == 0 && this.ga == 0) {
            options.inPreferredConfig = this.d;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        int iE = e(this.tg, this.ga, i, i2, this.vn);
        int iE2 = e(this.ga, this.tg, i2, i, this.vn);
        options.inJustDecodeBounds = false;
        options.inSampleSize = e(i, i2, iE, iE2);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (bitmapDecodeByteArray == null) {
            return bitmapDecodeByteArray;
        }
        if (bitmapDecodeByteArray.getWidth() <= iE && bitmapDecodeByteArray.getHeight() <= iE2) {
            return bitmapDecodeByteArray;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iE, iE2, true);
        if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
            bitmapDecodeByteArray.recycle();
        }
        return bitmapCreateScaledBitmap;
    }
}
