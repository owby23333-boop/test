package com.funny.audio.view.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.internal.FastBlur;

/* JADX INFO: loaded from: classes3.dex */
public class BlurTransformation extends BitmapTransformation {
    private static int DEFAULT_DOWN_SAMPLING = 1;
    private static final String ID = "BlurTransformation.1";
    private static int MAX_RADIUS = 25;
    private static final int VERSION = 1;
    private int radius;
    private int sampling;

    public BlurTransformation() {
        this(MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(int radius) {
        this(radius, DEFAULT_DOWN_SAMPLING);
    }

    public BlurTransformation(int radius, int sampling) {
        this.radius = radius;
        this.sampling = sampling;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        int i = this.sampling;
        Bitmap bitmap = pool.get(width / i, height / i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        int i2 = this.sampling;
        canvas.scale(1.0f / i2, 1.0f / i2);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return FastBlur.blur(bitmap, this.radius, true);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.radius + ", sampling=" + this.sampling + ")";
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object o) {
        if (o instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) o;
            if (blurTransformation.radius == this.radius && blurTransformation.sampling == this.sampling) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 589067571 + (this.radius * 1000) + (this.sampling * 10);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.sampling).getBytes(CHARSET));
    }
}
