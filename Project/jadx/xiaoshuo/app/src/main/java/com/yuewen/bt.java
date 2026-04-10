package com.yuewen;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: classes5.dex */
public class bt extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f9294b;
    public final RectF c;
    public int d;

    @ColorInt
    public int e;

    public bt(int i, @ColorInt int i2, int i3) {
        Paint paint = new Paint();
        this.f9294b = paint;
        this.c = new RectF();
        this.f9293a = i;
        this.d = i3;
        this.e = i2;
        paint.setColor(i2);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(i);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(Canvas canvas) {
        int i = this.f9293a;
        if (i <= 0 || this.e == 0) {
            return;
        }
        float f = this.d - i;
        canvas.drawRoundRect(this.c, f, f, this.f9294b);
    }

    public void b(int i) {
        this.d = i;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        this.c.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        float f = this.f9293a / 2.0f;
        this.c.inset(f, f);
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.d);
    }
}
