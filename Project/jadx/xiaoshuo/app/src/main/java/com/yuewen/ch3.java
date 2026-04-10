package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class ch3 extends Drawable {
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 200;
    public static final int t = 92;
    public static final int u = -1;
    public static final int v = 0;
    public int e;
    public int f;
    public int g;
    public int h;
    public Path l;
    public SweepGradient o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9660a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9661b = -1;
    public int c = 92;
    public int d = 200;
    public Paint i = new Paint();
    public Paint j = new Paint();
    public Paint k = new Paint();
    public Matrix m = new Matrix();
    public Matrix n = new Matrix();
    public int p = 0;

    public ch3(float f, float f2) {
        this.e = Math.round(f);
        this.f = Math.round(f2);
        this.i.setAntiAlias(true);
        this.j.setColor(c());
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public void a(Canvas canvas) {
        int intrinsicWidth = getIntrinsicWidth();
        int intrinsicHeight = getIntrinsicHeight();
        int i = this.p;
        if (i == 0) {
            canvas.drawRect(0.0f, 0.0f, intrinsicWidth, intrinsicHeight, this.k);
        } else {
            if (i != 1) {
                return;
            }
            canvas.drawRect(0.0f, 0.0f, intrinsicWidth, intrinsicHeight, this.j);
        }
    }

    public int b() {
        return this.f9660a;
    }

    public int c() {
        return Color.argb(this.c, Color.red(this.f9661b), Color.green(this.f9661b), Color.blue(this.f9661b));
    }

    public int d() {
        return this.f9661b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int intrinsicWidth = getIntrinsicWidth();
        int intrinsicHeight = getIntrinsicHeight();
        float f = 360.0f / this.d;
        if (this.l == null) {
            this.l = new Path();
            for (int i = 0; i < this.d; i++) {
                this.m.setRotate(f, intrinsicWidth / 2, intrinsicHeight / 2);
                this.l.transform(this.m);
                Path path = this.l;
                int i2 = this.f;
                path.addRect((intrinsicWidth - i2) / 2, this.f9660a, (i2 + intrinsicWidth) / 2, this.e + r5, Path.Direction.CCW);
            }
            this.l.close();
        }
        canvas.save();
        canvas.drawPath(this.l, this.i);
        a(canvas);
        canvas.restore();
    }

    public void e() {
        int iC = c();
        SweepGradient sweepGradient = new SweepGradient(this.g / 2, this.h / 2, new int[]{iC, iC, iC, this.f9661b}, (float[]) null);
        this.o = sweepGradient;
        this.k.setShader(sweepGradient);
    }

    public void f(float f) {
        this.f9660a = Math.round(f);
    }

    public void g(float f, float f2) {
        this.g = Math.round(f);
        this.h = Math.round(f2);
        e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.k.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(float f) {
        this.n.setRotate(f - 90.0f, this.g / 2, this.h / 2);
        this.o.setLocalMatrix(this.n);
    }

    public void i(int i) {
        this.c = i;
        this.j.setColor(c());
        e();
    }

    public void j(int i) {
        this.f9661b = i;
        this.j.setColor(c());
        e();
    }

    public void k(int i) {
        this.d = i;
    }

    public void l(int i) {
        this.p = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.k.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.k.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.k.setDither(z);
    }
}
