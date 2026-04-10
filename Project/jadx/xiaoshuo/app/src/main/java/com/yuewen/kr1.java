package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class kr1 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f13589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13590b;

    public kr1() {
        Paint paint = new Paint();
        this.f13589a = paint;
        this.f13590b = 80;
        paint.setAntiAlias(true);
    }

    public void a(Canvas canvas, Rect rect, int i) {
        setBounds(rect);
        c(i);
        draw(canvas);
    }

    public void b(int i) {
        this.f13589a.setColor(i);
    }

    public void c(int i) {
        this.f13590b = i;
    }

    public void d(float f) {
        this.f13589a.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.f13590b;
        if ((i & 80) == 80) {
            float f = bounds.left;
            int i2 = bounds.bottom;
            canvas.drawLine(f, i2, bounds.right, i2, this.f13589a);
        } else if ((i & 48) == 48) {
            float f2 = bounds.left;
            int i3 = bounds.top;
            canvas.drawLine(f2, i3, bounds.right, i3, this.f13589a);
        } else if ((i & 3) == 3) {
            int i4 = bounds.left;
            canvas.drawLine(i4, bounds.top, i4, bounds.bottom, this.f13589a);
        } else if ((i & 5) != 5) {
            canvas.drawLine(bounds.left, bounds.top, bounds.right, bounds.bottom, this.f13589a);
        } else {
            int i5 = bounds.right;
            canvas.drawLine(i5, bounds.top, i5, bounds.bottom, this.f13589a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f13589a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
