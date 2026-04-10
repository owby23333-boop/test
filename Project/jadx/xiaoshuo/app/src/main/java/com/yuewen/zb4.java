package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class zb4 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f20731a = new Paint();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f20732b = 1.0f;
    public int c;

    public zb4(int i) {
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
        invalidateSelf();
    }

    public void c(int i) {
        this.f20732b = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f20731a.setStyle(Paint.Style.STROKE);
        this.f20731a.setStrokeWidth(this.f20732b);
        this.f20731a.setColor(this.c);
        int i = getBounds().left;
        float f = this.f20732b;
        canvas.drawLine(i + (f / 2.0f), r0.top, i + (f / 2.0f), r0.bottom, this.f20731a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f20732b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f20731a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f20731a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
