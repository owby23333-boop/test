package com.yuewen;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/* JADX INFO: loaded from: classes5.dex */
public class ni0 extends ci0 {
    public int o;
    public final Paint p;

    public ni0(Activity activity) {
        super(activity);
        this.o = -1;
        Paint paint = new Paint();
        this.p = paint;
        setWillNotDraw(false);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
        } catch (Exception e) {
            qt1.p(e);
        }
        int i = this.o;
        if (i != -1) {
            this.p.setColor(i);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.p);
        }
    }

    public void s(float f, float f2, float f3) {
        this.o = Color.argb(255, Math.round(f * 255.0f), Math.round(f2 * 255.0f), Math.round(f3 * 255.0f));
        invalidate();
    }
}
