package com.bytedance.sdk.component.m.dl.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f765a;
    private final Bitmap.Config dl;
    private final int e;
    private int gc;
    private final ImageView.ScaleType gz;
    private final int m;
    public static final ImageView.ScaleType z = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config g = Bitmap.Config.ARGB_4444;
    private final int fo = 3840;
    private final int uy = 104857600;

    public z(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.dl = config;
        this.f765a = i;
        this.gc = i2;
        this.gz = scaleType;
        this.m = i3;
        this.e = i4;
        z(i, i2);
    }

    static int z(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int z(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
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

    public Bitmap z(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f765a == 0 && this.gc == 0) {
            options.inPreferredConfig = this.dl;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iZ = z(this.f765a, this.gc, i, i2, this.gz);
            int iZ2 = z(this.gc, this.f765a, i2, i, this.gz);
            options.inJustDecodeBounds = false;
            options.inSampleSize = z(i, i2, iZ, iZ2, this.m, this.e);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iZ || bitmapDecodeByteArray.getHeight() > iZ2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iZ, iZ2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void z(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.f765a = 3840;
                this.gc = (i2 * 3840) / i;
                return;
            } else {
                this.f765a = (i * 3840) / i2;
                this.gc = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.f765a = 3840;
            this.gc = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.f765a = (i * 3840) / i2;
            this.gc = 3840;
        }
    }
}
