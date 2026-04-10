package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RectF f560a;
    private int dl;
    private int g;
    private Paint z;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public dl(int i, int i2) {
        this.dl = i;
        this.g = i2;
        Paint paint = new Paint();
        this.z = paint;
        paint.setColor(0);
        this.z.setAntiAlias(true);
        this.z.setShadowLayer(i2, 0.0f, 0.0f, -16777216);
        this.z.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.g;
        this.f560a = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.f560a;
        int i = this.dl;
        canvas.drawRoundRect(rectF, i, i, this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.z.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.z.setColorFilter(colorFilter);
    }
}
