package com.yuewen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class x93 extends Drawable {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 4;
    public static final int i = 8;
    public static final int j = 15;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f19827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f19828b;
    public int c;
    public Paint d;

    public x93() {
        this(5.0f, 5.0f, -16777216);
    }

    public void a(int i2) {
        this.d.setColor(i2);
    }

    public void b(int i2) {
        this.d.setAlpha(i2);
    }

    public void c(int i2) {
        this.c = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        int i2 = this.c;
        if (i2 == 0) {
            canvas.drawRect(rectF, this.d);
            return;
        }
        if ((i2 & 15) == 15) {
            canvas.drawRoundRect(rectF, this.f19827a, this.f19828b, this.d);
            return;
        }
        float f2 = rectF.left;
        float f3 = this.f19827a;
        float f4 = f2 + f3;
        float f5 = rectF.top;
        float f6 = this.f19828b;
        canvas.drawRect(f4, f5 + f6, rectF.right - f3, rectF.bottom - f6, this.d);
        float f7 = rectF.left;
        float f8 = rectF.top;
        float f9 = this.f19828b;
        canvas.drawRect(f7, f8 + f9, f7 + this.f19827a, rectF.bottom - f9, this.d);
        float f10 = rectF.left;
        float f11 = this.f19827a;
        float f12 = rectF.top;
        canvas.drawRect(f10 + f11, f12, rectF.right - f11, f12 + this.f19828b, this.d);
        float f13 = rectF.left;
        float f14 = this.f19827a;
        float f15 = rectF.bottom;
        canvas.drawRect(f13 + f14, f15 - this.f19828b, rectF.right - f14, f15, this.d);
        float f16 = rectF.right;
        float f17 = f16 - this.f19827a;
        float f18 = rectF.top;
        float f19 = this.f19828b;
        canvas.drawRect(f17, f18 + f19, f16, rectF.bottom - f19, this.d);
        if ((this.c & 1) == 1) {
            canvas.save();
            float f20 = rectF.left;
            float f21 = rectF.top;
            canvas.clipRect(f20, f21, this.f19827a + f20, this.f19828b + f21);
            canvas.drawRoundRect(rectF, this.f19827a, this.f19828b, this.d);
            canvas.restore();
        } else {
            float f22 = rectF.left;
            float f23 = rectF.top;
            canvas.drawRect(f22, f23, f22 + this.f19827a, f23 + this.f19828b, this.d);
        }
        if ((this.c & 2) == 2) {
            canvas.save();
            float f24 = rectF.right;
            float f25 = f24 - this.f19827a;
            float f26 = rectF.top;
            canvas.clipRect(f25, f26, f24, this.f19828b + f26);
            canvas.drawRoundRect(rectF, this.f19827a, this.f19828b, this.d);
            canvas.restore();
        } else {
            float f27 = rectF.right;
            float f28 = f27 - this.f19827a;
            float f29 = rectF.top;
            canvas.drawRect(f28, f29, f27, f29 + this.f19828b, this.d);
        }
        if ((this.c & 4) == 4) {
            canvas.save();
            float f30 = rectF.left;
            float f31 = rectF.bottom;
            canvas.clipRect(f30, f31 - this.f19828b, this.f19827a + f30, f31);
            canvas.drawRoundRect(rectF, this.f19827a, this.f19828b, this.d);
            canvas.restore();
        } else {
            float f32 = rectF.left;
            float f33 = rectF.bottom;
            canvas.drawRect(f32, f33 - this.f19828b, f32 + this.f19827a, f33, this.d);
        }
        if ((this.c & 8) != 8) {
            float f34 = rectF.right;
            float f35 = f34 - this.f19827a;
            float f36 = rectF.bottom;
            canvas.drawRect(f35, f36 - this.f19828b, f34, f36, this.d);
            return;
        }
        canvas.save();
        float f37 = rectF.right;
        float f38 = f37 - this.f19827a;
        float f39 = rectF.bottom;
        canvas.clipRect(f38, f39 - this.f19828b, f37, f39);
        canvas.drawRoundRect(rectF, this.f19827a, this.f19828b, this.d);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        return new x93(this.f19827a, this.f19828b, this.d.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public x93(float f2, float f3, int i2) {
        Paint paint = new Paint();
        this.d = paint;
        this.f19827a = f2;
        this.f19828b = f3;
        paint.setColor(i2);
        this.d.setAntiAlias(true);
        this.c = 15;
    }
}
