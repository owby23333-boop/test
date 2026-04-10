package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class g extends Drawable {
    private int g;
    private Paint z;

    public g(int i) {
        this.g = i;
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
        this.z.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.g) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.g) * 1.3d);
    }

    public void z(int i) {
        this.z.setColor(i);
    }

    public void z(float f) {
        this.z.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.g / 2.0f, this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.z.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.z.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.z.getAlpha();
    }
}
