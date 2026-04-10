package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class if1 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f12468a = new Paint();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12469b = 1.0f;
    public int c = 0;
    public int d = 0;
    public int e;

    public if1(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public int b() {
        return (int) this.f12469b;
    }

    public void c(int i) {
        this.e = i;
        invalidateSelf();
    }

    public void d(int i) {
        this.f12469b = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f12468a.setStyle(Paint.Style.STROKE);
        this.f12468a.setStrokeWidth(this.f12469b);
        this.f12468a.setColor(this.e);
        this.f12468a.setAntiAlias(true);
        Rect bounds = getBounds();
        float f = bounds.left + this.c;
        int i = bounds.top;
        float f2 = this.f12469b;
        canvas.drawLine(f, (f2 / 2.0f) + i, bounds.right - this.d, i + (f2 / 2.0f), this.f12468a);
    }

    public void e(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f12469b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f12468a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f12468a.setColorFilter(colorFilter);
    }
}
