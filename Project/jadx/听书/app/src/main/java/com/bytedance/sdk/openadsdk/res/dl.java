package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends Drawable {
    private int g;
    private Paint z;

    public dl(int i) {
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
        float f = ((this.g / 2.0f) * 3.0f) / 4.0f;
        float f2 = fCenterX - f;
        float f3 = fCenterY - f;
        float f4 = fCenterX + f;
        float f5 = fCenterY + f;
        canvas.drawLine(f2, f3, f4, f5, this.z);
        canvas.drawLine(f4, f3, f2, f5, this.z);
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
