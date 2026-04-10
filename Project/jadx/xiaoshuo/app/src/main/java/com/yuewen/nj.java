package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class nj extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14878b;
    public Paint e;
    public int g;
    public int c = 20;
    public int d = 50;
    public Rect f = new Rect();

    public nj() {
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
    }

    public abstract RectF a();

    public void b(int i) {
        this.e.setColor(i);
    }

    public void c(int i) {
        this.d = i;
    }

    public final void d(int i, int i2) {
        this.f14877a = i;
        this.f14878b = i2;
        f();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.d <= 0) {
            canvas.drawRect(a(), this.e);
            return;
        }
        RectF rectFA = a();
        int i = this.d;
        canvas.drawRoundRect(rectFA, i, i, this.e);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.g = i;
        g(i2, i3, i4);
    }

    public void f() {
        Rect rect = this.f;
        int iMax = Math.max(this.c - this.f14877a, 0);
        int iMax2 = Math.max(this.c - this.f14878b, 0);
        int i = this.c;
        rect.set(iMax, iMax2, this.f14877a + i, i + this.f14878b);
    }

    public void g(int i, int i2, int i3) {
        this.c = i;
        d(i2, i3);
        this.e.setShadowLayer(this.c, i2, i3, this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        rect.set(this.f);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }
}
