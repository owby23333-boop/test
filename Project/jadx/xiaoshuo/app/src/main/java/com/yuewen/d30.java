package com.yuewen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes10.dex */
public class d30 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap[] f10075a;

    public d30(Context context, int... iArr) {
        this.f10075a = new Bitmap[iArr.length];
        int i = 0;
        while (true) {
            Bitmap[] bitmapArr = this.f10075a;
            if (i >= bitmapArr.length) {
                return;
            }
            bitmapArr[i] = BitmapFactory.decodeResource(context.getResources(), iArr[i]);
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = 0;
        int height = this.f10075a[0].getHeight();
        int width = this.f10075a[0].getWidth();
        Rect bounds = getBounds();
        int i2 = bounds.top;
        while (i2 < bounds.bottom) {
            int i3 = bounds.left;
            while (i3 < bounds.right) {
                Bitmap[] bitmapArr = this.f10075a;
                Bitmap bitmap = bitmapArr[i % bitmapArr.length];
                if (canvas.getDensity() > 0) {
                    bitmap.setDensity(canvas.getDensity());
                }
                canvas.drawBitmap(bitmap, i3, i2, (Paint) null);
                i3 += width;
                i++;
            }
            i2 += height;
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
