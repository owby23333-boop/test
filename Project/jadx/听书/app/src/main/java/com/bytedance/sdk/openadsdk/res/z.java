package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class z extends Drawable {
    private float dl;
    private int g;
    private Paint z;

    public z(int i) {
        this.g = i;
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
        this.z.setFilterBitmap(true);
    }

    public void z(int i) {
        this.z.setColor(i);
    }

    public void z(float f) {
        this.z.setStrokeWidth(f);
        this.dl = f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.g) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.g) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fCenterX = getBounds().centerX();
        float fCenterY = getBounds().centerY();
        float f = this.g / 2.0f;
        float f2 = fCenterX - ((3.0f * f) / 4.0f);
        float f3 = fCenterX + (f / 4.0f);
        float f4 = f3 - f2;
        canvas.drawLine(f2, fCenterY + (this.dl / 4.0f), f3, fCenterY - f4, this.z);
        canvas.drawLine(f2, fCenterY - (this.dl / 4.0f), f3, f4 + fCenterY, this.z);
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
