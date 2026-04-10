package com.dangdang.zframework.network.image;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class CropDrawableDisplayer implements IBitmapDisplayer {
    private float mHeightY;
    private float mStartX;
    private float mStartY;
    private float mWidthX;

    public CropDrawableDisplayer(float f, float f2) {
        this(f, f2, 0.0f, 1.0f);
    }

    @Override // com.dangdang.zframework.network.image.IBitmapDisplayer
    public Bitmap optionBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        float f = width;
        try {
            try {
                float height = bitmap.getHeight();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (int) (this.mStartX * f), (int) (this.mStartY * height), (int) (f * this.mWidthX), (int) (height * this.mHeightY));
                if (bitmapCreateBitmap != bitmap) {
                }
                return bitmapCreateBitmap;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                bitmap.recycle();
                return null;
            }
        } finally {
            bitmap.recycle();
        }
    }

    public CropDrawableDisplayer(float f, float f2, float f3, float f4) {
        this.mStartX = f;
        this.mWidthX = f2;
        this.mStartY = f3;
        this.mHeightY = f4;
        if (f + f2 > 1.0f || f3 + f4 > 1.0f) {
            throw new IllegalArgumentException("startX+widthX或者startY+heightY的值不能大于1");
        }
    }
}
