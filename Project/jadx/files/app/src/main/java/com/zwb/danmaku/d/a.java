package com.zwb.danmaku.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;

/* JADX INFO: compiled from: BitmapUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static Bitmap a(Context context, @DrawableRes int i2, int i3, int i4) {
        Bitmap bitmapC = c(context, i2, i3, i4);
        return bitmapC == null ? b(context, i2, i3, i4) : bitmapC;
    }

    public static Bitmap b(Context context, int i2, int i3, int i4) {
        Drawable drawable = context.getResources().getDrawable(i2);
        Canvas canvas = new Canvas();
        if (drawable.getIntrinsicWidth() > 0) {
            i3 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i4 = drawable.getIntrinsicHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_4444);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawColor(0);
        drawable.setBounds(0, 0, i3, i4);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap c(Context context, @DrawableRes int i2, int i3, int i4) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i2);
        if (bitmapDecodeResource == null) {
            return null;
        }
        int height = bitmapDecodeResource.getHeight();
        float f2 = height;
        Canvas canvas = new Canvas();
        float f3 = i3 / ((i4 * 1.0f) / f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (0.5f + f3), height, Bitmap.Config.ARGB_4444);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawColor(0);
        try {
            new NinePatch(bitmapDecodeResource, bitmapDecodeResource.getNinePatchChunk(), null).draw(canvas, new RectF(0.0f, 0.0f, f3, f2));
            bitmapDecodeResource.recycle();
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bitmapDecodeResource;
        }
    }
}
