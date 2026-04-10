package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes5.dex */
public class dh3 extends ch3 {
    public float w;
    public RectF x;
    public Paint y;

    public dh3(float f, float f2) {
        super(f, f2);
        m();
    }

    @Override // com.yuewen.ch3
    public void a(Canvas canvas) {
        this.y.setColor(c());
        RectF rectF = this.x;
        float f = this.w;
        canvas.drawArc(rectF, f + 270.0f, 360.0f - f, false, this.y);
        this.y.setColor(d());
        canvas.drawArc(this.x, 270.0f, this.w, false, this.y);
    }

    @Override // com.yuewen.ch3
    public void f(float f) {
        super.f(f);
        this.x = new RectF(b(), b(), getIntrinsicWidth() - b(), getIntrinsicHeight() - b());
    }

    @Override // com.yuewen.ch3
    public void g(float f, float f2) {
        super.g(f, f2);
        this.x = new RectF(b(), b(), f - b(), f2 - b());
    }

    @Override // com.yuewen.ch3
    public void j(int i) {
        super.j(i);
        this.y.setColor(i);
    }

    public void m() {
        l(1);
        this.x = new RectF(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        Paint paint = new Paint();
        this.y = paint;
        paint.setAntiAlias(true);
        this.y.setColor(d());
        this.y.setStyle(Paint.Style.STROKE);
        this.y.setStrokeWidth(this.e * 3);
        this.y.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public void n(float f) {
        this.w = f;
        invalidateSelf();
    }
}
