package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes12.dex */
public class xx3 extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20156b;
    public final Paint c;
    public String e;
    public int d = 0;
    public int f = -1;
    public int g = 26;
    public int h = 0;
    public int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f20155a = new RectF();

    public xx3() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
    }

    public final float a() {
        Paint paint = this.c;
        paint.setTextSize(this.g);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    public final float b() {
        Paint paint = new Paint();
        paint.setTextSize(this.g);
        return paint.measureText(this.e);
    }

    public final float c() {
        Paint paint = this.c;
        paint.setTextSize(this.g);
        return getBounds().height() - Math.abs(paint.getFontMetrics().descent);
    }

    public void d(int i) {
        this.f20156b = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.c.setColor(this.f20156b);
        RectF rectF = this.f20155a;
        int i = this.d;
        canvas.drawRoundRect(rectF, i, i, this.c);
        float fCenterX = this.f20155a.centerX() - (this.c.measureText(this.e) / 2.0f);
        float fC = c();
        this.c.setColor(this.f);
        canvas.drawText(this.e, fCenterX, fC - this.i, this.c);
    }

    public void e(int i) {
        this.d = i;
    }

    public void f(int i) {
        this.h = i;
    }

    public void g(int i) {
        this.i = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(String str) {
        this.e = str;
        setBounds(0, 0, ((int) b()) + (this.h * 2), ((int) a()) + (this.i * 2));
    }

    public void i(int i) {
        this.f = i;
    }

    public void j(int i) {
        this.g = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f20155a.set(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }
}
